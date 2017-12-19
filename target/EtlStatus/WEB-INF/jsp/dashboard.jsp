<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h3>DashBoard</h3>
	<table border="1">
		<tr>
			<td><h4>Job Aliases</h4></td>
			<td><h4>Producer Job</h4></td>
			<td><h4>Consumer Job</h4></td>
			<td><h4>Instance Name</h4></td>
			<td><h4>Last Run Time</h4></td>
			<td><h4>Next Run Time</h4></td>
			<td><h4>Last Run Status</h4></td>
			<td><h4>Runs Completed for the Day</h4></td>
			<td><h4>Pending Payloads</h4></td>
			<td><h4>Configurations</h4></td>
			 <td><h4>Trigger Manually</h4></td> 
		</tr>
		<c:forEach var="entry" items="${entries}">
			<tr	style="${entry.last_run_status == 'ERROR' ? 'color: red':'color: green'}">
				<td>
				<c:if test="${empty entry.job_stats_table}">
						${entry.job_aliases}
				</c:if> 
					
				<c:if test="${!empty entry.job_stats_table}">
						<a  href="#" style="${entry.last_run_status == 'ERROR' ? 'color: red':'color: green'}" onclick="loadPath('/load_job_alias_stastics/<c:out value="${entry.job_stats_table}"/>/<c:out value="${entry.job_aliases}"/>/<c:out value="${entry.payload_archive_table}"/>','childDiv')">${entry.job_aliases}</a>
				</c:if>
				</td>
				
				<td>
				<c:if test="${empty entry.producer_job}">
						NOT AVAILABLE
				</c:if> 
				<c:if test="${!empty entry.producer_job}">
						${entry.producer_job}
				</c:if>
				</td>
				<td>
				<c:if test="${empty entry.consumer_job}">
						NOT AVAILABLE
				</c:if> 
				<c:if test="${!empty entry.consumer_job}">
						${entry.consumer_job}
				</c:if>
				</td>
				<td>${entry.instance_name}</td>
				<td>${entry.last_run_time}</td>
				<td>
				<c:if test="${empty entry.next_run_time}">
						NOT AVAILABLE
				</c:if> 
				<c:if test="${!empty entry.next_run_time}">
						${entry.next_run_time}
				</c:if>
				</td>
				<td>${entry.last_run_status}</td>
				<td>${entry.runs_completed_for_day}</td>
				<td>
				<c:if test="${empty entry.payload_queue_table}">
						NOT AVAILABLE
				</c:if> 
				<c:if test="${!empty entry.payload_queue_table}">
						<a href="#" style="${entry.last_run_status == 'ERROR' ? 'color: red':'color: green'}" onclick="loadPath('/load_pending_payload/<c:out value="${entry.payload_queue_table}"/>','childDiv')">Click here</a>
				</c:if>
				</td>
				
				<td>
				<c:if test="${empty entry.job_process_name}">
						NOT AVAILABLE
				</c:if> 
				<c:if test="${!empty entry.job_process_name}">
						<a href="#" style="${entry.last_run_status == 'ERROR' ? 'color: red':'color: green'}" onclick="loadPath('/load_config/<c:out value="${entry.job_aliases}"/>/<c:out value="${entry.job_process_name}"/>/','childDiv')">Click here</a>
				</c:if>
				</td>
				<td><a href="#" style="${entry.last_run_status == 'ERROR' ? 'color: red':'color: green'}" onclick="loadPath('/trigger_job/<c:out value="${entry.job_aliases}"/>/','childDiv')">Trigger Now</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
