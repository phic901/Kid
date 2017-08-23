package com.seoulitelab.kididic.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private Environment env;
	
	
	@ResponseBody
	@RequestMapping("/main")
	public String main(){
		
		System.out.println("member.jdbc.driver : " + env.getProperty("member.jdbc.driver"));
		System.out.println("jdbc.username : " + env.getProperty("jdbc.username"));
		
		return "";
	}
	
	@RequestMapping("/hello")
	public String hello(Model model){
		
		model.addAttribute("name", "alex");
		return "hello";
	}	

}
