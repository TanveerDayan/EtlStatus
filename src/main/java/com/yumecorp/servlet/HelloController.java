package com.yumecorp.servlet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.input.Tailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yumecorp.pojo.ActionAuditPojo;
import com.yumecorp.pojo.BusinessEventPojo;
import com.yumecorp.pojo.ConfigPojo;
import com.yumecorp.pojo.DMLAuditPojo;
import com.yumecorp.pojo.DashBoardPojo;
import com.yumecorp.pojo.ETLProcessInstancePojo;
import com.yumecorp.pojo.JobAliasStasticsPojo;
import com.yumecorp.pojo.PayloadPojo;
import com.yumecorp.property.PropertyProcessor;
import com.yumecorp.util.YuMeResultSetUtil;
import com.yumecorp.websocket.CalcInput;
import com.yumecorp.websocket.MyListener;
import com.yumecorp.websocket.Result;

@Controller
public class HelloController {

	@Autowired
	private JdbcTemplate auditJdbcTemplate;

	@Autowired
	private JdbcTemplate triggerJdbcTemplate;

	@Autowired
	private PropertyProcessor propertyProcessor;

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	@Qualifier("yumeProperties")
	private Properties yumeProperties;

	@Autowired
	@Qualifier("envProperties")
	private Properties envProperties;

	@RequestMapping("/welcomepage")
	public String renderWelcomePage(ModelMap model) {

		model.addAttribute("message", "Welcome to Yume ETL - Status Home Page");
		return "welcomepage";
	}

	@RequestMapping("/etlstatus")
	public String renderETLStatus(ModelMap model) {
		return "etlstatus";
	}

