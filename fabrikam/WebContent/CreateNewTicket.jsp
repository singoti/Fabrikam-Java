<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="shortcut icon" href="/Content/images/favicon.ico" /> 	
<title>Home Page</title>
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <meta http-equiv="X-XSS-Protection" content="0" />
    <link href="/Content/style.css" rel="stylesheet" type="text/css" />
    <link href="/Content/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
    <script src="/Scripts/jquery-1.5.1.min.js" type="text/javascript"></script>
    <script src="/Scripts/jQuery.tmpl.min.js" type="text/javascript"></script>
    <script src="/Scripts/knockout-1.2.0.js" type="text/javascript"></script>
    <script src="/Scripts/knockout.mapping-latest.js" type="text/javascript"></script>
    <script src="/Scripts/jquery-ui-1.8.11.js" type="text/javascript"></script>
<%sample%>
    </head>
<body>
<form method="post" action="CreateServiceTickets">
Create
<br/> 
<br/>
<br/>
<br/>
Service Ticket 
<br/>
<br/>
<br/>
Title <br>
<input name="title" type="text" size="90"/>
<br/>
<br/>
<br/>
Escalation Level <br>
<select id="escalation" name="escalation">
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
</select>
<br/><br/>
<br/>

Description<br/>
<textarea rows="10" cols="70"></textarea>
<br/>
<br/>
<br/>
Customer<br/>
<a href="">Select</a>
<br/>
<br/>
<br/>
CreatedBy<br/>
Drew Robbins
<br/>
<br/>
<br/>
<br/>
<input type="submit" name="create" value="Create"/>
</form>
</body>
</html>
