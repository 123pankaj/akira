package com.akira.in.controller;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akira.RO.Logs;
import com.akira.RO.ResponseByDates;
import com.akira.RO.StatusByDates;

import com.akira.in.model.AuiCurrent;
import com.akira.in.model.AuiSummary;
import com.akira.in.repository.AuiCurrentRepository;
import com.akira.in.repository.AuiSummaryRepository;
import com.akira.in.services.StoreFormatService;
import com.akira.in.services.SummaryService;
import com.akira.in.util.Constant;

@RestController
@RequestMapping("/logs/")
public class PostLogsController {
	@Resource
	StoreFormatService formatService;
	@Resource
	SummaryService summaryservice;
	
	@Resource
	AuiCurrentRepository a;

	@Resource
	AuiSummaryRepository auisr;
	@RequestMapping(value = { "AUI/upload" }, method = RequestMethod.POST, headers = "content-type!=multipart/form-data")
	public String saveLogsData(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		request.getHeader("content-range");
		request.getHeader("content-length");
		request.getHeader("content-disposition");
		String requestStr = IOUtils.toString(request.getInputStream());
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
			@RequestParam(value = "date", required = false, defaultValue = "2016-01-28") String date ,
			final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<AuiCurrent> auic = formatService.getAUILog(date,pNumber, pSize,order,sortBy);
		long pageSize=formatService.getTotalPages(date, pSize);
		Logs l=new Logs(pageSize,auic);
		System.out.println(pageSize);	
		return l;
	}
	
	@RequestMapping(value = { "summary/get" }, method = RequestMethod.GET)
	@ResponseBody
	public Object getSummaryData(
			@RequestParam(value = "pN", required = false, defaultValue = "0") int pNumber,
			@RequestParam(value = "pS", required = false, defaultValue = "100") int pSize,
			@RequestParam(value = "sB", required = false, defaultValue = "sid") String sortBy,
			@RequestParam(value = "or", required = false, defaultValue = "ASC") String order ,
			@RequestParam(value = "date", required = false, defaultValue = "2016-02-01") String date ,
			final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<AuiSummary> auis = summaryservice.getSummaryLog(date,pNumber, pSize,order,sortBy);
		long pageSize=summaryservice.getTotalPages(date, pSize);
		Logs l=new Logs(pageSize,auis);
		System.out.println(pageSize);	
		return l;
		
		
	}
	
	
	@RequestMapping(value = { "status/get" }, method = RequestMethod.GET)
	@ResponseBody
	public Object getStatusList(
			@RequestParam(value = "url", required = false, defaultValue = "xyz") String url,
final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		StatusByDates statusByDates=new StatusByDates();
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String startDate=df.format(cal.getTime());
		cal.add(Calendar.DATE, -7);
		String endDate=df.format(cal.getTime());
		statusByDates.setDates(summaryservice.dateListByUrlBetweenDates(url, startDate, endDate));
		statusByDates.setNumberOfFailure(summaryservice.failureListByUrlBetweenDates(url, startDate, endDate));
		statusByDates.setNumberOfSuccess(summaryservice.successListByUrlBetweenDates(url, startDate, endDate));
		statusByDates.setNumberOfRedirect(summaryservice.redirectListByUrlBetweenDates(url, startDate, endDate));
		return statusByDates;	
	}
	@RequestMapping(value = { "ResponseTime/get" }, method = RequestMethod.GET)
	@ResponseBody
	public Object getResponseTimeList(
			@RequestParam(value = "url", required = false, defaultValue = "xyz") String url,
final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		ResponseByDates responseBydates=new ResponseByDates();
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String startDate=df.format(cal.getTime());
		cal.add(Calendar.DATE, -7);
		String endDate=df.format(cal.getTime());
		responseBydates.setDates(summaryservice.dateListByUrlBetweenDates(url, startDate, endDate));
		responseBydates.setNumberOfResponseTime(summaryservice.findResponseTimeListByUrlBetweenDates(url, startDate, endDate));
		//statusByDates.setNumberOfRedirect(summaryservice.redirectListByUrlBetweenDates(url, startDate, endDate));
		return responseBydates;	
	}	
	@RequestMapping(value = { "distinctUrl" }, method = RequestMethod.GET)
	@ResponseBody
	public Object getDistinctUrl(
final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String startDate=df.format(cal.getTime());
		cal.add(Calendar.DATE, -7);
		String endDate=df.format(cal.getTime());
	return summaryservice.getDistinctUrl(startDate, endDate);	
	}
	
	

	@RequestMapping(value = { "summary" }, method = RequestMethod.GET)
	@ResponseBody
	public Object summary(
			@RequestParam(value = "date", required = false, defaultValue = "2016-02-01") String date,
final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		long startTime = System.currentTimeMillis();
	AuiSummary auis;
	List<Object[]> aa= a.average();
	List<Object[]>  ss=a.success();
	List<Object[]>  ff=a.failure();
	List<Object[]>  rr=a.redirect();
	
					HashMap<String, Integer> avg=new HashMap<>();
					HashMap<String, Integer> success=new HashMap<>();
					HashMap<String, Integer> failure=new HashMap<>();
					HashMap<String, Integer> redirect=new HashMap<>();
					
				
					
					for(Object[] t:aa){
						avg.put(t[0].toString(), Integer.parseInt(t[1].toString().substring(0, t[1].toString().indexOf("."))));
					}
					
					for(Object[] t:ss){
						success.put(t[0].toString(), Integer.parseInt(t[1].toString()));
					}
					
					for(Object[] t:ff){
						failure.put(t[0].toString(), Integer.parseInt(t[1].toString()));
					}
					
					for(Object[] t:rr){
						redirect.put(t[0].toString(), Integer.parseInt(t[1].toString()));
					}
	
		
		Set<String> urlset=avg.keySet();
		for(String url:urlset){
			auis = new AuiSummary();
			auis.setUrlRequested(url);
			if(success.containsKey(url)){
				auis.setSuccessStatusCode(success.get(url));
			}
			else{
				auis.setSuccessStatusCode(0);
			}
			
			if(failure.containsKey(url)){
				auis.setFailureStatusCode(failure.get(url));
			}
			else{
				auis.setFailureStatusCode(0);
			}
			
			
			if(redirect.containsKey(url)){
				auis.setRedirectStatusCode(redirect.get(url));
			}
			else{
				auis.setRedirectStatusCode(0);
			}
			
			auis.setAverageTimeInMicro(avg.get(url));
			auis.setDate("2016-01-29");
			auisr.saveAndFlush(auis);	
		}
		
		
		
		return  System.currentTimeMillis()-startTime;
	}
	
	
	
	
	
	

}
