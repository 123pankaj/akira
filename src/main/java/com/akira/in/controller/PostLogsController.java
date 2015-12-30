package com.akira.in.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/Logs/")
public class PostLogsController {

	@RequestMapping(value = { "{ID}/upload" }, method = RequestMethod.POST, headers = "content-type!=multipart/form-data")
	public ModelAndView saveLogsData(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		request.getHeader("content-range");
											
		request.getHeader("content-length"); 
		request.getHeader("content-disposition"); 	// filename="Screenshot%20from%202012-12-19%2017:28:01.png"
		String requestStr = IOUtils.toString(request.getInputStream());// actual
																		// content.

		System.out.println(requestStr);
		return null;
	}

}
