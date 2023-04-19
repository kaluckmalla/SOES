<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Reset your password</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<Style>
#resetpassbtn{
background-color:cyan;
color: maroon;
}
#resetpassbtn:hover {
	color: red;
	background-color: white;
}
</Style>
</head>
<body>
	<%@ include file="adminheader.jsp" %>

<form action="ResetPass" method="post"  style="background-color: #191970;">
		<div class="container " >
			<div class="row text-center" >
		<h2 class="mt-5 mb-2 " style="color: yellow; ">Reset Password</h2>
		
		<hr style="height: .1rem;color:yellow; opacity: 5">

		<h3 class="mt-3 mb-2" style="color: white;">
			Email</h3><h5><input type="email" name="toAddress"
				pattern=".+@gmail\.com" placeholder="ex: user@gmail.com"
				title="enter your registered email address." required /></h5>
		<h3 class="mt-3 mb-2" style="color: white;">
			New password</h3><h5><input type="text" name="newpassword"
				title="enter new strong password." required /></h5>
		<h3 class="mt-3 mb-2" style="color: white;">Confirm new password</h3><h5><input type="text" name="confirmpassword"
				title="enter new password to confirm." required /></h5>
		
		<h3 class="text-break fst-italic"style="color:lime;">
			<%
			String pmsg = (String) request.getAttribute("PasswordMessage");
			if (pmsg == null) {
				pmsg = "";
			}
			%>
			<%=pmsg%></h3>
						<button class="mt-4 mb-4 h4" type="submit" id="resetpassbtn">Submit</button>
		</div>
		</div>
	</form>
		<%@ include file="footer.jsp" %>
<!--For Security When Admin login Session is not available then go to Login -->
	<%
	HttpServletResponse httpResponse = (HttpServletResponse) response;

	httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	httpResponse.setHeader("Pragma", "no-cache");
	httpResponse.setDateHeader("Expires", 0);
	if (session.getAttribute("sessionEmail") == null && session.getAttribute("sessionPassword") == null) {
		response.sendRedirect("adminlogin.jsp");

	}
	%>

		
</body>
</html>