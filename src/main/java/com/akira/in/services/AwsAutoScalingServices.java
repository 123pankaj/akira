package com.akira.in.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClient;
import com.amazonaws.services.autoscaling.model.AutoScalingGroup;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsResult;

@Service
public class AwsAutoScalingServices {

	@Resource
	AwsCredential awsCredential;

	public Map<String, List<String>> getAutoscaleGroupInfo() {
		AWSCredentials credential = awsCredential.getCredential();
		AmazonAutoScalingClient autoScaleClient = new AmazonAutoScalingClient(
				credential);
		autoScaleClient.configureRegion(Regions.AP_SOUTHEAST_1);
		DescribeAutoScalingGroupsResult groupDetail = autoScaleClient
				.describeAutoScalingGroups();
		Map<String, List<String>> groupNameMap = new HashMap<String, List<String>>();
		List<String> groupName = new ArrayList<String>();
		for (AutoScalingGroup group : groupDetail.getAutoScalingGroups()) {
			groupName.add(group.getAutoScalingGroupName());
		}
		groupNameMap.put("groups", groupName);
		System.out.println(groupDetail.getAutoScalingGroups().size());
		System.out.println(groupDetail.getAutoScalingGroups().get(0));
		return groupNameMap;
	}

}
