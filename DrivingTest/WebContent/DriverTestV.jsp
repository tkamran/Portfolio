<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Driver Test</title>
</head>
<body>
<%=(String)request.getAttribute("desc")%></br>
1. <%=(String)request.getAttribute("answerA")%></br>
2. <%=(String)request.getAttribute("answerB")%></br>
3. <%=(String)request.getAttribute("answerC")%></br>
Correct Answer: <%=(String)request.getAttribute("correctOption")%></br></br>
<a href="<%=(String)request.getAttribute("link")%>">Next</a>
</body>
</html>