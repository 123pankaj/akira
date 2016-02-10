package com.akira.in.services;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

@Service
public class AwsCredential {
	AWSCredentials credentials = null;

	@PostConstruct
	public void loadCredential() {
		try {
			credentials = new ProfileCredentialsProvider().getCredentials();
		} catch (Exception e) {
			throw new AmazonClientException(
					"Cannot load the credentials from the credential profiles file. "
							+ "Please make sure that your credentials file is at the correct "
							+ "location (~/.aws/credentials), and is in valid format.",
					e);
		}

	}

	public AWSCredentials getCredential() {
		return credentials;
	}
}
