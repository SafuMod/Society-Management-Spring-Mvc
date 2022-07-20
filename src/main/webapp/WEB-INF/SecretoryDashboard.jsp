<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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

<title>Staff Dashboard</title>
<style>
.mainform {
	width: 80%;
	margin: 20px auto;
	box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
	padding:20px;
}
.customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  margin:20px auto;
  width: 80%;
}

.customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

.customers tr:nth-child(even){background-color: #f2f2f2;}

.customers tr:hover {background-color: #ddd;}
.customers tr{
	text-align: center;
}
.customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #072C6F ;
  color: white;
}
</style>
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center">Welcome to Secretory Dashboard</h1>
		<c:set var="user" scope="session" value="${user}" />
		<div class="row">
			<div class="col-md-2">
				<h3 class="text-center">Menu</h3>
				<!--  <form action="saveUser">
					<input type="hidden" value="${user.getUser_id()}" name="user_id">
					<input type="hidden" value="${user.getMobile_no()}" name="mobile_no">
					<input type="hidden" value="${user.getName()}" name="name">
					<input type="hidden" value="${user.getPassword()}" name="password">
					<input type="hidden" value="${user.getRole_id()}" name="role_id">
					<button type="submit">Submit</button>
				</form>-->

				<div class="list-group">
					<a href='<c:url value='/addGuard'></c:url>'
						class="list-group-item list-group-item-action">Add Guard</a> <a
						href='<c:url value='/checkAttendance'></c:url>'
						class="list-group-item list-group-item-action">Check
						Attendance</a> <a href='<c:url value='/checkComplaints'></c:url>'
						class="list-group-item list-group-item-action">Check
						Complaints</a> <a href='<c:url value='/addNotice'></c:url>'
						class="list-group-item list-group-item-action">Publish Notice</a>
						<a href='<c:url value='/logout'></c:url>'
						class="list-group-item list-group-item-action">Log Out</a>


				</div>
			</div>
			<div class="col-md-10">
				<h3 class="text-center">Content</h3>
				<h5 class="text-center">Please click on any menu</h5>

				<c:if test="${page=='addGuard' || page=='SuccessAddedGuard'}">
					<h3 class="text-center">Add Guard Form</h3>
					<form action="saveGuard">
						<div class="mainform">
							<div class="mb-3">
								<label class="form-label">Name</label> <input type="text"
									class="form-control" name="name" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Designation</label> <input type="text"
									class="form-control" name="designation" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Date Of Joining</label> <input
									type="text" class="form-control" name="date_of_joining"
									required>
							</div>

							<button type="submit" class="btn btn-primary text-center">Submit</button>
						</div>
					</form>
					<c:if test="${page=='SuccessAddedGuard'}">
					<h4 class="text-center" style="color: white;font-weight:bold;background-color:lime;width:80%;margin:10px auto;padding:10px;border-radius: 5px;">Guard Added
						Successfully</h4>
				</c:if>
				</c:if>


				

				<c:if test="${page=='checkAttendance'}">
					<h3 class="text-center">Attendance Record</h3>

					<table class="customers">
						<tr>
							<th>Id</th>
							<th>Status</th>
							<th>Date</th>
							<th>Name</th>
						</tr>

						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.getAttendance_id()}</td>
								<c:if test="${item.isAttendance()==true }">
									<td>Present</td>
								</c:if>
								<c:if test="${item.isAttendance()==false }">
									<td>Absent</td>
								</c:if>
								<td>${item.getAttendance_date() }</td>
								<td>${item.getStaff().getName() }</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>

				<c:if test="${page=='checkComplaints'}">
					<h3 class="text-center">Complaints Record</h3>
					<table class="customers">
						<tr>
							<th>Id</th>
							<th>Statement</th>
							<th>Date</th>
							<th>Status</th>
							<th>Name</th>
						</tr>

						<c:forEach items="${complaintList}" var="item">
							<tr>
								<td>${item.getComplaint_id()}</td>
								<td>${item.getStatement()}</td>
								<td>${item.getComplaint_date()}</td>
								<td>${item.getComplaint_status()}</td>
								<td>${item.getUser().getName()}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>

				<c:if test="${page=='addNotice' || page=='SuccessAddedNotice'}">
					<h3 class="text-center">Add Notice Form</h3>
					<form action="saveNotice">
						<div class="mainform">
							<div class="mb-3">
								<label class="form-label">Date</label> <input type="text"
									class="form-control" name="notice_date" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Notice</label> <input type="text"
									class="form-control" name="notice" required>
							</div>
							
							<input type="hidden" value="${user.getUser_id()}" name="user_id">
							<%-- <input type="hidden" value="${user.getMobile_no()}"name="mobile_no"> 
							<input type="hidden" value="${user.getName()}" name="name"> 
							<input type="hidden" value="${user.getPassword()}" name="password">
							<input type="hidden" value="${user.getRole_id()}" name="role_id"> --%>
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
					<c:if test="${page=='SuccessAddedNotice'}">
					<h4 class="text-center" style="color: white;font-weight:bold;background-color:lime;width:80%;margin:10px auto;padding:10px;border-radius: 5px;">Notice Added
						Successfully</h4>
				</c:if>
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