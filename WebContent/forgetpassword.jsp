<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Find your password</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<Style>
#findpassbtn{
background-color:cyan;
color: maroon;
}
#findpassbtn:hover {
	color: red;
	background-color: white;
}
</Style>
</head>

<body>
	<%@ include file="header.jsp" %>

	<form action="Forgetpass" method="post" class="forgetpass" style="background-color: #191970;">
		<div class="container " >
			<div class="row text-center" >
		<h2 class="mt-5 mb-2 " style="color: yellow; ">Forget Password</h2>
		
		<hr style="height: .1rem;color:yellow; opacity: 5">

			<h3 class="mt-3 mb-2" style="color: white;">Enter Email ID</h3><h5><input type="text" name="toAddress"
				pattern=".+@gmail\.com" placeholder="ex: user@gmail.com"
				title="enter your valid email address" required /></h5>
		<h3 class="text-break fst-italic"style="color:lime;">
			<%
			String fpmsg = (String) request.getAttribute("ForgetPasswordMessage");
			if (fpmsg == null) {
				fpmsg = "";
			}
			%>
			<%=fpmsg%></h3>
						<button class="mt-4 mb-4 h4" type="submit" id="findpassbtn">Submit</button>
		
		</div>
		</div>
	</form>
		<%@ include file="footer.jsp" %>
	
	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>
	
	
</body>
</html>