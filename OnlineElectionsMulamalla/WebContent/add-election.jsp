<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter New Election</title>
</head>
<body>
<form action = "AddElectionServlet" method= "post">
  Election Name:<input type = "text" name = "electionName">
Candidate1 Name:<input type= "text" name= "candidate1Name">
Candidate2 Name:<input type= "text" name= "candidate2Name">
Candidate3 Name:<input type= "text" name= "candidate3Name">
<input type= "submit" name= "add election">
</form>
</body>
</html>