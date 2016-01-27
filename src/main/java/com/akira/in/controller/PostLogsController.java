package com.akira.in.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akira.in.model.AuiCurrent;
import com.akira.in.services.StoreFormatService;
import com.akira.in.util.Constant;
import com.akira.returnobjects.Logs;

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
	@ResponseBody
	public Object getLogsData(
			@RequestParam(value = "pN", required = false, defaultValue = "0") int pNumber,
			@RequestParam(value = "pS", required = false, defaultValue = "100") int pSize,
			@RequestParam(value = "sB", required = false, defaultValue = "id") String sortBy,
			@RequestParam(value = "or", required = false, defaultValue = "ASC") String order ,
			@RequestParam(value = "date", required = false, defaultValue = "") String date ,
			final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<AuiCurrent> auic = formatService.getAUILog(date,pNumber, pSize,order,sortBy);
		int pageSize=formatService.getTotalPages(date, pSize);
		Logs l=new Logs(pageSize,auic);//http://localhost:11011/logs/AUI/get?PageNumber=0&date=2016-01-22&or=ASC&pN=0&pS=100&sB=id
		System.out.println(pageSize);
		
		return l;
	}

}
