<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin_Authentication</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<style>
#loginbtn{
background-color:lightgreen;
color:purple;
}
#loginbtn:hover {
	color: white;
	background-color: darkblue;
}
</style>
</head>
<body>
	<%@ include file="header.jsp" %>


	<form   action="LoginServlet" method="post" style="background-color: lightyellow;">

		<div  class="container-fluid d-flex justify-content-center">
		<div class="row text-center col-md-6">
			<h2 class="mt-3 mb-3" style="color: darkblue;">Login to your account</h2>
			<hr>

			<h4 class="text-danger text-break fw-normal fst-italic">
				<%
				String message = (String) request.getAttribute("msg");
				if (message == null) {
					message = "";
				}
				%>
				<%=message%></h4>

			<h3 class="text-success">Email</h3><h4><input type="email" name="email"
					placeholder="Enter email" required></h4>
				<h3 class="text-success mt-3">Password</h3><h4><input  type="password"
					name="password"  placeholder="Enter password"
					 required></h4>
				
				<button class="mt-4 h4" type="submit" id="loginbtn">Login</button>
				
				<h5 class="mb-5">
					Forget password? <a href="forgetpassword.jsp">click here.</a>
				</h5>
</div>

		</div>

	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>