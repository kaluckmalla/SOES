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

<title>Action on Post Event</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="/SOES/css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<!-- Used by hide element by id when there is no data -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style type="text/css">
#searchbtn {
	background-color: lightgreen;
	color: purple;
}

#searchbtn:hover {
	color: white;
	background-color: darkblue;
}

#inputfieldForDeleteBtn {
	color: maroon;
	background-color: yellow;
}

#inputfieldForDeleteBtn:hover {
	color: white;
	background-color: darkblue;
}
</style>

</head>
<body>

	<form method="post" action="/SOES/SearchEventByIdServlet">
		<div class="container-fluid d-flex justify-content-center"
			style="background-color: #ECECEC;">
			<div class="row col-sm-10 d-flex justify-content-center">
				<h2 class="text-center text-white bg-danger">SEARCH EVENT BY ID</h2>

				<input class="col-7 col-sm-4" type="number" name="searcheventid"
					placeholder="type event id here" required>
				<button class="col-3 col-sm-2" type="submit" id="searchbtn">search</button>

			</div>
		</div>
	</form>

	<form method="post" action="/SOES/ActionOnEventServlet"
		>

		<div class="container-fluid d-flex justify-content-center"
			style="background-color: #ECECEC;">
			<div class="row col-12  col-sm-10">
				<h4 class="text-danger fsw-italic text-center text-break mt-2">${seResult}</h4>

				<div class=" mb-2 col-6 col-sm-6" id="hide">
					<h5 class="text-primary">${seHeadseId}</h5>
					<input class="h6" type="number" name="seventId" value="${seId}"
						id="inputfieldForId" required readonly style="width: 40%;" />
				</div>
				<div class="mb-2 col-6 col-sm-6">
					<h5 class="text-primary">${seHeadseDate}</h5>
					<h6>${seDate}</h6>

				</div>
				<div class="mb-2">
					<h5  class="text-primary">${seHeadseTitle}</h5>
					<h6 class="text-break">${seTitle}</h6>

				</div>

				<div class=" mb-2 col-6 col-sm-6">
					<h5 class="text-primary">${seHeadseStartDate}</h5>
					<h6 class="text-break">${seStartDate}</h6>

				</div>
				<div class="mb-2 col-6 col-sm-6">
					<h5 class="text-primary">${seHeadseStartTime}</h5>
					<h6>${seStartTime}</h6>

				</div>
				
				<div class=" mb-2 col-6 col-sm-6">
					<h5 class="text-primary">${seHeadseEndDate}</h5>
					<h6 class="text-break">${seEndDate}</h6>

				</div>
				<div class="mb-2 col-6 col-sm-6">
					<h5 class="text-primary">${seHeadseEndTime}</h5>
					<h6>${seEndTime}</h6>

				</div>
				<div class="mb-2">
					<h5 class="text-primary">${seHeadseDescription}</h5>
					<h6 class="text-break">${seDescription}</h6>
				</div>
				<h5 class="col-4 col-sm-4 text-danger">${seHeadseAction}</h5>

				<div class="col-4 col-sm-4" id="hide1">
					<input class="h5" type="submit" name="eventdelete"
						id="inputfieldForDeleteBtn" style="cursor: pointer;"
						value="${seDelete}" />
				</div>
			</div>
		</div>
	</form>


	<div class="container-fluid d-flex justify-content-center"
		style="background-color: #ECECEC;">
		<div class="row col-sm-10">
			<h2 class="text-center text-white bg-danger mt-3">EVENT LIST</h2>


			<table class="table-bordered text-center  text-break">
				<tr class="text-danger bg-info">
					<th class="h6">Id</th>
					<th class="h6">Publish DateDate</th>
					<th class="h6">Title</th>
					<th class="h6">Start Date</th>
					<th class="h6">Start Time</th>
					<th class="h6">End Date</th>
					<th class="h6">End Time</th>
					<th class="h6">Description</th>

				</tr>
				<%
				try {
					Connection con = ConnectionProvider.getCon();

					AddPostEventDao epdao = new AddPostEventDao();
					ArrayList<AddPostEventClass> eventpostlist = epdao.getAllPost();

					for (AddPostEventClass actioneventpage : eventpostlist) {
				%>
				<tr style="background-color: #F5F5DC; height: 2rem;">

					<td class="h6 fw-normal"><%=actioneventpage.getpId()%></td>
					<td class="h6 fw-normal"><%=actioneventpage.getpDate()%></td>
					<td class=" h6  text-break ml-2"><%=actioneventpage.getpTitle()%></td>
					<td class="h6 fw-normal"><%=actioneventpage.getpStartDate()%></td>
					<td class="h6 fw-normal"><%=actioneventpage.getpStartTime()%></td>
					<td class="h6 fw-normal"><%=actioneventpage.getpEndDate()%></td>
					<td class="h6 fw-normal"><%=actioneventpage.getpEndTime()%></td>
					<td class=" h6 fw-normal fst-italic  text-break"><%=actioneventpage.getpDescription()%></td>

				</tr>

				<%
				}
				con.close();
				} catch (Exception e) {
				String resultMessage = "Server error occur : " + e.getMessage();

				request.setAttribute("Message", resultMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
				dispatcher.forward(request, response);
				}
				%>

			</table>
		</div>
	</div>



	<!-- JS  Code Section-->

	<!-- Required Ajax Jquery & JS for hide element when there is no data present -->
	<script>
		//for hide Delete button input when there is no data receive from database/ present
		var hide = document.getElementById("hide");
		var inputForId = document.getElementById("inputfieldForId")
		if (inputForId.value == "") {
			hide.style.display = "none";
		}
		//for hide Delete button input when there is no data receive from database/ present
		var hide = document.getElementById("hide1");
		var inputDeleteBtn = document.getElementById("inputfieldForDeleteBtn")
		if (inputDeleteBtn.value == "") {
			hide.style.display = "none";
		}
	</script>


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