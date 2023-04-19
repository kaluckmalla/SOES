<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

	
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Add  Computer Material</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="/SOES/css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<style>
#postbtn{
background-color:lightgreen;
color:purple;
}
#postbtn:hover {
	color: white;
	background-color: darkblue;
}
</style>
</head>
<body>
	<form method="post" action="/SOES/AddPostComputerStudyMaterial" enctype="multipart/form-data">
		<div class="container-fluid d-flex justify-content-center" style="background-color:lightblue;">
			<div class="row col-sm-8">
<h2 class="mt-2 mb-2 text-center" style="color: darkblue; ">Add and Post Computer Engineering Material</h2>
		
		<hr style="height: .1rem;color:darkblue; opacity: 5">

			
				
					<%
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(new Date());
					%>
					<label class="h6 text-end" style="color: red;">Date <input class="h6" type="text" name="spDate"
						value="<%=date%>" readonly style="width: 7rem;" required>

					</label>
			
					<label class="h6 text-end" style="color: red;">Post Id <input class="h6" type="number" name="spId"
						value="${incrementedPostId}" readonly style="width: 7rem;" required>

					</label>
				
					<label class="h3 mb-3" style="color: blue;">Faculty </label><label> <input class="h4 col-10" type="text" name="spFaculty"
						value="Computer Engineering" readonly required>

					</label>
				
					<label class="h3 mb-3" style="color: blue;">Semester </label><label> <input class="h4 col-10" type="text" name="spSemester"
						value="${semester}" readonly required>

					</label>
				
					<label class="h3 mb-3" style="color: blue;">Type </label><label><select class="h4 col-10" name="spType" required>

							<option Selected>Book</option>
							<option >Note</option>
							<option >Question collection</option>
					 	    
							
					</select>
</label>
					<label class="h3 mb-3" style="color: blue;">Subject </label><label><select class="h4 col-10" name="spSubject" required>

							<option Selected>${s1}</option>
							<option >${s2}</option>
							<option >${s3}</option>
							<option >${s4}</option>
					 	    <option >${s5}</option>
							<option >${s6}</option>
					        <option >${s7}</option>

							
					</select>
				 </label> <label class="h3 mb-3" style="color: blue;">Select your
					file</label> <input class="h5" type="file" name="spFile" required
					style="cursor: pointer;">
				
																				<button class="mt-4 h4" type="submit" id="postbtn">Post</button>

			</div>
		</div>
	</form>
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