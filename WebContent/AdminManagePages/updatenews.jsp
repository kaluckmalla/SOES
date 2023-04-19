<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Importing all the dependent classes--%>

<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Update News</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="/SOES/css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<!-- Used by textarea character counter -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
#updatebtn{
background-color:lightgreen;
color:purple;
}
#updatebtn:hover {
	color: white;
	background-color: darkblue;
}
</style>
</head>
<body>


	<%--For Add Notice Post And Save--%>

	<form method="post" action="/SOES/ActionOnNewsServlet"
		enctype="multipart/form-data" >
		<div class="container-fluid d-flex justify-content-center" style="background-color:lightblue;">
			<div class="row col-sm-8">
<h2 class="mt-2 mb-2 text-center " style="color: darkblue; ">Update News</h2>
		
		<hr style="height: .1rem;color:darkblue; opacity: 5">

					
				<h5 class="mt-2 mb-2 text-center fw-normal fst-italic " style="color: red; ">Note : you can update only news title.</h5>
					
					<label  class="h6 text-end" style="color: red;">Published Date <input  class="h6" type="text" 
						value="${editDate}" readonly style="width: 7rem;" required>
					</label>
			
					<label class="h6 text-end" style="color: red;">News Id <input  class="h6" type="number" name="snewsId"
						value="${editId}" readonly style="width: 7rem;" required>

					</label>
				
					<label class="h3 mb-3" style="color: blue;">Title</label>
					<div>
					<textarea class="h4" name="editTitle" id="textarea" rows="3" maxlength="100"style="width:100%;" >${editTitle}</textarea>
					<div class="text-end"><span  class="h5 text-danger"id="rchars" >100</span> / 100</div>
				</div>

				
					<label class="h3 mb-3" style="color: blue;">Saved file name </label><label class="h5 text-break">${editFileName}</label>
								
<!-- yasma pani button ko laagi input element use gareko because in another page edit & delete ko laagi button ko thau input element use gareko le sagilo hunx bhanera   -->
								<input class="mt-4 h4" type="submit" id="updatebtn" name="action"
									 style="cursor: pointer;"
									value="Update" />
							</div>
			</div>

	</form>



	<!--  js for textarea character count.. -->

	<script type="text/javascript">
		var maxLength = 100;
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