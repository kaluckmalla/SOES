<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@page import="java.util.ArrayList"%>
<%@page import="SqlConn.ConnectionProvider"%>
<%@page import="eventManage.AddPostEventClass"%>
<%@page import="eventManage.AddPostEventDao"%>


<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>All Event List</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">


</head>
<body>

<%@ include file="header.jsp" %>


<div class="container-fluid d-flex justify-content-center" style="background-color: lightyellow;">
		<div class="row col-sm-10">
								<h2 class="text-center text-info bg-dark">ALL EVENT LIST</h2>
		
	<%
	try {
		Connection con = ConnectionProvider.getCon();

		AddPostEventDao epdao = new AddPostEventDao();
		ArrayList<AddPostEventClass> eventpostlist = epdao.getAllPost();

		for (AddPostEventClass alleventlistpage : eventpostlist) {

					%>


		<div class="fst-italic text-decoration-underline text-danger">Published Date : <%=alleventlistpage.getpDate()%></div>
			<div class="h4 fw-bold text-success text-break">Title : <%=alleventlistpage.getpTitle()%></div>
			<div>Start Date : <%=alleventlistpage.getpStartDate()%></div>
			<div>Start Time : <%=alleventlistpage.getpStartTime()%></div>
			<div>End Date : <%=alleventlistpage.getpEndDate()%></div>
			<div>End Time : <%=alleventlistpage.getpEndTime()%></div>
			<div class="h6 text-break">About Event : <%=alleventlistpage.getpDescription()%></div>
			<hr class="mt-3" style="height:.12rem;" />
		

	<%
	
	}
	con.close();
	} catch (Exception e) {
	String resultMessage = "Server error occur : " + e.getMessage();

	request.setAttribute("Message", resultMessage);
	RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
	dispatcher.forward(request, response);
	}
	%></div>
		
	</div>

	<%@ include file="footer.jsp" %>
	
	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>
	
</body>
</html>