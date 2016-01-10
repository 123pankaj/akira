package com.akira.in.controller;

import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akira.in.services.StoreFormatService;
import com.akira.in.util.Constant;

@Controller
@RequestMapping("/logs/")
public class PostLogsController {
	@Resource
	StoreFormatService formatService;

	@RequestMapping(value = { "{ID}/upload" }, method = RequestMethod.POST, headers = "content-type!=multipart/form-data")
	public ModelAndView saveLogsData(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		request.getHeader("content-range");

		request.getHeader("content-length");
		request.getHeader("content-disposition"); // filename="Screenshot%20from%202012-12-19%2017:28:01.png"
		String requestStr = IOUtils.toString(request.getInputStream());// actual
		StringTokenizer st = new StringTokenizer(requestStr, "\n");
		String firstLine=st.nextToken();
		System.out.println("Analysing : " + firstLine);
		formatService.analysisFormat(Constant.AUI_FORMAT, firstLine);
		return null;
	}

}
