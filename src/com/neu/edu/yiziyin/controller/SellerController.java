package com.neu.edu.yiziyin.controller;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neu.edu.yiziyin.dao.LoginAgent;
import com.neu.edu.yiziyin.dao.orderDAO;
import com.neu.edu.yiziyin.dao.productDao;
import com.neu.edu.yiziyin.model.order;
import com.neu.edu.yiziyin.model.product;


@Controller
public class SellerController {
	@GetMapping(value = "addProduct.htm")
    public String addP(){
        return "addProduct";
    }
	
	@GetMapping(value = "sellerIndex.htm")
    public String sellerIndex(ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
        return "sellerIndex";
    }

	@PostMapping(value = "postProduct.htm")
    public String postProduct(@RequestParam("file") MultipartFile file,HttpServletRequest request, ModelMap modelMap){
		String name = request.getParameter("name");
    	String detail = request.getParameter("detail");
    	String price = request.getParameter("price");
    	String category = request.getParameter("category");
    	int stock = Integer.parseInt(request.getParameter("stock"));
    	product product = new product();
    	product.setName(name);
    	product.setDetail(detail);
    	product.setPrice(Double.parseDouble(price));
    	product.setCategory(category);
    	product.setStock(stock);
    	
    	if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String newfileName = new Date().getTime() + String.valueOf(fileName);
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            // 项目下相对路径
            
            String path = "images\\" + newfileName;

            File tempFile = new File(pathRoot + path);

            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdir();
            }
 
            if (!tempFile.exists()) {
                tempFile.mkdir();
            }
 
            try {
 
                file.transferTo(tempFile);
 
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(path);
            modelMap.addAttribute("basePath", pathRoot); 
            modelMap.addAttribute("fileUrl", path); 
            System.out.println(pathRoot+path);
            product.setFilepath(pathRoot+path);
    	}
    	productDao pDao = new productDao();
    	pDao.addProduct(product);
    	
        return "sellerIndex";
    }
	@RequestMapping(value = "postUpdateProduct/{id}.htm", method = RequestMethod.POST)
    public String postUpdateProduct(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file,HttpServletRequest request, ModelMap modelMap){
		String name = request.getParameter("name");
    	String detail = request.getParameter("detail");
    	String price = request.getParameter("price");
    	String category = request.getParameter("category");
    	int stock = Integer.parseInt(request.getParameter("stock"));
    	product p = new product();
    	p.setName(name);
    	p.setDetail(detail);
    	p.setPrice(Double.parseDouble(price));
    	p.setCategory(category);
    	p.setStock(stock);
    	
    	if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String newfileName = new Date().getTime() + String.valueOf(fileName);
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            // 项目下相对路径
            
            String path = "images\\" + newfileName;

            File tempFile = new File(pathRoot + path);

            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdir();
            }
 
            if (!tempFile.exists()) {
                tempFile.mkdir();
            }
 
            try {
 
                file.transferTo(tempFile);
 
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(path);
            modelMap.addAttribute("basePath", pathRoot); 
            modelMap.addAttribute("fileUrl", path); 
            System.out.println(pathRoot+path);
            p.setFilepath(pathRoot+path);
    	}
    	productDao pDao = new productDao();
    	pDao.updateProduct(id, p);
    	
        return "redirect:"+"/sellerIndex.htm";
    }
	
	@GetMapping(value = "checkProduct.htm")
    public String checkProduct(HttpServletRequest request, ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		
		productDao pDao = new productDao();
		List<product> pList= pDao.getProduct();
		modelMap.addAttribute("products", pList); 
		return "checkProduct";
	}
	
	@RequestMapping(value = "deleteProduct/{id}.htm", method = RequestMethod.GET)
    public String delProduct(@PathVariable("id") Integer id, ModelMap modelMap){
		productDao pDao = new productDao();
		pDao.delProduct(id);
		List<product> pList= pDao.getProduct();
		orderDAO oDao = new orderDAO();
		oDao.delOrderDetailbyPID(id);
		
		modelMap.addAttribute("products", pList);
		return "checkProduct";
	}
	
	@RequestMapping(value = "updateProduct/{id}.htm", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("id") Integer id, ModelMap modelMap){
		productDao pDao = new productDao();
		product p = pDao.getProductbyID(id);
		
		modelMap.addAttribute("product",p);
		return "updateProduct";
	}
	
	@GetMapping(value = "sellerOrder.htm")
    public String checkOrder(HttpServletRequest request, ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		orderDAO oDao = new orderDAO();
		List<order> oList = oDao.getAllOrder();
		for(order o: oList) {
			String card = o.getCardNum();
			o.setCardNum(card.substring(card.length()-4, card.length()));
			o.setProducts(oDao.getOrderDetailbyOrderid(o.getId()));
			double total = 0;
			for(product p :o.getProducts()) {
				total+= p.getPrice() * p.getNum();
			}
			o.setPrice(total);
		}
		
		
		modelMap.addAttribute("orders", oList); 
		return "sellerOrder";
	}
	
	@RequestMapping(value = "confirm/{id}.htm", method = RequestMethod.GET)
    public String confirmOrder(@PathVariable("id") Integer id, ModelMap modelMap){
		orderDAO oDao = new orderDAO();
		oDao.updateStatus(id, "Confirmed");
		return "redirect:"+"/sellerOrder.htm";
	}
	
	@RequestMapping(value = "decline/{id}.htm", method = RequestMethod.GET)
    public String declineOrder(@PathVariable("id") Integer id, ModelMap modelMap){
		orderDAO oDao = new orderDAO();
		oDao.updateStatus(id, "Declined");
		return "redirect:"+"/sellerOrder.htm";
	}
	
	@RequestMapping(value = "complete/{id}.htm", method = RequestMethod.GET)
    public String completeOrder(@PathVariable("id") Integer id, ModelMap modelMap){
		orderDAO oDao = new orderDAO();
		oDao.updateStatus(id, "Completed");
		return "redirect:"+"/sellerOrder.htm";
	}

}
