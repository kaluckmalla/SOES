<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Importing all the dependent classes--%>

<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Add and Post Images</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="/SOES/css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">


<!-- Used by textarea character counter -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
	<%--For Add Images Post And Save--%>

	<form method="post" action="/SOES/AddPostImagesServlet"
		enctype="multipart/form-data" id="add_post_notice_form">
		<div class="container-fluid d-flex justify-content-center"
			style="background-color: lightblue;">
			<div class="row col-sm-8">
				<h2 class="mt-2 mb-2 text-center" style="color: darkblue;">Add
					and Post Image</h2>

				<hr style="height: .1rem; color: darkblue; opacity: 5">


				<%
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(new Date());
					%>
				<label class="h6 text-end" style="color: red;">Date <input
					class="h6" type="text" name="imagesDate" value="<%=date%>" readonly
					style="width: 7rem;" required>

				</label> <label class="h6 text-end" style="color: red;">Image Id <input
					class="h6" type="number" name="imagesId" value="${addImagepId}"
					readonly style="width: 7rem;" required>

				</label> <label class="h3 mb-3" style="color: blue;">About Images</label>
				<div>

					<textarea class="h4" name="aboutImages" id="textarea" rows="2"
						maxlength="50" placeholder="short description about images..." 
						required style="width: 100%;"></textarea>
					<div class="text-end">
						<span class="h5 text-danger" id="rchars">50</span> / 50
					</div>
				</div>

				<label class="h3 mb-3" style="color: blue;">Select Image</label> <input
					class="h5" type="file" name="image" style="cursor: pointer;"
					required>

																<button class="mt-4 h4" type="submit" id="postbtn">Post</button>

			</div>
		</div>
	</form>


	<!--  js for textarea character count.. -->

	<script type="text/javascript">
		var maxLength = 50;
		$('textarea').keyup(function() {
			var textlen = maxLength - $(this).val().length;
			$('#rchars').text(textlen);
		});
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