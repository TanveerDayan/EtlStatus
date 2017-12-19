package com.yumecorp.pojo;

import java.sql.Timestamp;

public class DMLAuditPojo {
	String job_alias;
	String run_identifier;
	int dmlactionid;
	String actionname;
	String processname;
	Timestamp start_time;
	Timestamp end_time;
	int timetaken;
	int etl_process_instance_id;
	String warning;
	int rows_processed;
	int no_of_retry;
	public String getJob_alias() {
		return job_alias;
	}
	public void setJob_alias(String job_alias) {
		this.job_alias = job_alias;
	}
	public String getRun_identifier() {
		return run_identifier;
	}
	public void setRun_identifier(String run_identifier) {
		this.run_identifier = run_identifier;
	}
	public int getDmlactionid() {
		return dmlactionid;
	}
	public void setDmlactionid(int dmlactionid) {
		this.dmlactionid = dmlactionid;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getProcessname() {
		return processname;
	}
	public void setProcessname(String processname) {
		this.processname = processname;
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
	public int getTimetaken() {
		return timetaken;
	}
	public void setTimetaken(int timetaken) {
		this.timetaken = timetaken;
	}
	public int getEtl_process_instance_id() {
		return etl_process_instance_id;
	}
	public void setEtl_process_instance_id(int etl_process_instance_id) {
		this.etl_process_instance_id = etl_process_instance_id;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	public int getRows_processed() {
		return rows_processed;
	}
	public void setRows_processed(int rows_processed) {
		this.rows_processed = rows_processed;
	}
	public int getNo_of_retry() {
		return no_of_retry;
	}
	public void setNo_of_retry(int no_of_retry) {
		this.no_of_retry = no_of_retry;
	}
	@Override
	public String toString() {
		return "DMLAuditPojo [job_alias=" + job_alias + ", run_identifier=" + run_identifier + ", dmlactionid="
				+ dmlactionid + ", actionname=" + actionname + ", processname=" + processname + ", start_time="
				+ start_time + ", end_time=" + end_time + ", timetaken=" + timetaken + ", etl_process_instance_id="
				+ etl_process_instance_id + ", warning=" + warning + ", rows_processed=" + rows_processed
				+ ", no_of_retry=" + no_of_retry + "]";
	}




}
