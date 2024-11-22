package com.codewithdurgesh.blog.blog_app_apis.exception;

public class ResourceNotFoundfException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundfException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s: %l", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
	
}

