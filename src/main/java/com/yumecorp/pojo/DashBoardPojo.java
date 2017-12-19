package com.yumecorp.pojo;

import java.sql.Timestamp;

public class DashBoardPojo {
	String job_aliases;
	String job_process_name;
	String instance_name;
	String producer_job;
	String consumer_job;
	Timestamp last_run_time;
	Timestamp last_start_time;
	Timestamp next_run_time;
	String last_run_status;
	long runs_completed_for_day;
	int runs_pending_for_day;
	String cron_expression;
	String job_stats_table;
	String payload_queue_table;
	String payload_archive_table;
	public String getJob_aliases() {
		return job_aliases;
	}
	public void setJob_aliases(String job_aliases) {
		this.job_aliases = job_aliases;
	}
	public String getJob_process_name() {
		return job_process_name;
	}
	public void setJob_process_name(String job_process_name) {
		this.job_process_name = job_process_name;
	}
	public String getInstance_name() {
		return instance_name;
	}
	public void setInstance_name(String instance_name) {
		this.instance_name = instance_name;
	}
	public String getProducer_job() {
		return producer_job;
	}
	public void setProducer_job(String producer_job) {
		this.producer_job = producer_job;
	}
	public String getConsumer_job() {
		return consumer_job;
	}
	public void setConsumer_job(String consumer_job) {
		this.consumer_job = consumer_job;
	}
	public Timestamp getLast_run_time() {
		return last_run_time;
	}
	public void setLast_run_time(Timestamp last_run_time) {
		this.last_run_time = last_run_time;
	}
	public Timestamp getLast_start_time() {
		return last_start_time;
	}
	public void setLast_start_time(Timestamp last_start_time) {
		this.last_start_time = last_start_time;
	}
	public Timestamp getNext_run_time() {
		return next_run_time;
	}
	public void setNext_run_time(Timestamp next_run_time) {
		this.next_run_time = next_run_time;
	}
	public String getLast_run_status() {
		return last_run_status;
	}
	public void setLast_run_status(String last_run_status) {
		this.last_run_status = last_run_status;
	}
	public long getRuns_completed_for_day() {
		return runs_completed_for_day;
	}
	public void setRuns_completed_for_day(long runs_completed_for_day) {
		this.runs_completed_for_day = runs_completed_for_day;
	}
	public int getRuns_pending_for_day() {
		return runs_pending_for_day;
	}
	public void setRuns_pending_for_day(int runs_pending_for_day) {
		this.runs_pending_for_day = runs_pending_for_day;
	}
	public String getCron_expression() {
		return cron_expression;
	}
	public void setCron_expression(String cron_expression) {
		this.cron_expression = cron_expression;
	}
	public String getJob_stats_table() {
		return job_stats_table;
	}
	public void setJob_stats_table(String job_stats_table) {
		this.job_stats_table = job_stats_table;
	}
	public String getPayload_queue_table() {
		return payload_queue_table;
	}
	public void setPayload_queue_table(String payload_queue_table) {
		this.payload_queue_table = payload_queue_table;
	}
	public String getPayload_archive_table() {
		return payload_archive_table;
	}
	public void setPayload_archive_table(String payload_archive_table) {
		this.payload_archive_table = payload_archive_table;
	}
	@Override
	public String toString() {
		return "DashBoardPojo [job_aliases=" + job_aliases + ", job_process_name=" + job_process_name
				+ ", instance_name=" + instance_name + ", producer_job=" + producer_job + ", consumer_job="
				+ consumer_job + ", last_run_time=" + last_run_time + ", last_start_time=" + last_start_time
				+ ", next_run_time=" + next_run_time + ", last_run_status=" + last_run_status
				+ ", runs_completed_for_day=" + runs_completed_for_day + ", runs_pending_for_day="
				+ runs_pending_for_day + ", cron_expression=" + cron_expression + ", job_stats_table=" + job_stats_table
				+ ", payload_queue_table=" + payload_queue_table + ", payload_archive_table=" + payload_archive_table
				+ "]";
	}
	
	

}