	@RequestMapping("/loaddashboard")
	public String renderLoadDashBoard(ModelMap model) {
		List<DashBoardPojo> pojoList = new ArrayList<DashBoardPojo>();
		List<Map<String, Object>> resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("load_dash_board_query"));
		YuMeResultSetUtil.convertListToDashBoardPojo(resultList, pojoList);
		model.addAttribute("entries", pojoList);
		return "dashboard";
	}

	@RequestMapping("/load_job_alias_stastics/{job_stats_table}/{job_aliases}/{payload_archive_table}")
	public String loadJobAliasStastistics(@PathVariable("job_stats_table") String job_stats_table,
			@PathVariable("job_aliases") String job_aliases,
			@PathVariable("payload_archive_table") String payload_archive_table, ModelMap model) {
		List<JobAliasStasticsPojo> pojoList = new ArrayList<JobAliasStasticsPojo>();
		yumeProperties.put("job_alias_stastics_etl_alias_name", job_aliases);
		List<Map<String, Object>> resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("load_job_alias_statistics_query"));
		YuMeResultSetUtil.convertMapToJobAliasStatsticsPojo(resultList, pojoList);
		model.addAttribute("entries", pojoList);
		model.put("alias_name", job_aliases);
		model.put("payload_archive_table", payload_archive_table);
		return "jobaliasstastistics";
	}

	@RequestMapping("/load_run_stastics/{run_identifier}/{payload_archive_table}/{job_aliases}")
	public String loadRunStastistics(@PathVariable("run_identifier") Integer run_identifier,
			@PathVariable("payload_archive_table") String payload_archive_table,
			@PathVariable("job_aliases") String job_aliases, ModelMap model) {
		

		yumeProperties.put("run_statistics_payload_archive_table", payload_archive_table);
		yumeProperties.put("run_statistics_run_identifier", run_identifier);
		
		List<PayloadPojo> payload_entries_pojoList = new ArrayList<PayloadPojo>();
		List<Map<String, Object>> payload_entries_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("run_statistics_payload_entries_query"));
		YuMeResultSetUtil.convertMapToProcessedPayloadPojo(payload_entries_resultList, payload_entries_pojoList);

		List<DMLAuditPojo> dml_audit_entries_pojoList = new ArrayList<DMLAuditPojo>();
		List<Map<String, Object>> dml_audit_entries_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("dml_audit_entries_query"));
		YuMeResultSetUtil.convertMapToDMLAuditPojo(dml_audit_entries_resultList, dml_audit_entries_pojoList);

		List<ActionAuditPojo> action_audit_entries_pojoList = new ArrayList<ActionAuditPojo>();
		List<Map<String, Object>> action_audit_entries_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("action_audit_entries_query"));
		YuMeResultSetUtil.convertMapToActionAuditPojo(action_audit_entries_resultList, action_audit_entries_pojoList);
		
		List<ETLProcessInstancePojo> etl_process_instance_entries_pojoList=new ArrayList<ETLProcessInstancePojo>();
		List<Map<String, Object>> etl_process_instance_entries_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("etl_process_instance_entries_query"));
		YuMeResultSetUtil.convertMapToETLProcessInstancePojo(etl_process_instance_entries_resultList, etl_process_instance_entries_pojoList);
		
		model.addAttribute("processed_payload_entries", payload_entries_pojoList);
		model.addAttribute("dml_audit_entries", dml_audit_entries_pojoList);
		model.addAttribute("action_audit_entries", action_audit_entries_pojoList);
		model.addAttribute("etl_process_instance_entries",etl_process_instance_entries_pojoList);

		model.put("job_aliases", job_aliases);
		model.put("run_identifier", run_identifier);
		return "runstatistics";
	}

	@RequestMapping("/load_pending_payload/{payload_queue_table}")
	public String loadPendingPayload(@PathVariable("payload_queue_table") String payload_queue_table, ModelMap model) {
		List<PayloadPojo> payload_entries_pojoList = new ArrayList<PayloadPojo>();
		yumeProperties.put("pending_payload_queue_table", payload_queue_table);
		List<Map<String, Object>> payload_entries_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("pending_payload_entries_query"));
		YuMeResultSetUtil.convertMapToProcessedPayloadPojo(payload_entries_resultList, payload_entries_pojoList);
		model.addAttribute("entries", payload_entries_pojoList);
		return "payload";
	}

	@RequestMapping("/load_config/{job_aliases}/{job_process_name}/")
	public String loadConfig(@PathVariable("job_aliases") String job_aliases,
			@PathVariable("job_process_name") String job_process_name, ModelMap model) {
		List<ConfigPojo> process_config_pojoList = new ArrayList<ConfigPojo>();
		yumeProperties.put("config_entries_job_process_name", job_process_name);
		yumeProperties.put("config_entries_job_aliases", job_aliases);
		List<Map<String, Object>> process_config_entries_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("process_config_entries_query"));
		YuMeResultSetUtil.convertMapToConfigPojo(process_config_entries_resultList, process_config_pojoList);

		List<ConfigPojo> alias_config_pojoList = new ArrayList<ConfigPojo>();

		List<Map<String, Object>> alias_config_entries_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("alias_config_entries_query"));
		YuMeResultSetUtil.convertMapToConfigPojo(alias_config_entries_resultList, alias_config_pojoList);

		model.addAttribute("process_entries", process_config_pojoList);
		model.addAttribute("alias_entries", alias_config_pojoList);

		model.put("job_aliases", job_aliases);
		model.put("job_process_name", job_process_name);

		return "config";
	}

	@RequestMapping("/trigger_job/{job_aliases}/")
	public String triggerJob(@PathVariable("job_aliases") String job_aliases, ModelMap model) {
		yumeProperties.put("trigger_job_aliases", job_aliases);
		triggerJdbcTemplate.update(propertyProcessor.getProperty("trigger_alias_query"));
		model.put("job_aliases", job_aliases);
		return "trigger";
	}

	@RequestMapping("/businesseventlog")
	public String businessEvent(ModelMap model) {
		List<BusinessEventPojo> businessEventPojoList = new ArrayList<BusinessEventPojo>();
		List<Map<String, Object>> etl_alert_resultList = auditJdbcTemplate
				.queryForList(propertyProcessor.getProperty("business_event_query"));
		YuMeResultSetUtil.convertMapToBusinessEventPojo(etl_alert_resultList, businessEventPojoList);
		model.addAttribute("entries", businessEventPojoList);
		return "businesseventlog";
	}

	@SubscribeMapping("/add/{app_server_name}/{sessionid}")
	@SendTo("/topic/showResult/{app_server_name}/{sessionid}")
	public Result addNum(@DestinationVariable String app_server_name,@DestinationVariable String sessionid, CalcInput input) throws Exception {
		Result result = new Result(app_server_name);
		MyListener listener = new MyListener();
		listener.setTemplate(template);
		listener.setSessionid(sessionid);
		listener.setApp_server_name(app_server_name);
			
		Tailer tailer = new Tailer(new File(envProperties.getProperty("appserverfolderpath") + "/" + app_server_name),
				listener, 5000);
		tailer.run();
		return result;

	}

	@RequestMapping("/appserverlog")
	public String appserverlog(ModelMap model) {
		model.addAttribute("socketURL", envProperties.getProperty("websocketURL"));
		return "appserverlog";
	}

}
