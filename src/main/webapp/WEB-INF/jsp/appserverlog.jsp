<!DOCTYPE html>
<html>
<head>
<title>App Server Log</title>
<script src="././js/sockjs-0.3.4.js"></script>
<script src="././js/stomp.js"></script>
<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
    
   
    
    
        var stompClient = null; 
       
      
      $(window).unload(function(){
      		<%session.invalidate();%>
		});
		
        function setConnected(connected) {
        	document.getElementById('connect').disabled = connected;
            document.getElementById('calculationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('calResponse').innerHTML = '';
        }
        function connect() {
       	 	var app_server_name = document.getElementById('app_server_host_name').value;
       	 	var socketURL = document.getElementById('socketURL').value;
       	 	var sessionid=document.getElementById('sessionid').value;
            var socket = new SockJS(socketURL);
			stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/showResult/'+app_server_name+'/'+sessionid, function(calResult){
                	showResult(JSON.parse(calResult.body).result);
                });
                stompClient.send("/calcApp/add/"+app_server_name+"/"+sessionid, {}, JSON.stringify({ 'actionType': 'initAction'}));
            });
            
        }
        function disconnect() {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }
        function showResult(message) {
            var response = document.getElementById('calResponse');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
            window.scrollTo(0,document.body.scrollHeight);
        }
        
        
      	
    </script>
</head>
<body>
	<h1>AppServer Log Tailing</h1>

	<div>
		<div>

			<label>App Server Host Name:</label><input type="text"
				id="app_server_host_name" />
			<button id="connect" onclick="connect();">Connect</button>
		</div>
		<input type="text" id="sessionid" hidden="true"
			value="<%=session.getId()%>" /><br /> 
			
		<input type="text" hidden="true"
			id="socketURL" value="${socketURL}" /><br />
		
		<div id="calculationDiv">
			<p id="calResponse"></p>
		</div>
		

	</div>
</body>
</html>
