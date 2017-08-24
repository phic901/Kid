package com.seoulitelab.kididic.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seoulitelab.kididic.auth.domain.User;

@Controller
public class AuthController {
	
	
	@Autowired
	private Environment env;
	
	
/*	@RequestMapping(value={"/login"}, method={RequestMethod.GET})
	public String loginForm(){
		return "login/loginForm";
	}*/
	
	
	@RequestMapping(value={"/login"}, method={RequestMethod.GET})
	public String loginProcess(Model model,
						HttpSession session,
						HttpServletRequest request,
						HttpServletResponse response,
						String id,
						String password){
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		
		session.setAttribute("user", user);
		return "redirect:/main";
	}
	
	
/*	public String logout(){
		return "";
	}*/
	
	
	

}
