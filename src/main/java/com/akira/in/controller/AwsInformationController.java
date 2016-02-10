package com.akira.in.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akira.in.services.AwsAutoScalingServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/aws/")
public class AwsInformationController {
	@Resource
	AwsAutoScalingServices awsAutoscaleService;
	@Resource
	ObjectMapper objectMapper;

	@RequestMapping(value = { "autoscalegroup" }, method = RequestMethod.GET)
	public @ResponseBody Object getAllGroupsInformation() throws JsonProcessingException {
		return awsAutoscaleService
				.getAutoscaleGroupInfo();
	}
}
