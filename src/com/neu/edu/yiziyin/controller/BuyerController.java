package com.neu.edu.yiziyin.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neu.edu.yiziyin.dao.LoginAgent;
import com.neu.edu.yiziyin.dao.cartDAO;
import com.neu.edu.yiziyin.dao.orderDAO;
import com.neu.edu.yiziyin.dao.productDao;
import com.neu.edu.yiziyin.model.order;
import com.neu.edu.yiziyin.model.orderDetail;
import com.neu.edu.yiziyin.model.product;

@Controller
public class BuyerController {
	@GetMapping(value = "buyerIndex.htm")
    public String buyerIndex(ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		productDao pDao = new productDao();
		List<product> pList= pDao.getProduct();
		modelMap.addAttribute("products", pList); 
		modelMap.addAttribute("cata", "All");
        return "buyerIndex";
    }
	
	@GetMapping(value = "buyerIndexCata.htm")
	public String buyerIndexCata(ModelMap modelMap){
		
        return "buyerIndex";
    }

	@RequestMapping(value = "buyerIndex/{cata}.htm", method = RequestMethod.GET)
    public String buyerIndexByCategory(@PathVariable("cata") String cata,  RedirectAttributes attributes){
		LoginAgent la = LoginAgent.getInstance();
		attributes.addFlashAttribute("fn", la.getFn()); 
		attributes.addFlashAttribute("ln", la.getLn());
		attributes.addFlashAttribute("id", la.getId());
		productDao pDao = new productDao();
		List<product> pList= pDao.getProduct();
		List<product> out = new ArrayList<>();
		for(product p : pList) {
			if(p.getCategory().equals(cata)) {
				out.add(p);
			}
		}
		attributes.addFlashAttribute("products", out); 
		attributes.addFlashAttribute("cata", cata); 
        return "redirect:/buyerIndexCata.htm";
	}
	
	
	@GetMapping(value = "cart.htm")
    public String toCart(ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		cartDAO cDao = cartDAO.getInstance();
		List<product> list = cDao.getList();
	
		modelMap.addAttribute("total", cDao.getTotal()); 
		modelMap.addAttribute("products", list); 
        return "cart";
    }
	
	@RequestMapping(value = "viewProduct/{id}.htm", method = RequestMethod.GET)
    public String viewProduct(@PathVariable("id") Integer id, ModelMap modelMap){
		productDao pDao = new productDao();
		product p = pDao.getProductbyID(id);
		modelMap.addAttribute("product", p); 
		
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());

