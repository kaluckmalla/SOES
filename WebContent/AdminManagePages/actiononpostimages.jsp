<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@page import="java.util.ArrayList"%>
<%@page import="SqlConn.ConnectionProvider"%>
<%@page import="gallery.AddPostImagesClass"%>
<%@page import="gallery.AddPostImagesDao"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Action on Post Image</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="/SOES/css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<!-- Used by hide element by id when there is no data -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
<style>

#searchbtn{
background-color:lightgreen;
color:purple;
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
.image a{
color:purple;
margin-left:1rem;
margin-right:1rem;
text-decoration:none;
}
.image a:hover{
background-color:white;
color:blue;
}

</style>


</head>
<body>

<form method="post" action="/SOES/SearchImageByIdServlet">

		<div class="container-fluid d-flex justify-content-center"
			style="background-color: #ECECEC;">
			<div class="row col-sm-10 d-flex justify-content-center">
				<h2 class="text-center text-white bg-danger">SEARCH IMAGE BY ID</h2>
				
				<input class="col-7 col-sm-4" type="number" name="searchimageid"
					placeholder="type news id here" required>
												<button class="col-3 col-sm-2" type="submit" id="searchbtn">search</button>

			</div>
		</div>
	</form>




<form method="post" action="/SOES/ActionOnImageServlet"
		enctype="multipart/form-data">

		<div class="container-fluid d-flex justify-content-center" style="background-color: #ECECEC;">
			<div class="row col-12  col-sm-10">
				<h4 class="text-danger fsw-italic text-center text-break mt-2">${siResult}</h4>

				<div class=" mb-2 col-6 col-sm-6"id="hide1">
					<h5 class="text-primary">${siHeadsiId}</h5>
					<input  class="h6"type="number" name="sImageId" value="${siId}"
						id="inputfieldForId" required readonly style="width: 40%; " />
				</div>
				<div class="mb-2 col-6 col-sm-6">
					<h5 class="text-primary">${siHeadsiDate}</h5>
					<h6>${siDate}</h6>

				</div>
				<div class="mb-2">
					<h5 class="text-primary">${siHeadsiAboutImage}</h5>
					<h6 class="text-break">${siAboutImage}</h6>

				</div>

				<div class="mb-2" id="hide2">
					<h5 class="text-primary">${siHeadsiImage}</h5>

					<textarea class="h6" name="sImageNameFromDB" 
						id="inputfieldForFileName" required readonly style="width:100%; " >${siImageName}</textarea>
				</div>
				<h5 class="col-4 col-sm-4 text-danger">${siHeadsiAction}</h5>

				<div class="col-4 col-sm-4" id="hide3">
					<input class="h5"type="submit" name="action" id="inputfieldForDeleteBtn"
						style="cursor: pointer;" value="${siDelete}" />
				</div>
			</div>
		</div>
	</form>
			
						
	
	<div class="container-fluid d-flex justify-content-center" style="background-color: #ECECEC;">
			<div class="row col-sm-10">
			<h2 class="text-center text-white bg-danger mt-3">IMAGE LIST</h2>
	
	<table class="table-bordered text-center  text-break">
		<tr class="text-danger bg-info">
			<th class="h4">Id</th>
			<th class="h4">Date</th>
			<th class="h4">About Image</th>
			<th class="h4">Image</th>


		</tr>
		<%
		try {
			Connection con = ConnectionProvider.getCon();

			AddPostImagesDao ipdao = new AddPostImagesDao();
			ArrayList<AddPostImagesClass> imagepostlist = ipdao.getAllPost();

			for (AddPostImagesClass actionimagepage : imagepostlist) {
		%>
		<tr style="background-color: #F5F5DC;height:3rem;">

			<td class="h6 fw-normal" width="50rem"><%=actionimagepage.getpId()%></td>
			<td class="h6 fw-normal" width="50rem"><%=actionimagepage.getpDate()%></td>
			<td class=" h6  text-break"><%=actionimagepage.getpAboutImage()%></td>
			<td class="image h6  text-break"><a href="/SOES/uploads/photogallery/<%=actionimagepage.getpImage()%>"><%=actionimagepage.getpImage()%></a></td>
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
    //for hide Notice Id field when there is no data receive from database/ present
	 var  hide1 = document.getElementById("hide1");
	    var inputForId = document.getElementById("inputfieldForId")
	        if(inputForId.value == ""){
	            hide1.style.display = "none";
	         }
	   
	    
	  //for hide File Name input field when there is no data receive from database/ present
		 var  hide2 = document.getElementById("hide2");
		    var inputForFileName = document.getElementById("inputfieldForFileName")
		        if(inputForFileName.value == ""){
		            hide2.style.display = "none";
		         }
	    
	    
		    //for hide Delete button input when there is no data receive from database/ present
			 var  hide3 = document.getElementById("hide3");
			    var inputDeleteBtn = document.getElementById("inputfieldForDeleteBtn")
			        if(inputDeleteBtn.value == ""){
			            hide3.style.display = "none";
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