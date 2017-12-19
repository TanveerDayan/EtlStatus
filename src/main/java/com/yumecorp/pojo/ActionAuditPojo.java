package com.yumecorp.pojo;

import java.sql.Timestamp;

public class ActionAuditPojo {
	String job_alias;
	String run_identifier;
	int actionid;
	String actionname;
	String processname;
	Timestamp start_time;
	Timestamp end_time;
	int timetaken;
	int etl_process_instance_id;
	String cfg_type;
	String configuration;
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
	public int getActionid() {
		return actionid;
	}
	public void setActionid(int actionid) {
		this.actionid = actionid;
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
	public String getCfg_type() {
		return cfg_type;
	}
	public void setCfg_type(String cfg_type) {
		this.cfg_type = cfg_type;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	@Override
	public String toString() {
		return "ActionAuditPojo [job_alias=" + job_alias + ", run_identifier=" + run_identifier + ", actionid="
				+ actionid + ", actionname=" + actionname + ", processname=" + processname + ", start_time="
				+ start_time + ", end_time=" + end_time + ", timetaken=" + timetaken + ", etl_process_instance_id="
				+ etl_process_instance_id + ", cfg_type=" + cfg_type + ", configuration=" + configuration + "]";
	}




}
