package org.ogm.crazyproxy.api.model;

public class Info {
	private String target = null;
	private Long request = null;
	private Long errorThreshold = null;
	private Long delay = null;
	private Long executionTime = null;
	private Long errors = null;


	public Long getErrors() {
		return errors;
	}

	public void setErrors(Long errors) {
		this.errors = errors;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public Info() {}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	
	public Long getErrorThreshold() {
		return errorThreshold;
	}

	public void setErrorThreshold(Long errorThreshold) {
		this.errorThreshold = errorThreshold;
	}

	public Long getRequest() {
		return request;
	}

	public void setRequest(Long request) {
		this.request = request;
	}
}
