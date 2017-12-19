package com.yumecorp.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

public class BusinessEventPojo {
BigInteger etl_alert_id;
String etl_alias_name;
String alert_type;
String alert_details;
String host;
String is_processed;
int root_instance_id;
Timestamp alert_time;
Timestamp delivered_time;
public BigInteger getEtl_alert_id() {
	return etl_alert_id;
}
public void setEtl_alert_id(BigInteger etl_alert_id) {
	this.etl_alert_id = etl_alert_id;
}
public String getEtl_alias_name() {
	return etl_alias_name;
}
public void setEtl_alias_name(String etl_alias_name) {
	this.etl_alias_name = etl_alias_name;
}
public String getAlert_type() {
	return alert_type;
}
public void setAlert_type(String alert_type) {
	this.alert_type = alert_type;
}
public String getAlert_details() {
	return alert_details;
}
public void setAlert_details(String alert_details) {
	this.alert_details = alert_details;
}
public String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public String getIs_processed() {
	return is_processed;
}
public void setIs_processed(String is_processed) {
	this.is_processed = is_processed;
}
public int getRoot_instance_id() {
	return root_instance_id;
}
public void setRoot_instance_id(int root_instance_id) {
	this.root_instance_id = root_instance_id;
}
public Timestamp getAlert_time() {
	return alert_time;
}
public void setAlert_time(Timestamp alert_time) {
	this.alert_time = alert_time;
}
public Timestamp getDelivered_time() {
	return delivered_time;
}
public void setDelivered_time(Timestamp delivered_time) {
	this.delivered_time = delivered_time;
}
@Override
public String toString() {
	return "BusinessEventPojo [etl_alert_id=" + etl_alert_id + ", etl_alias_name=" + etl_alias_name + ", alert_type="
			+ alert_type + ", alert_details=" + alert_details + ", host=" + host + ", is_processed=" + is_processed
			+ ", root_instance_id=" + root_instance_id + ", alert_time=" + alert_time + ", delivered_time="
			+ delivered_time + "]";
}



}
