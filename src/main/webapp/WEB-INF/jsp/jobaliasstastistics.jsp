<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<h3>Job Alias Stastics for ${alias_name}</h3>
<table border="1">
<tr>
<td><h4>Run Identifier</h4></td>
<td><h4>Start Time</h4></td>
<td><h4>End Time</h4></td>
<td><h4>Status</h4></td>
</tr>
<c:forEach var="entry" items="${entries}">
<tr style="${entry.status == 'ERROR' ? 'color: red':'color: green'}">
<td><a href="#" style="${entry.status == 'ERROR' ? 'color: red':'color: green'}" onclick="loadPath('/load_run_stastics/<c:out value="${entry.run_identifier}"/>/<c:out value="${payload_archive_table}"/>/<c:out value="${alias_name}"/>','childDiv')">${entry.run_identifier}</a></td>
<td>${entry.start_time}</td>
<td>${entry.end_time}</td>
<td>${entry.status}</td>
</tr>
</c:forEach>
</table>
</div>