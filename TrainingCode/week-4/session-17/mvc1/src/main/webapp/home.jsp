
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Home - BusyCoder Academy</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary">
  <div class="container">
    <a class="navbar-brand" href="#">BusyCoder Academy</a>

    <a href="<c:url value='/logout.action'/>"
       class="btn btn-outline-light">
      Logout
    </a>
  </div>
</nav>

<div class="container mt-5">

  <div class="card shadow-sm">
    <div class="card-body text-center p-5">

      <h1 class="text-success">Welcome Home!</h1>

      <p class="lead mt-3">
        You have successfully logged in.
      </p>

      <h5>Servlet + JSP + JSTL Demo</h5>

      <p class="text-muted">
        Welcome to BusyCoder Academy.
      </p>

    </div>
  </div>

</div>

</body>
</html>