		return "productDetail";
	}
	
	@RequestMapping(value = "addCart/{id}.htm", method = RequestMethod.GET)
    public String addCart(@PathVariable("id") Integer id,RedirectAttributes attributes){
		productDao pDao = new productDao();
		product p = pDao.getProductbyID(id);
		cartDAO cDao = cartDAO.getInstance();
		if(cDao.getList().size() > 0) {
			for(product pinc :cDao.getList()) {
				int num = 0;
				if(pinc.getId() == id) {
					num = pinc.getNum();
					pinc.setNum(num+1);
					break;
				}else{
					p.setNum(1);
					cDao.add(p);
					break;
				}
				
			}
		}else {
			p.setNum(1);
			cDao.add(p);
		}
		
		List<product> pList= pDao.getProduct();
		attributes.addFlashAttribute("products", pList); 
		attributes.addFlashAttribute("addSuccess", true); 
		
		//redirect:"+"/
		return "redirect:/buyerIndex.htm";
	}
	
	@RequestMapping(value = "delCart/{name}.htm", method = RequestMethod.GET)
    public String delCart(@PathVariable("name") String name, ModelMap modelMap){
		cartDAO cDao = cartDAO.getInstance();
		cDao.delete(name);
		List<product> list = cDao.getList();
		modelMap.addAttribute("products", list); 
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value = "minusNum/{name}.htm", method = RequestMethod.GET)
    public String minusNum(@PathVariable("name") String name, ModelMap modelMap){
		cartDAO cDao = cartDAO.getInstance();
		List<product> list = cDao.getList();
		for(product p: list) {
			if(p.getName().equals(name)) {
				int num = p.getNum();
				p.setNum(num-1);
				break;
			}
			
		}
		modelMap.addAttribute("products", list); 
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value = "plusNum/{name}.htm", method = RequestMethod.GET)
    public String plusNum(@PathVariable("name") String name, ModelMap modelMap){
		cartDAO cDao = cartDAO.getInstance();
		List<product> list = cDao.getList();
		for(product p: list) {
			if(p.getName().equals(name)) {
				int num = p.getNum();
				p.setNum(num+1);
				break;
			}
			
		}
		modelMap.addAttribute("products", list); 
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value = "addOrder.htm", method = RequestMethod.GET)
    public String addOrder(HttpServletRequest request, ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		cartDAO cDao = cartDAO.getInstance();
		modelMap.addAttribute("total", cDao.getTotal()); 
		modelMap.addAttribute("products", cDao.getList());
		
		return "checkOut";
	}
	
	@RequestMapping(value = "postOrder.htm", method = RequestMethod.POST)
    public String postOrder(HttpServletRequest request, ModelMap modelMap,RedirectAttributes attributes){
		cartDAO cDao = cartDAO.getInstance();
		List<product> list = cDao.getList();
		LoginAgent la = LoginAgent.getInstance();
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String memo = request.getParameter("memo");
		String card = request.getParameter("card");
		int ccv = Integer.parseInt(request.getParameter("ccv"));
		String expireDate = request.getParameter("expireDate");
		order order = new order();
		order.setAddress(address);
		order.setCardNum(card);
		order.setCcv(ccv);
		order.setCustomerId(la.getId());
		order.setExpireDate(expireDate);
		order.setFn(la.getFn());
		order.setLn(la.getLn());
		order.setMemo(memo);
		order.setPhone(phone);
		order.setPrice(cDao.getTotal());
		order.setStatus("Submitted");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		order.setTime(date);
		orderDAO oDao = new orderDAO();
		oDao.addOrder(order);
		
		productDao pDao = new productDao();
		orderDetail oDetail = new orderDetail();
		oDetail.setOrderId(order.getId());
		for(product p: list) {
			oDetail.setNum(p.getNum());
			oDetail.setProductId(p.getId());
			oDao.addOrderDetail(oDetail);
			product pdb = pDao.getProductbyID(p.getId());
			int stock = pdb.getStock();
			pDao.updateStock(p.getId(), stock-1);
		}
		cDao.setList(new ArrayList<product>());
		return "redirect:/buyerIndex.htm";
	}
	
	public <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {  
	    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
	    ObjectOutputStream out = new ObjectOutputStream(byteOut);  
	    out.writeObject(src);  

	    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());  
	    ObjectInputStream in = new ObjectInputStream(byteIn);  
	    @SuppressWarnings("unchecked")  
	    List<T> dest = (List<T>) in.readObject();  
	    return dest;  
	}  
	
	@GetMapping(value = "buyerOrder.htm")
    public String buyerOrder(ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		orderDAO oDao = new orderDAO();
		List<order> oList = new ArrayList<>();
		oList =	oDao.getOrderbyUser(la.getId());
		
		for(order o: oList) {
			List<product> plist = new ArrayList<>();
			plist = oDao.getOrderDetailbyOrderid(o.getId());
			
			double total = 0;
			for(product p : plist) {
				total+= p.getPrice() * p.getNum();
			}
			o.setPrice(total);
			o.setProducts(new ArrayList<product>(plist));
			List<product> newlist2 = o.getProducts();
			for(product p: newlist2) {
				System.out.println("ABOVE  name:"+p.getName()+" num:"+p.getNum());
			}
		}
		
		modelMap.addAttribute("orders", oList); 
        return "buyerOrder";
    }
	
	@RequestMapping(value = "cancel/{id}.htm", method = RequestMethod.GET)
    public String cancelOrder(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap modelMap){
		orderDAO oDao = new orderDAO();
		oDao.updateStatus(id, "Canceled");
		return "redirect:"+"/buyerOrder.htm";
	}

}
