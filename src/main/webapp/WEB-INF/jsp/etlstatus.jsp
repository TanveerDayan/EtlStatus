<html>
<head>
<title>ETL Status</title>
</head>


<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	function pageLoader(action, div) {
		var path;
		if (action == 'loaddashboard') {
			path = '/loaddashboard';
		} 
		$("#" + div).load(path);
	}
	
	
	$(document).ready(function() {
		pageLoader('loaddashboard','childDiv')
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



	
</script>


<body>
	<h2>ETL Status page</h2>


	<div id="childDiv"></div>

</body>
</html>