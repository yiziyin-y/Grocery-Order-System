package com.neu.edu.yiziyin.controller;

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
import com.neu.edu.yiziyin.dao.UserDAO;
import com.neu.edu.yiziyin.dao.orderDAO;
import com.neu.edu.yiziyin.model.order;
import com.neu.edu.yiziyin.model.user;

@Controller
public class AdminController {
	@GetMapping(value = "manageUser.htm")
    public String checkUser(HttpServletRequest request, ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		UserDAO uDAO = new UserDAO();
		List<user> users = uDAO.getUser();
		modelMap.addAttribute("users", users); 
		return "manageUser";
	}
	
	
	@RequestMapping(value = "deleteUser/{id}.htm", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap modelMap,RedirectAttributes attributes){
		UserDAO uDAO = new UserDAO();
		uDAO.delUser(id);
		
		return "redirect:/manageUser.htm";
	}
	
	@RequestMapping(value = "approve/{id}.htm", method = RequestMethod.GET)
    public String approveUser(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap modelMap,RedirectAttributes attributes){
		UserDAO uDAO = new UserDAO();
		uDAO.updateApprove(id);
		
		return "redirect:/manageUser.htm";
	}
	
	@GetMapping(value = "adminOrder.htm")
    public String checkAdminOrder(HttpServletRequest request, ModelMap modelMap){
		LoginAgent la = LoginAgent.getInstance();
		modelMap.addAttribute("fn", la.getFn()); 
		modelMap.addAttribute("ln", la.getLn());
		modelMap.addAttribute("id", la.getId());
		orderDAO oDao = new orderDAO();
		List<order> oList = oDao.getAllOrder();
		for(order o: oList) {
			o.setProducts(oDao.getOrderDetailbyOrderid(o.getId()));
		}
		modelMap.addAttribute("orders", oList); 
		return "adminOrder";
	}
	
	@RequestMapping(value = "deleteOrder/{id}.htm", method = RequestMethod.GET)
    public String delOrder(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap modelMap,RedirectAttributes attributes){
		orderDAO oDao = new orderDAO();
		oDao.delOrder(id);
		
		return "redirect:/adminOrder.htm";
	}

}
