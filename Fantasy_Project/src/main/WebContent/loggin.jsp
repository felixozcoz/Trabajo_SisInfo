<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">
<title>Signin Template · Bootstrap</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
	<form class="form-signin" method="get" action="signin">
		<img class="mb-4" src="assets/brand/bootstrap-solid.svg" alt=""
			width="72" height="200">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="email" id="inputEmail" name="inputEmail" class="form-control"
				placeholder="Email address" required autofocus> 
		<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" name="inputPassword" class="form-control"
				placeholder="Password" required>
		
				<%--
		
		<c:if test="${requestScope.error ne null}">
		<div class="alert alert-danger">
			<c:out value="${requestScope.error}"/>
		</div>
		</c:if>
		
				--%>

		<% if (request.getAttribute("error") != null) { %> 
		<div class="alert alert-danger">
		<%= request.getAttribute("error") %>
		</div>
		<% } %>
		

		
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
	</form>
</body>
</html>