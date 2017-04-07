<body><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Election Results</title>
</head>
<body>
<% 
String tempid1 = (String)request.getAttribute("electionId");
String tempcand1 = (String)request.getAttribute("c1N");
String tempcand2 = (String)request.getAttribute("c2N");
String tempcand3 = (String)request.getAttribute("c3N");
Integer tempvote1 = (Integer)request.getAttribute("c1V");
Integer tempvote2 = (Integer)request.getAttribute("c2V");
Integer tempvote3 = (Integer)request.getAttribute("c3V");

%>
<form action= "ResultsServlet" method = "post">
<input type= "text" value="<%=tempcand1 %>">
<input type= "text" value="<%=tempcand2 %>">
<input type= "text" value="<%=tempcand3 %>">
<input type= "text" value="<%=tempvote1 %>">
<input type= "text" value="<%=tempvote2 %>">
<input type= "text" value="<%=tempvote3 %>">
</form>
</body>
</html>

