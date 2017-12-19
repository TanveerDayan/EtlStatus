<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<h3>Payload</h3>
<table border="1">
<tr>
<td><h4>Producer Process</h4></td>
<td><h4>Produer Process Run ID</h4></td>
<td><h4>Consumer Process</h4></td>
<td><h4>Consumer Process Run ID</h4></td>
<td><h4>Status</h4></td>
</tr>
<c:forEach var="entry" items="${entries}">
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