<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@page import="java.util.ArrayList"%>
<%@page import="SqlConn.ConnectionProvider"%>
<%@page import="studyMaterial.AddPostStudyMaterialClass"%>
<%@page import="studyMaterial.AddPostStudyMaterialDao"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>${semHead}</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fluid d-flex justify-content-center"
		style="background-color: lightyellow;">
		<div class="row col-sm-10">
			<h2 class="text-center text-light bg-danger">${semHead}</h2>


			<h4 class="text-center text-break mb-3">
				<a class="text-decoration-none" href="#s1" style="color: maroon;">${s1}</a>
			</h4>
			<hr>
			<h4 class="text-center text-break mb-3">
				<a class="text-decoration-none" href="#s2" style="color: maroon;">${s2}</a>
			</h4>
			<hr>
			<h4 class="text-center text-break mb-3">
				<a class="text-decoration-none" href="#s3" style="color: maroon;">${s3}</a>
			</h4>
			<hr>
			<h4 class="text-center text-break mb-3">
				<a class="text-decoration-none" href="#s4" style="color: maroon;">${s4}</a>
			</h4>
			<hr>
			<h4 class="text-center text-break mb-3">
				<a class="text-decoration-none" href="#s5" style="color: maroon;">${s5}</a>
			</h4>
			<hr>
			<h4 class="text-center text-break mb-3">
				<a class="text-decoration-none" href="#s6" style="color: maroon;">${s6}</a>
			</h4>
			<hr>
			<h4 class="text-center text-break mb-3">
				<a class="text-decoration-none" href="#s7" style="color: maroon;">${s7}</a>
			</h4>

		</div>
	</div>

	<div class="container-fluid d-flex justify-content-center"
		style="background-color: lightyellow;">
		<div class="row col-sm-10">
			<h2 class="text-center text-light bg-danger">LIST</h2>


			<%
			try {
				Connection con = ConnectionProvider.getCon();
				Object subject1 = request.getAttribute("s1");
				Object subject2 = request.getAttribute("s2");
				Object subject3 = request.getAttribute("s3");
				Object subject4 = request.getAttribute("s4");
				Object subject5 = request.getAttribute("s5");
				Object subject6 = request.getAttribute("s6");
				Object subject7 = request.getAttribute("s7");

				Object sType = request.getAttribute("selectionType");
				Object sFac = request.getAttribute("selectionFaculty");

				Object fac = request.getAttribute("faculty");
				Object typ = request.getAttribute("type");
				Object sem = request.getAttribute("semester");

				AddPostStudyMaterialDao dao = new AddPostStudyMaterialDao();
				ArrayList<AddPostStudyMaterialClass> alllist = dao.getAllPost();
			%>




			<!-- For civil, computer and entrance: book and note -->


			<div id="s1">
				<h3 class="text-center text-warning bg-success">${s1}</h3>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
					
					//for civil and computer book and note
					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject1) && list.getpSemester().equals(sem+" sem") && !subject1.equals(null) && list.getpType().equals(sType)) {
			%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=sem%>/<%=subject1%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<%
				
				}
					//for entrance book and note
					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject1) && list.getpSemester().equals(sem) && !subject1.equals(null) && list.getpType().equals(sType)) {
			%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=subject1%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<hr>

				<%
				}
				}
				%>
			</div>
			<div id="s2">
				<h3 class="text-center text-warning bg-success">${s2}</h3>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
					//for civil and computer book and note

					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject2) && list.getpSemester().equals(sem+" sem") && !subject2.equals(null) && list.getpType().equals(sType)) {
				%>

				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=sem%>/<%=subject2%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>
				<%
				}
					//for entrance book and note
					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject2) && list.getpSemester().equals(sem) && !subject2.equals(null) && list.getpType().equals(sType)) {
			%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=subject2%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<hr>

				<%
				}
					
				}
				%>
			</div>
			<div id="s3">
				<h3 class="text-center text-warning bg-success">${s3}</h3>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
					
					//for civil and computer book and note

					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject3) && list.getpSemester().equals(sem+" sem") && !subject3.equals(null) && list.getpType().equals(sType)) {
				%>

				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=sem%>/<%=subject3%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<%
				}
					
					//for entrance book and note
					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject3) && list.getpSemester().equals(sem) && !subject3.equals(null) && list.getpType().equals(sType)) {
			%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=subject3%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<hr>

				<%
				}
				}
				%>
			</div>
			<div id="s4">
				<h3 class="text-center text-warning bg-success">${s4}</h3>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
					//for civil and computer book and note

					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject4) && list.getpSemester().equals(sem+" sem") && !subject4.equals(null) && list.getpType().equals(sType)) {
				%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none" class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=sem%>/<%=subject4%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>
				<%
				}
					//for entrance book and note
					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject4) && list.getpSemester().equals(sem) && !subject4.equals(null) && list.getpType().equals(sType)) {
			%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=subject4%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<hr>

				<%
				}
				}
				%>
			</div>
			<div id="s5">
				<h3 class="text-center text-warning bg-success">${s5}</h3>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
					//for civil and computer book and note

					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject5) && list.getpSemester().equals(sem+" sem") && !subject5.equals(null) && list.getpType().equals(sType)) {
				%>

				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=sem%>/<%=subject5%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>
				<hr>
				<%
				}
					
				}
				%>
			</div>
			<div id="s6">
				<h3 class="text-center text-warning bg-success">${s6}</h3>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
					//for civil and computer book and note

					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject6) && list.getpSemester().equals(sem+" sem") && !subject6.equals(null) && list.getpType().equals(sType)) {
				%>

				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=sem%>/<%=subject6%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>
				<hr>
				<%
				}
					
				}
				%>
			</div>
			<div id="s7">
				<h3 class="text-center text-warning bg-success">${s7}</h3>
				<%
				for (AddPostStudyMaterialClass list : alllist) {

					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals(subject7) && list.getpSemester().equals(sem+" sem") && !subject7.equals(null) && list.getpType().equals(sType)) {
				%>

				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=sem%>/<%=subject7%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<hr>
				<%
				}
					
				}
				%>
			</div>





			<!-- For Civil and computer old is gold/ question collection -->
			<div>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
				
					if (list.getpFaculty().equals(sFac) && list.getpSubject().equals("") && list.getpSemester().equals(sem+" sem") && list.getpType().equals(sType)) {
						

				%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<hr>

				<%
				}
				}
				%>
			</div>
			
<!-- For Entrance old is gold/ question collection -->
			<div>
				<%
				for (AddPostStudyMaterialClass list : alllist) {
				
					if (list.getpFaculty().equals(sFac) &&list.getpSubject().equals("") && list.getpSemester().equals(sem) && list.getpType().equals(sType)) {
				%>
				<h4 class="text-center text-break">
					<a class="text-decoration-none"
						href="studymaterial/<%=fac%>/<%=typ%>/<%=list.getpFile()%>"><%=list.getpFile()%></a>
				</h4>

				<hr>

				<%
				}
				}
				%>
			</div>



			<%
			con.close();
			} catch (Exception e) {
			String resultMessage = "Server error occur : " + e.getMessage();

			request.setAttribute("Message", resultMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
			dispatcher.forward(request, response);
			}
			%>
		</div>
	</div>
	<%@ include file="footer.jsp"%>

	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>


</body>
</html>