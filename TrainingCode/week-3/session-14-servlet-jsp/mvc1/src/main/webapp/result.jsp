<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    List<String> booksNameList=(List<String>) request.getAttribute("books");
    for(String bookName: booksNameList){
      out.println(bookName+"<br/>");
    }
  %>
</body>
</html>
