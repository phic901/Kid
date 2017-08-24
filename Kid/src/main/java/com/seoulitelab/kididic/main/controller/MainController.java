package com.seoulitelab.kididic.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seoulitelab.kididic.auth.domain.User;

@Controller
public class MainController {
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping("/main")
	public String main(Model model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response){
		
		User user = (User)session.getAttribute("user");
		
		model.addAttribute("id", user.getId());
		model.addAttribute("password", user.getPassword());
		
		return "main";
	}
	
	
	
	@RequestMapping("/hello")
	public String hello(Model model){
		
		model.addAttribute("name", "alex");
		return "hello";
	}	

}
