package com.akira.in.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akira.in.repository.ProcessFormats;
import com.akira.in.services.StoreFormatService;


@Controller
@RequestMapping("/")
public class HomeController {

	@Resource
	ProcessFormats formatService;
	
	@RequestMapping(value = { "verify" }, method = RequestMethod.POST)
	public ModelAndView getLogFormat(
			@RequestParam(value = "logFormat") String format,
			@RequestParam(value = "testStr") String testStr) {
		Map<String,String> map = formatService.verifyFormat(format,testStr);
		return new ModelAndView("result", "map", map);
	}
}
