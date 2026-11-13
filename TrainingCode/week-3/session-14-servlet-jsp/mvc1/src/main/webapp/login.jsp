
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>BusyCoder - Login</title>

	<!-- Bootstrap 5.3 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		  rel="stylesheet">

	<style>
		body {
			background: #f4f7fb;
			min-height: 100vh;
		}

		.navbar {
			background: #172554;
		}

		.navbar-brand {
			font-weight: 700;
			color: white !important;
		}

		.login-container {
			min-height: 80vh;
			display: flex;
			align-items: center;
			justify-content: center;
		}

		.login-card {
			width: 100%;
			max-width: 420px;
			border: none;
			border-radius: 16px;
			box-shadow: 0 10px 35px rgba(0,0,0,0.08);
		}

		.login-title {
			font-weight: 700;
			color: #172554;
		}

		.btn-login {
			background: #2563eb;
			color: white;
			font-weight: 600;
		}

		.btn-login:hover {
			background: #1d4ed8;
			color: white;
		}

		footer {
			background: #172554;
			color: #cbd5e1;
			padding: 18px;
			text-align: center;
		}
	</style>
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark">
	<div class="container">

		<a class="navbar-brand"
		   href="<c:url value='/'/>">
			BusyCoder Academy
		</a>

		<button class="navbar-toggler"
				type="button"
				data-bs-toggle="collapse"
				data-bs-target="#mainNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="mainNavbar">

			<ul class="navbar-nav me-auto">
				<li class="nav-item">
					<a class="nav-link"
					   href="<c:url value='/listItem.action'/>">
						Items
					</a>
				</li>
			</ul>

			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link"
					   href="<c:url value='/login.jsp'/>">
						Login
					</a>
				</li>
			</ul>

		</div>
	</div>
</nav>


<!-- Login Form -->
<main class="container login-container">

	<div class="card login-card">

		<div class="card-body p-4 p-md-5">

			<h2 class="login-title text-center mb-2">
				Welcome Back!
			</h2>

			<p class="text-secondary text-center mb-4">
				Please login to continue
			</p>

			<!-- Error Message -->
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${errorMessage}"/>
				</div>
			</c:if>

			<form action="login.action" method="post">

				<div class="mb-3">

					<label for="name" class="form-label">
						Username
					</label>

					<input type="text"
						   class="form-control form-control-lg"
						   id="name"
						   name="username"
						   placeholder="Enter your username"
						   autocomplete="username"
						   required>

				</div>


				<div class="mb-4">

					<label for="password" class="form-label">
						Password
					</label>

					<input type="password"
						   class="form-control form-control-lg"
						   id="password"
						   name="password"
						   placeholder="Enter your password"
						   autocomplete="current-password"
						   required>

				</div>


				<button type="submit"
						class="btn btn-login btn-lg w-100">
					Login
				</button>

			</form>

		</div>

	</div>

</main>


<!-- Footer -->
<footer>
	<div class="container">
		&copy; 2026 BusyCoder Academy. All rights reserved.
	</div>
</footer>


<!-- Bootstrap JavaScript Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>
