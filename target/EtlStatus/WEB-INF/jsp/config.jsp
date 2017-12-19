<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<h3>Process Level Configuration for : ${job_process_name}</h3>
<table border="1">
<tr>
<td><h4>Config Key</h4></td>
<td><h4>Config Value</h4></td>
</tr>
<c:forEach var="entry" items="${process_entries}">
<tr>
<td>${entry.config_key}</td>
<td>${entry.config_value}</td>
</tr>
</c:forEach>
</table>




<h3>Alias Level Configuration for : ${job_aliases}</h3>
<table border="1">
<tr>
<td><h4>Config Key</h4></td>
<td><h4>Config Value</h4></td>
</tr>
<c:forEach var="entry" items="${alias_entries}">
<tr>
<td>${entry.config_key}</td>
<td>${entry.config_value}</td>
</tr>
</c:forEach>
</table>
</div>