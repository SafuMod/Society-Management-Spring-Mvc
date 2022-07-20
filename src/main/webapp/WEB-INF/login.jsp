<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.mainform{
	width: 80%;
	margin: 50px auto;
}

.form-label{
	color: navy;
}

</style>
</head >
<body>
<h2 style="text-align: center;margin-top: 20px;color: navy;">Welcome to login</h2>
<form action="userlogin">
<div class="mainform">
  <div class="mb-3">
    <label class="form-label">Mobile Number</label>
    <input type="text" class="form-control" name="mobile_no" >
  </div>
  <div class="mb-3">
    <label class="form-label">Password</label>
    <input type="password" class="form-control" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</div>
</form>

</body>
</html>