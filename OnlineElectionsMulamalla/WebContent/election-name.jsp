<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.ArrayList, model.Elections" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Election</title>
</head>
<body>
<%ArrayList<Elections> allElections = (ArrayList<Elections>)request.getAttribute("AllElections");
%>

<form method = "post" action="MasterControllerServlet">
<table border=1 cellpadding=5>
<tr>
<th>selection</th>
<th>Elections</th>
</tr>
<%
for(int i = 0; i < allElections.size(); i++){
%>
<tr>
     <td> <input type = "radio" name="id" value="<%= i %>"> </td>
     <td><%=allElections.get(i).getElectionName() %></td>
     </tr>     
<%
}
%>
</table>
<input type= "submit" name = "doThisToItem" value="Select">
<input type= "submit" name = "doThisToItem" value="Add">
<input type= "submit" name = "doThisToItem" value="Results">
</form>
</body>
</html>