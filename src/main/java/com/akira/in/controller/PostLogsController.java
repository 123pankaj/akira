package com.akira.in.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akira.in.model.AuiCurrent;
import com.akira.in.repository.AuiCurrentRepository;
import com.akira.in.services.StoreFormatService;
import com.akira.in.util.Constant;

@RestController
@RequestMapping("/logs/")
public class PostLogsController {
	@Resource
	StoreFormatService formatService;
	@Resource
	AuiCurrentRepository auirepo;

	@RequestMapping(value = {
			"AUI/upload" }, method = RequestMethod.POST, headers = "content-type!=multipart/form-data")
	public String saveLogsData(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		request.getHeader("content-range");

		request.getHeader("content-length");
		request.getHeader("content-disposition");
		String requestStr = IOUtils.toString(request.getInputStream());
		formatService.analysisFormat(Constant.AUI_FORMAT, requestStr);
		return null;
	}

	@RequestMapping(value = { "AUI/get" }, method = RequestMethod.GET)
	public Object getLogsData(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		int pagenumber = Integer.parseInt(request.getParameter("PageNumber"));

		List<AuiCurrent> auic = formatService.getAUILog( pagenumber);
		return auic;
	}

}
