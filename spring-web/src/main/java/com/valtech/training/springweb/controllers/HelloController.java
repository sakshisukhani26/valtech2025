package com.valtech.training.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.springweb.vos.LoginVO;

@Controller
//map pages according to http request. It assumes we have set up a page and it sends the data to the page.
public class HelloController {

	public ModelAndView test() {
		int x=0;
		ModelAndView view = new ModelAndView(x == 0 ? "error" : "login");//we can use this when we dont want to pass the model as args.
		view.addObject("message","Pls use login dialog");
		return view;
	}
	
	@PostMapping("/login")
	public String handleLoginForm(@ModelAttribute LoginVO login,Model model) {
		if(("scott".equals(login.getUsername()))&&("tiger".equals(login.getPassword()))) {
			model.addAttribute("login", login);
			return "dashboard";
		}
		model.addAttribute("message","Invalid username password");
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	//because we dont have a page we wrote this
	public String hello() {
		return "HelloSpringWeb";
	}
}
