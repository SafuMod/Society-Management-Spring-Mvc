<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Owner Dashboard</title>
</head>
<body>

	<div class="container mt-3">
		<h1 class="text-center">Welcome to Owner Dashboard</h1>
		<c:set var="user" scope="session" value="${user}" />
		<div class="row">
			<div class="col-md-2">
				<h3 class="text-center">Menu</h3>

				<div class="list-group">
					<a href='<c:url value='/filecomplaint'></c:url>'
						class="list-group-item list-group-item-action">File Complaint</a>

					<a href='<c:url value='/checksnotice'></c:url>'
						class="list-group-item list-group-item-action">Check Notice</a>

					<button type="button"
						class="list-group-item list-group-item-action">LogOut</button>
				</div>
			</div>
			<div class="col-md-10">
				<c:if test="${page=='filecomplaint'}">
					<form action="addcomplaint">
						<div class="mainform">
							<div class="mb-3">
								<label class="form-label">Write your complaint</label> <input
									type="text" class="form-control" name="statement">
							</div>
							<div class="mb-3">
								<label class="form-label">Select Date</label> <input type="text"
									class="form-control" name="complaint_date">
							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <input type="text"
									class="form-control" name="complaint_status">
							</div>
							<input type="hidden" value="${user.getUser_id()}" name="user_id">
							<button type="submit" class="btn btn-primary">File
								Complaint</button>
						</div>
					</form>
				</c:if>

				<c:if test="${page=='checksnotice'}">
					<table border="1" cellpadding="10" cellspacing="6">
						<tr>
							<th>Notice Id</th>
							<th>Notice</th>
							<th>Date</th>
							<th>Publisher Name</th>
						</tr>
						<c:forEach var="noticeList" items="${list}">
							<tr>
								<td>${noticeList.getNotice_id()}</td>
								<td>${noticeList.getNotice_date()}</td>
								<td>${noticeList.getNotice()}</td>
								<td>${noticeList.getUser().getName()}</td>
						</c:forEach>
					</table>
				</c:if>
			</div>

		</div>
	</div>







	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>