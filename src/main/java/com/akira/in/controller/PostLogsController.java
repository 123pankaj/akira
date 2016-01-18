package com.akira.in.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akira.in.model.AuiCurrent;
import com.akira.in.services.StoreFormatService;
import com.akira.in.util.Constant;

@RestController
@RequestMapping("/logs/")
public class PostLogsController {
	@Resource
	StoreFormatService formatService;

	@RequestMapping(value = { "AUI/upload" }, method = RequestMethod.POST, headers = "content-type!=multipart/form-data")
	public String saveLogsData(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		request.getHeader("content-range");
		request.getHeader("content-length");
		request.getHeader("content-disposition");
		String requestStr = IOUtils.toString(request.getInputStream());
		System.out.println("*************");
		System.out.println(requestStr);
		formatService.analysisFormat(Constant.AUI_FORMAT, requestStr);
		return null;
	}

	@RequestMapping(value = { "AUI/get" }, method = RequestMethod.GET)
	public Object getLogsData(
			@RequestParam(value = "PageNumber", required = false, defaultValue = "0") int pNumber,
			@RequestParam(value = "pS", required = false, defaultValue = "100") int pSize,
			final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<AuiCurrent> auic = formatService.getAUILog(pNumber, pSize);
		return auic;
	}

}
