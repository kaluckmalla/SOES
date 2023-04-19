<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Civil Engineering Semester</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="/SOES/css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">
<style>
#link{
background-color: black;
color: white;text-decoration:none;
}
#link:hover{
background-color: red;
}
</style>
</head>
<body>
<div class="container-fluid d-flex justify-content-center bg-warning   "><div class="row col-10 col-sm-10   text-center   ">
<a class="h3  fw-normal mt-3" href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil1stAdd" id="link">1st sem</a>
<a class="h3  fw-normal mt-3" href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil2ndAdd" id="link">2nd sem</a>
<a class="h3  fw-normal mt-3 " href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil3rdAdd" id="link">3rd sem</a>
<a class="h3  fw-normal mt-3 " href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil4thAdd" id="link">4th sem</a>

<a class="h3  fw-normal mt-3 mb-3" href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil5thAdd" id="link">5th sem</a>
<a class="h3  fw-normal mt-3 mb-3" href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil6thAdd" id="link">6th sem</a>
<a class="h3  fw-normal mt-3 mb-3" href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil7thAdd" id="link">7th sem</a>
<a class="h3  fw-normal mt-3 mb-3" href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=civil8thAdd" id="link">8th sem</a>
</div></div>


<!--For Security When Admin login Session is not available then go to Login -->
	<%
	HttpServletResponse httpResponse = (HttpServletResponse) response;

	httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	httpResponse.setHeader("Pragma", "no-cache");
	httpResponse.setDateHeader("Expires", 0);
	if (session.getAttribute("sessionEmail") == null && session.getAttribute("sessionPassword") == null) {
		response.sendRedirect("/SOES/adminlogin.jsp");

	}
	%>
	 <!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="/SOES/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>