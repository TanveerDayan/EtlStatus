package com.yumecorp.util;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import com.yumecorp.pojo.ActionAuditPojo;
import com.yumecorp.pojo.BusinessEventPojo;
import com.yumecorp.pojo.ConfigPojo;
import com.yumecorp.pojo.DMLAuditPojo;
import com.yumecorp.pojo.DashBoardPojo;
import com.yumecorp.pojo.ETLProcessInstancePojo;
import com.yumecorp.pojo.JobAliasStasticsPojo;
import com.yumecorp.pojo.PayloadPojo;

public class YuMeResultSetUtil {

	public static void convertListToDashBoardPojo(List<Map<String, Object>> resultList,
			List<DashBoardPojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToProcessInstance(keyValMap));
		}
	}

	public static DashBoardPojo convertKeyValToProcessInstance(Map<String, Object> keyValMap) {
		DashBoardPojo dashBoardPojo = new DashBoardPojo();
		dashBoardPojo.setJob_aliases((String) keyValMap.get("job_aliases"));
		dashBoardPojo.setJob_process_name((String) keyValMap.get("process_name"));
		dashBoardPojo.setInstance_name((String) keyValMap.get("instance_name"));
		dashBoardPojo.setProducer_job((String) keyValMap.get("producer_job"));
		dashBoardPojo.setConsumer_job((String) keyValMap.get("consumer_job"));
		dashBoardPojo.setLast_run_time((Timestamp) keyValMap.get("last_run_time"));
		dashBoardPojo.setRuns_completed_for_day((long) keyValMap.get("runs_completed_for_day"));
		dashBoardPojo.setLast_start_time((Timestamp) keyValMap.get("last_start_time"));
		dashBoardPojo.setCron_expression((String) keyValMap.get("cron_expression"));
		dashBoardPojo.setLast_run_status((String) keyValMap.get("last_run_status"));
		if (keyValMap.get("job_stats_table") != null)
			dashBoardPojo.setJob_stats_table((String) keyValMap.get("job_stats_table"));
		if (keyValMap.get("payload_queue_table") != null)
			dashBoardPojo.setPayload_queue_table((String) keyValMap.get("payload_queue_table"));
		dashBoardPojo.setPayload_archive_table((String) keyValMap.get("payload_archive_table"));
		if (dashBoardPojo.getLast_start_time() != null && dashBoardPojo.getCron_expression() != null)
			dashBoardPojo.setNext_run_time(
					getNextRunTime(dashBoardPojo.getLast_start_time(), dashBoardPojo.getCron_expression()));
		return dashBoardPojo;
	}

	public static void convertMapToJobAliasStatsticsPojo(List<Map<String, Object>> resultList,
			List<JobAliasStasticsPojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToJobAliasStatsticsPojo(keyValMap));
		}
	}

	public static JobAliasStasticsPojo convertKeyValToJobAliasStatsticsPojo(Map<String, Object> keyValMap) {
		JobAliasStasticsPojo jobStasticsPojo = new JobAliasStasticsPojo();
		jobStasticsPojo.setRun_identifier((Integer) keyValMap.get("run_identifier"));
		jobStasticsPojo.setStart_time((Timestamp) keyValMap.get("start_time"));
		jobStasticsPojo.setEnd_time((Timestamp) keyValMap.get("end_time"));
		jobStasticsPojo.setStatus((String) keyValMap.get("status"));
		return jobStasticsPojo;
	}

	public static void convertMapToProcessedPayloadPojo(List<Map<String, Object>> resultList,
			List<PayloadPojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToProcessedPayloadPojo(keyValMap));
		}
	}

	public static PayloadPojo convertKeyValToProcessedPayloadPojo(Map<String, Object> keyValMap) {
		PayloadPojo processedPayloadPojo = new PayloadPojo();
		processedPayloadPojo.setConsumer_process((String) keyValMap.get("consumer_process"));
		processedPayloadPojo.setConsumer_process_run_id((Long) keyValMap.get("consumer_process_run_id"));
		processedPayloadPojo.setProducer_process((String) keyValMap.get("producer_process"));
		processedPayloadPojo.setProducer_process_run_id((Long) keyValMap.get("producer_process_run_id"));
		processedPayloadPojo.setStatus((String) keyValMap.get("status"));
		return processedPayloadPojo;
	}

	public static void convertMapToActionAuditPojo(List<Map<String, Object>> resultList,
			List<ActionAuditPojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToActionAuditPojo(keyValMap));
		}
	}

	public static ActionAuditPojo convertKeyValToActionAuditPojo(Map<String, Object> keyValMap) {
		ActionAuditPojo actionAuditPojo = new ActionAuditPojo();

		actionAuditPojo.setActionid((int) keyValMap.get("actionid"));
		actionAuditPojo.setActionname((String) keyValMap.get("actionname"));
		actionAuditPojo.setProcessname((String) keyValMap.get("processname"));
		actionAuditPojo.setStart_time((Timestamp) keyValMap.get("start_time"));
		actionAuditPojo.setEnd_time((Timestamp) keyValMap.get("end_time"));
		actionAuditPojo.setTimetaken((int) keyValMap.get("timetaken"));
		actionAuditPojo.setEtl_process_instance_id((int) keyValMap.get("etl_process_instance_id"));
		actionAuditPojo.setCfg_type((String) keyValMap.get("cfg_type"));
		actionAuditPojo.setConfiguration((String) keyValMap.get("configuration"));
		return actionAuditPojo;
	}

	public static void convertMapToDMLAuditPojo(List<Map<String, Object>> resultList, List<DMLAuditPojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToDMLAuditPojo(keyValMap));
		}
	}

	public static DMLAuditPojo convertKeyValToDMLAuditPojo(Map<String, Object> keyValMap) {
		DMLAuditPojo dmlAuditPojo = new DMLAuditPojo();
		dmlAuditPojo.setDmlactionid((int) keyValMap.get("dmlactionid"));
		dmlAuditPojo.setActionname((String) keyValMap.get("actionname"));
		dmlAuditPojo.setProcessname((String) keyValMap.get("processname"));
		dmlAuditPojo.setStart_time((Timestamp) keyValMap.get("start_time"));
		dmlAuditPojo.setEnd_time((Timestamp) keyValMap.get("end_time"));
		if (keyValMap.get("timetaken") != null)
			dmlAuditPojo.setTimetaken((int) keyValMap.get("timetaken"));
		dmlAuditPojo.setEtl_process_instance_id((int) keyValMap.get("etl_process_instance_id"));
		dmlAuditPojo.setWarning((String) keyValMap.get("warning"));
		if (keyValMap.get("rows_processed") != null)
			dmlAuditPojo.setRows_processed((int) keyValMap.get("rows_processed"));
		dmlAuditPojo.setNo_of_retry((int) keyValMap.get("no_of_retry"));
		return dmlAuditPojo;
	}

	public static void convertMapToETLProcessInstancePojo(List<Map<String, Object>> resultList,
			List<ETLProcessInstancePojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToETLProcessInstancePojo(keyValMap));
		}
	}

	public static ETLProcessInstancePojo convertKeyValToETLProcessInstancePojo(Map<String, Object> keyValMap) {
		ETLProcessInstancePojo etlProcessInstancePojo = new ETLProcessInstancePojo();
		etlProcessInstancePojo.setEtl_process_instance_id((int) keyValMap.get("etl_process_instance_id"));
		etlProcessInstancePojo.setStart_time((Timestamp) keyValMap.get("start_time"));
		etlProcessInstancePojo.setEnd_time((Timestamp) keyValMap.get("end_time"));
		etlProcessInstancePojo.setAborted_stack_trace((String) keyValMap.get("aborted_stack_trace"));
		etlProcessInstancePojo.setIp_address((String) keyValMap.get("ip_address"));
		etlProcessInstancePojo.setSource_ip_address((String) keyValMap.get("source_ip_address"));
		etlProcessInstancePojo.setThreadname((String) keyValMap.get("threadname"));
		return etlProcessInstancePojo;
	}

	public static void convertMapToConfigPojo(List<Map<String, Object>> resultList, List<ConfigPojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToDMLConfigPojo(keyValMap));
		}
	}

	public static ConfigPojo convertKeyValToDMLConfigPojo(Map<String, Object> keyValMap) {
		ConfigPojo configPojo = new ConfigPojo();
		configPojo.setConfig_key((String) keyValMap.get("config_key"));
		configPojo.setConfig_value((String) keyValMap.get("config_value"));
		return configPojo;
	}

	public static Timestamp getNextRunTime(Timestamp last_run_time, String expression) {
		CronTrigger trigger = new CronTrigger(expression);
		SimpleTriggerContext triggerContext = new SimpleTriggerContext();
		triggerContext.update(null, null, last_run_time);
		Date nextFireAt = trigger.nextExecutionTime(triggerContext);

		Timestamp timeStamp = new Timestamp(nextFireAt.getTime());

		return timeStamp;
	}

	public static void convertMapToBusinessEventPojo(List<Map<String, Object>> resultList,
			List<BusinessEventPojo> outputList) {
		for (Map<String, Object> keyValMap : resultList) {
			outputList.add(convertKeyValToBusinessEventPojo(keyValMap));
		}
	}

	public static BusinessEventPojo convertKeyValToBusinessEventPojo(Map<String, Object> keyValMap) {
		BusinessEventPojo businessEventPojo = new BusinessEventPojo();
		businessEventPojo.setEtl_alert_id((BigInteger) keyValMap.get("etl_alert_id"));
		businessEventPojo.setEtl_alias_name((String) keyValMap.get("etl_alias_name"));
		businessEventPojo.setAlert_type((String) keyValMap.get("alert_type"));
		businessEventPojo.setAlert_details((String) keyValMap.get("alert_details"));
		businessEventPojo.setHost((String) keyValMap.get("host"));
		businessEventPojo.setIs_processed((String) keyValMap.get("is_processed"));
		businessEventPojo.setRoot_instance_id((int) keyValMap.get("root_instance_id"));
		businessEventPojo.setAlert_time((Timestamp) keyValMap.get("alert_time"));
		businessEventPojo.setDelivered_time((Timestamp) keyValMap.get("delivered_time"));
		return businessEventPojo;
	}

}
