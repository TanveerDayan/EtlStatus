package com.yumecorp.pojo;

public class PayloadPojo {
String producer_process;
Long producer_process_run_id;
String consumer_process;
Long consumer_process_run_id;
String status;
public String getProducer_process() {
	return producer_process;
}
public void setProducer_process(String producer_process) {
	this.producer_process = producer_process;
}
public Long getProducer_process_run_id() {
	return producer_process_run_id;
}
public void setProducer_process_run_id(Long producer_process_run_id) {
	this.producer_process_run_id = producer_process_run_id;
}
public String getConsumer_process() {
	return consumer_process;
}
public void setConsumer_process(String consumer_process) {
	this.consumer_process = consumer_process;
}
public Long getConsumer_process_run_id() {
	return consumer_process_run_id;
}
public void setConsumer_process_run_id(Long consumer_process_run_id) {
	this.consumer_process_run_id = consumer_process_run_id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "ProcessedPayloadPojo [producer_process=" + producer_process + ", producer_process_run_id="
			+ producer_process_run_id + ", consumer_process=" + consumer_process + ", consumer_process_run_id="
			+ consumer_process_run_id + ", status=" + status + "]";
}




}
