package com.assignment.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class AssignmentConfig {

	private String assignmentServiceUrl;
	private String assignmentServiceName;

	public String getAssignmentServiceUrl() {
		return assignmentServiceUrl;
	}

	public void setAssignmentServiceUrl(String assignmentServiceUrl) {
		this.assignmentServiceUrl = assignmentServiceUrl;
	}

	public String getAssignmentServiceName() {
		return assignmentServiceName;
	}

	public void setAssignmentServiceName(String assignmentServiceName) {
		this.assignmentServiceName = assignmentServiceName;
	}

}
