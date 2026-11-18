<%--
  Created by IntelliJ IDEA.
  User: busyc
  Date: 13-11-2026
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Book Selection Page</h1>
<form action="SelectBook.action" method="post">
    Select book <p>

    Book:
    <select name="topic" size="1">
        <option value="Java">Java</option>
        <option value="Servlet">Servlet</option>
        <option value="Spring">Spring</option>
    </select>
    <br><br>
    <center>
        <input type="submit">
    </center>
</form>
</body>
</html>
