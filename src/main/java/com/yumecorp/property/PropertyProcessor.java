package com.yumecorp.property;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PropertyProcessor {
	@Autowired
	@Qualifier("yumeProperties")
	private Properties yumeProperties;

	public String getProperty(String key) {
		String result = null;
		String rawProperty = yumeProperties.getProperty(key);
		 result=processProperty(rawProperty);
		return result;
	}

	public String processProperty(String propertyValue) {
		Pattern p = Pattern.compile("<([A-Za-z0-9-_]+)>");
		Matcher m = p.matcher(propertyValue);
		while (m.find()) {
			String patternFound = m.group(1);
			propertyValue = propertyValue.replaceAll("<" + patternFound + ">",
					 yumeProperties.get(patternFound).toString());
		}
		return propertyValue;
	}
	


}
