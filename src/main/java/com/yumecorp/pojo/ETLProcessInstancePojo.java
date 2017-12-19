package com.yumecorp.pojo;

import java.sql.Timestamp;

public class ETLProcessInstancePojo {
int etl_process_instance_id;
Timestamp start_time;
Timestamp end_time;
String aborted_stack_trace;
String ip_address;
String source_ip_address;
String threadname;
public int getEtl_process_instance_id() {
	return etl_process_instance_id;
}
public void setEtl_process_instance_id(int etl_process_instance_id) {
	this.etl_process_instance_id = etl_process_instance_id;
}
public Timestamp getStart_time() {
	return start_time;
}
public void setStart_time(Timestamp start_time) {
	this.start_time = start_time;
}
public Timestamp getEnd_time() {
	return end_time;
}
public void setEnd_time(Timestamp end_time) {
	this.end_time = end_time;
}

public String getAborted_stack_trace() {
	return aborted_stack_trace;
}
public void setAborted_stack_trace(String aborted_stack_trace) {
	this.aborted_stack_trace = aborted_stack_trace;
}
public String getIp_address() {
	return ip_address;
}
public void setIp_address(String ip_address) {
	this.ip_address = ip_address;
}
public String getSource_ip_address() {
	return source_ip_address;
}
public void setSource_ip_address(String source_ip_address) {
	this.source_ip_address = source_ip_address;
}
public String getThreadname() {
	return threadname;
}
public void setThreadname(String threadname) {
	this.threadname = threadname;
}
@Override
public String toString() {
	return "ETLProcessInstancePojo [etl_process_instance_id=" + etl_process_instance_id + ", start_time=" + start_time
			+ ", end_time=" + end_time + ", aborted_stack_trace=" + aborted_stack_trace + ", ip_address=" + ip_address
			+ ", source_ip_address=" + source_ip_address + ", threadname=" + threadname + "]";
}




}
