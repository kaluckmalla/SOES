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

<title>Photo gallery</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

</head>
<body>
	<%@ include file="header.jsp" %>


<div class="container-fluid" style="background-color: lightyellow;">
		<div class="row">
			<h2 class="text-center text-light bg-success">Photo Gallery</h2>
		
	<%
	try {
		Connection con = ConnectionProvider.getCon();

		AddPostImagesDao ipdao = new AddPostImagesDao();
		ArrayList<AddPostImagesClass> imagepostlist = ipdao.getAllPost();

		for (AddPostImagesClass allimagelistpage : imagepostlist) {

					%>
<div class="col-4 col-sm-3 col-md-2">
<p class="text-success h6 fst-italic fw-normal">Published Date : <%=allimagelistpage.getpDate()%></p>
<a href="uploads/photogallery/<%=allimagelistpage.getpImage()%>"><img  class="image zoom"alt="" onerror="this.style.display='none'" src="uploads/photogallery/<%=allimagelistpage.getpImage()%>" style="width: 100%; height: 10rem;" /></a>
<p class="text-break text-danger fw-bold h5"><%=allimagelistpage.getpAboutImage()%></p>

</div>

		
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