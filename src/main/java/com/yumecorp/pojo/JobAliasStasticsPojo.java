package com.yumecorp.pojo;

import java.sql.Timestamp;

public class JobAliasStasticsPojo {
String job_alias;
Integer run_identifier;
Timestamp start_time;
Timestamp end_time;
String status;
public String getJob_alias() {
	return job_alias;
}
public void setJob_alias(String job_alias) {
	this.job_alias = job_alias;
}
public Integer getRun_identifier() {
	return run_identifier;
}
public void setRun_identifier(Integer run_identifier) {
	this.run_identifier = run_identifier;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "JobAliasStasticsPojo [job_alias=" + job_alias + ", run_identifier=" + run_identifier + ", start_time="
			+ start_time + ", end_time=" + end_time + ", status=" + status + "]";
}




}
