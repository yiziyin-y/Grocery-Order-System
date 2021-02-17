package com.neu.edu.yiziyin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.neu.edu.yiziyin.dao.UserDAO;
import com.neu.edu.yiziyin.dao.productDao;
import com.neu.edu.yiziyin.model.product;
import com.neu.edu.yiziyin.model.user;
import com.neu.edu.yiziyin.dao.LoginAgent;

@Controller
public class LoginController {

    @GetMapping(value = "index.htm")
    public String index(){
        return "login";
    }
    

    @PostMapping("signup.htm")
    public String signup(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
    	
    	String bors = request.getParameter("bOrs");
    	String fn = request.getParameter("fn");
    	String ln = request.getParameter("ln");
    	String email = request.getParameter("email");
    	String pw = request.getParameter("pw");
    	if(request.getAttribute("unsafe_request") == "true"){
    		modelMap.addAttribute("unsafe", true);
            return "login";
        }
    	UserDAO udao = new UserDAO();
    	List<user> uList = udao.getUser();
    	for(user u:uList) {
    		if(u.getEmail().equals(email)) {
    			modelMap.addAttribute("duplicate", true);
        		return "login";
    		}
    			
    	}
    	user user = new user();
    	user.setBors(bors.trim());
    	user.setFname(fn);
    	user.setLname(ln);
    	user.setEmail(email);
    	user.setPw(pw);
    	if(bors.equals("buyer")) {
    		user.setApproved("T");
    	}else {
    		user.setApproved("F");
    	}
    	UserDAO uDao = new UserDAO();
    	uDao.addUser(user);
    	
        modelMap.addAttribute("regist", true);
        return "login";
    }
    
    @PostMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
            return "login";
    }

    @PostMapping("login.htm")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
    	String email = request.getParameter("email");
    	String pw = request.getParameter("pw");
    	UserDAO userdao = new UserDAO();
    	user user = userdao.checklogin(email, pw);
    	if(user == null) {
    		modelMap.addAttribute("logfail", true);
    		return "login";
    	}else if(user.getApproved().equals("F")){
    		modelMap.addAttribute("notApproved", true);
    		return "login";
    	}else if(user.getBors().equals("buyer")) {
    		modelMap.addAttribute("fn", user.getFname());
    		modelMap.addAttribute("ln", user.getLname());
    		modelMap.addAttribute("id", user.getId());
    		
    		LoginAgent la = LoginAgent.getInstance();
    		la.setBos("buyer");
    		la.setFn(user.getFname());
    		la.setLn(user.getLname());
    		la.setId(user.getId());
    		
    		productDao pDao = new productDao();
    		List<product> pList= pDao.getProduct();
    		modelMap.addAttribute("products", pList); 
    		modelMap.addAttribute("cata", "All"); 
    		return "buyerIndex";
    	}else if(user.getBors().equals("seller")) {
    		modelMap.addAttribute("fn", user.getFname());
    		modelMap.addAttribute("ln", user.getLname());
    		modelMap.addAttribute("id", user.getId());
    		
    		LoginAgent la = LoginAgent.getInstance();
    		la.setBos("seller");
    		la.setFn(user.getFname());
    		la.setLn(user.getLname());
    		la.setId(user.getId());
    		return "sellerIndex";
    	}else if(user.getBors().equals("admin")) {
    		modelMap.addAttribute("fn", user.getFname());
    		modelMap.addAttribute("ln", user.getLname());
    		modelMap.addAttribute("id", user.getId());
    		
    		LoginAgent la = LoginAgent.getInstance();
    		la.setBos("admin");
    		la.setFn(user.getFname());
    		la.setLn(user.getLname());
    		la.setId(user.getId());
    		return "adminIndex";
    	}else {
    		return "login";
    	}
    	
 
    }
}
