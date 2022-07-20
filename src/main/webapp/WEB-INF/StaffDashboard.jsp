	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

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
<style>
.buttons {
	width: 60%;
	margin: 5%;
	margin-left: 20%;
	display: flex;
}

#pbutton {
	width: 50%;
}

#nbutton {
	width: 50%;
	margin-left: 10px;
}
</style>
<title>Staff Dashboard</title>
</head>
<body>

	<div class="container mt-3">
		<h1 class="text-center">Welcome to Staff Dashboard</h1>
		<div class="row">
			<div class="col-md-2">
				<h3 class="text-center">Menu</h3>

				<div class="list-group">
					<a href='<c:url value='/setattendance'></c:url>'
						class="list-group-item list-group-item-action">Mark Attendance</a>

					<a href='<c:url value='/getattendance'></c:url>'
						class="list-group-item list-group-item-action">Check
						Attendance</a> <a href='<c:url value='/getnotice'></c:url>'
						class="list-group-item list-group-item-action">Check Notice</a>

					<button type="button"
						class="list-group-item list-group-item-action">LogOut</button>
				</div>
			</div>
			<div class="col-md-10">
				<h3 class="text-center">Content</h3>


				<!-- Mark Attendance -->

				<c:if test="${page=='setattendance'}">

					<form action="markattendance">
						
						<input type="hidden" value="true" name="attendance"/>

						<div class="mb-3">
							<label class="form-label">Date</label> <input type="text"
								name="attendance_date" class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Staff Id</label> <input type="text"
								name="staff_id" class="form-control">
						</div>

						<h5 class="text-center">Do you really want to mark attendance</h5>
						
						<div class="buttons">
							<button type="submit" id="pbutton" class="btn btn-success">Present</button>
							<button type="reset" id="nbutton" class="btn btn-danger " onClick="window.location.reload();">No Change</button>
						</div>

					</form>
							
				</c:if>


				<!-- Check Attendance -->


				<c:if test="${page=='getattendance'}">
					<form action="checkattendance">
						<div class="mb-3">
							<label class="form-label">Staff Id</label> <input type="text"
								name="staff_id" class="form-control">
						</div>
						<button type="submit" class="btn btn-primary "
							style="margin-left: 40%">Submit</button>
					</form>

				</c:if>
				<c:if test="${page=='checksattendance'}">

					<table border="1" cellpadding="10" cellspacing="6">
						<tr>
							<th>Attendance_Id</th>
							<th>Attendance</th>
							<th>Date</th>
							<th>Staff_Name</th>
						</tr>
						<c:forEach var="attList" items="${list}">
							<tr>
								<td><c:out value="${attList.getAttendance_id()}" /></td>
								<td><c:out value="${attList.isAttendance()}" /></td>
								<td><c:out value="${attList.getAttendance_date()}" /></td>
								<td><c:out value="${attList.getStaff().getName()}" /></td>
						</c:forEach>
					</table>
				</c:if>

				<!-- Check Notice -->

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