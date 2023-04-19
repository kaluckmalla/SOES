<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Result</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="icon" href="images/soeslogo.jpg">
	
<style>
.message_field {
	background-color:#C3FDB8;
	position: absolute;
	left: 0;
	right: 0;
	margin: auto;
	height: 35rem;
	top: 3rem;
	
	border-radius: 2rem;
	width: 80%;
}

#result_footer {
	position: absolute;
	width: 100%;
	top:41rem;
}
</style>
</head>
<body style="background-color: lightgray;">
	<%@ include file="header.jsp" %>


	<div class="container" style="background-color: lightgreen;">
	<div class="row text-center">
			<h2 class="mt-5 mb-2 " style="color: red; ">Message Field</h2>
		
		<hr style="height: .1rem;color:red; opacity: 5">

			<h3 class="text-break fst-italic fw-normal mt-3 mb-3"style="color: tomato;">
				<%
String message=(String)request.getAttribute("Message");
if(message==null)
{
	message="";
}

%>
				<%=
    message
%></h3>
			<h3 class="mb-4">
				Go to <a href="adminlogin.jsp">Login</a>
			</h3>
		
	</div></div>
		<%@ include file="footer.jsp" %>
	
	
</body>
</html>