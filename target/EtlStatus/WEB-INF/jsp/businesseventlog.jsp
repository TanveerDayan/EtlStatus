<html>
<head>
<title>Business Event Log</title>
</head>


<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- <script type="text/javascript">
	function pageLoader(action, div) {
		var path;
		if (action == 'businesseventlog') {
			path = '/businesseventlog';
		} 
		$("#" + div).load(path);
	}
	
	
	$(document).ready(function() {
		pageLoader('businesseventlog','childDiv')
	});
	
	function loadPath(path, div) {
		$("#" + div).load(path);
	}
	
	
	
	

window.userInteractionTimeout = null;
window.userInteractionInHTMLArea = false;
window.onBrowserHistoryButtonClicked = null; // This will be your event handler for browser navigation buttons clicked

$(document).ready(function () {
    $(document).mousedown(function () {
        clearTimeout(window.userInteractionTimeout);
        window.userInteractionInHTMLArea = true;
        window.userInteractionTimeout = setTimeout(function () {
            window.userInteractionInHTMLArea = false;
        }, 500);
    });

$(document).keydown(function () {
        clearTimeout(window.userInteractionTimeout);
        window.userInteractionInHTMLArea = true;
        window.userInteractionTimeout = setTimeout(function () {
            window.userInteractionInHTMLArea = false;
        }, 500);
    });

    if (window.history && window.history.pushState) {
        $(window).on('popstate', function () {
            if (!window.userInteractionInHTMLArea) {
                 pageLoader('loaddashboard','childDiv');
                 }
    if(window.onBrowserHistoryButtonClicked ){
    window.onBrowserHistoryButtonClicked ();
            }
        });
    }
});

	
</script> -->


<body>
	<h2>Business Event Log</h2>


<div>
<h3>ETL ALERT</h3>
<table border="1">
<tr>
<td><h4>ETL Alert ID</h4></td>
<td><h4>ELT Alias Name</h4></td>
<td><h4>Alert Type</h4></td>
<td><h4>Alert Details</h4></td>
<td><h4>Host</h4></td>
<td><h4>Is Processed</h4></td>
<td><h4>Root Instance Id</h4></td>
<td><h4>Alert Time</h4></td>
<td><h4>Delivered Time</h4></td>
</tr>
<c:forEach var="entry" items="${entries}">
<tr>
<td>${entry.etl_alert_id}</td>
<td>${entry.etl_alias_name}</td>
<td>${entry.alert_type}</td>
<td>${entry.alert_details}</td>
<td>${entry.host}</td>
<td>${entry.is_processed}</td>
<td>${entry.root_instance_id}</td>
<td>${entry.alert_time}</td>
<td>${entry.delivered_time}</td>
</tr>
</c:forEach>
</table>
</div>


</body>
</html>