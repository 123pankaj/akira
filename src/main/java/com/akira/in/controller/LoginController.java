package com.akira.in.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akira.in.services.LoginService;
import com.akira.in.services.StoreFormatService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Resource
	StoreFormatService formatStoreService;
	
	@Resource
	LoginService loginservice;

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

	@RequestMapping(value = { "store" }, method = RequestMethod.POST)
	public ModelAndView getLogFormat(
			@RequestParam(value = "logFormat") String format,
			@RequestParam(value = "testStr") String testStr) {
		String message = "";
		formatStoreService.analysisFormat(format,testStr);
		return new ModelAndView("result", "message", message);
	}
}
