package com.akira.in.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akira.in.service.StoreFormatService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Resource
	StoreFormatService formatStoreService;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		String message = "";
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
	public ModelAndView getUserLogin() {
		String message = "User";

		return new ModelAndView("home", "message", message);
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
