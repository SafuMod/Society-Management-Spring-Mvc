<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html lang="en">
<head>
<style>
.mainform {
	width: 80%;
	margin: 20px auto;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>SuperAdmin Dashboard</title>
<style>
.success{

color: white;
text-align: center;
margin: 50px;
padding: 10px;
border-radius: 10px;
background-color: lime;	

}

</style>
</head>
<body>

	<div class="container mt-3">
		<h1 class="text-center">Welcome to SuperAdmin Dashboard</h1>
		<div class="row">
			<div class="col-md-2">
				<h3 class="text-center">Menu</h3>

				<div class="list-group">
					<a href='<c:url value='/assignrole'></c:url>'
						class="list-group-item list-group-item-action">Assign Secretory</a>
					<button type="button"
						class="list-group-item list-group-item-action">LogOut</button>
				</div>
			</div>
			<div class="col-md-10">
				<h3 class="text-center"></h3>
				<c:if test="${(page=='assignrole')||(page=='successmessage')}">
					<h3 class="text-center">Assign Role</h3>
					<form action="assignroleform">
						<div class="mainform">
						  <div class="mb-3">
						    <label class="form-label">Enter UserId</label>
						    <input type="text" class="form-control" name="id">
						  </div>
						  <button style="margin:20px 0 0 45%;" type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
					<c:if test="${page=='successmessage'}">
					<h4 class="success">Role Assigned Successfully</h4>
					</c:if>
				</c:if>
	
			</div>
			</div>
			</div>

</body>
</html>