package com.chen.lottery.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private String[] encryptPropNames =  {"userName", "password"};
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		System.out.println("propertyName = " +propertyName);
		if (isEncryptProp(propertyName)) {
			return propertyValue;
		}
		
		return propertyValue;
	}
	
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : this.encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		
		return false;
	}
}
