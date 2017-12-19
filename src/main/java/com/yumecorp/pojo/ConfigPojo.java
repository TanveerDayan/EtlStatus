package com.yumecorp.pojo;

public class ConfigPojo {

	String process_name;
	String alias_name;
	String config_key;
	String config_value;
	String default_value;
	String description;
	public String getProcess_name() {
		return process_name;
	}
	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}
	public String getAlias_name() {
		return alias_name;
	}
	public void setAlias_name(String alias_name) {
		this.alias_name = alias_name;
	}
	public String getConfig_key() {
		return config_key;
	}
	public void setConfig_key(String config_key) {
		this.config_key = config_key;
	}
	public String getConfig_value() {
		return config_value;
	}
	public void setConfig_value(String config_value) {
		this.config_value = config_value;
	}
	public String getDefault_value() {
		return default_value;
	}
	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ConfigPojo [process_name=" + process_name + ", alias_name=" + alias_name + ", config_key=" + config_key
				+ ", config_value=" + config_value + ", default_value=" + default_value + ", description=" + description
				+ "]";
	}
	
	
	
}
