<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.ArrayList,model.Elections" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Voting</title>
</head>
<body>
<%ArrayList<String> allCandidates = (ArrayList<String>) request.getAttribute("candidates");
String myString="";
%>

<form method = "post" action="VoteControllerServlet">
<table border=1 cellpadding=5>
<tr>
<th>selection</th>
<th>Candidates</th>
</tr>
<%
for(int i = 0; i < allCandidates.size(); i++){
%>
<tr>
     <td> <input type = "radio" name="id" value="<%= i %>"> </td>
     <td><%=allCandidates.get(i) %></td>
     </tr>     
<%
}
%>
</table>
<input type= "submit" name = "doThisToItem" value= "vote">
<input type= "submit" name = "doThisToItem" value= "results">
</form>
</body>
</html>