package com.akira.in.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akira.in.services.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	
	
	@Resource
	LoginService loginservice;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String redirectToLoginPage() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		String message = "";
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping(value = { "home" }, method = RequestMethod.POST)
	public ModelAndView getUserLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		String message;
		if(!loginservice.loginAllowed(username, password)){
			message= "Credential are not Correct.";
			return new ModelAndView("login", "message", message);
		}
		return new ModelAndView("home");
	}

	
}
