<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Run Stastics for Alias Name:${job_aliases} and Run Identifier:${run_identifier}</h2>
<div>
<h3>Processed Payloads</h3>
<table border="1">
<tr>
<td><h4>Producer Process</h4></td>
<td><h4>Produer Process Run ID</h4></td>
<td><h4>Consumer Process</h4></td>
<td><h4>Consumer Process Run ID</h4></td>
<td><h4>Status</h4></td>
</tr>
<c:forEach var="entry" items="${processed_payload_entries}">
<tr style="${entry.status == 'ERROR' ? 'color: red':'color: green'}">
<td>${entry.producer_process}</td>
<td>${entry.producer_process_run_id}</td>
<td>${entry.consumer_process}</td>
<td>${entry.consumer_process_run_id}</td>
<td>${entry.status}</td>
</tr>
</c:forEach>
</table>
</div>

<div>
<h3>ETL Process Instance Audit</h3>
<table border="1">
<tr>
<td><h4>ETL Process Instance Id</h4></td>
<td><h4>Start Time</h4></td>
<td><h4>End Time</h4></td>
<td><h4>Aborted Stack Trace</h4></td>
<td><h4>Ip Address</h4></td>
<td><h4>Source Ip Address</h4></td>
<td><h4>Thread Name</h4></td>
</tr>
<c:forEach var="entry" items="${etl_process_instance_entries}">
<tr>
<td>${entry.etl_process_instance_id}</td>
<td>${entry.start_time}</td>
<td>${entry.end_time}</td>
<td>${entry.aborted_stack_trace}</td>
<td>${entry.ip_address}</td>
<td>${entry.source_ip_address}</td>
<td>${entry.threadname}</td>
</tr>
</c:forEach>
</table>
</div>


<div>
<h3>Action Audit</h3>
<table border="1">
<tr>
<td><h4>Action Id</h4></td>
<td><h4>Action Name</h4></td>
<td><h4>Process Name</h4></td>
<td><h4>Start Time</h4></td>
<td><h4>End Time</h4></td>
<td><h4>Time Taken</h4></td>
<td><h4>ETL Process Instance Id</h4></td>
<td><h4>Cfg Type</h4></td>
<td><h4>configuration</h4></td>
</tr>
<c:forEach var="entry" items="${action_audit_entries}">
<tr>
<td>${entry.actionid}</td>
<td>${entry.actionname}</td>
<td>${entry.processname}</td>
<td>${entry.start_time}</td>
<td>${entry.end_time}</td>
<td>${entry.timetaken}</td>
<td>${entry.etl_process_instance_id}</td>
<td>${entry.cfg_type}</td>
<td>${entry.configuration}</td>
</tr>
</c:forEach>
</table>
</div>

<div>
<h3>DML Audit</h3>
<table border="1">
<tr>
<td><h4>DML Action Id</h4></td>
<td><h4>Action Name</h4></td>
<td><h4>Process Name</h4></td>
<td><h4>Start Time</h4></td>
<td><h4>End Time</h4></td>
<td><h4>Time Taken</h4></td>
<td><h4>ETL Process Instance Id</h4></td>
<td><h4>Warning</h4></td>
<td><h4>Rows Processed</h4></td>
<td><h4>No Of Retry</h4></td>
</tr>
<c:forEach var="entry" items="${dml_audit_entries}">
<tr>
<td>${entry.dmlactionid}</td>
<td>${entry.dmlactionid}</td>
<td>${entry.processname}</td>
<td>${entry.start_time}</td>
<td>${entry.end_time}</td>
<td>${entry.timetaken}</td>
<td>${entry.etl_process_instance_id}</td>
<td>${entry.warning}</td>
<td>${entry.rows_processed}</td>
<td>${entry.no_of_retry}</td>
</tr>
</c:forEach>
</table>
</div>