package com.career.entity;

public class Assignment {

	private String projectId;
	private String projectName;
	private String projectDetails;
	private String techStack;
	private int companyId;
	private int userId;

	public String getProjectId() {
		return projectId;
	}

	public Assignment setProjectId(String projectId) {
		this.projectId = projectId;
		return this;
	}

	public String getProjectName() {
		return projectName;
	}

	public Assignment setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	public String getProjectDetails() {
		return projectDetails;
	}

	public Assignment setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
		return this;
	}

	public String getTechStack() {
		return techStack;
	}

	public Assignment setTechStack(String techStack) {
		this.techStack = techStack;
		return this;
	}

	public int getCompanyId() {
		return companyId;
	}

	public Assignment setCompanyId(int companyId) {
		this.companyId = companyId;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Assignment setUserId(int userId) {
		this.userId = userId;
		return this;
	}

}
