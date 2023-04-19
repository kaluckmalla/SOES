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

<title>Add and Post Notice</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="/SOES/css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<!-- Used by textarea character counter -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Used by for success or failure or server error alert message -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
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


	<%--For Add Notice Post And Save--%>

	<form method="post" action="/SOES/AddPostNoticeServlet"
		enctype="multipart/form-data" id="add_post_notice_form">
		<div class="container-fluid d-flex justify-content-center" style="background-color:lightblue;">
			<div class="row col-sm-8">
<h2 class="mt-2 mb-2 text-center " style="color: darkblue; ">Add and Post Notice</h2>
		
		<hr style="height: .1rem;color:darkblue; opacity: 5">

				
				
					<%
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(new Date());
					%>
					<label class="h6 text-end" style="color: red;">Date <input class="h6"  type="text" name="nDate"
						value="<%=date%>" readonly style="width: 7rem;"  required></label>

					
				
				
					<label class="h6 text-end" style="color: red;">Notice Id <input class="h6"  type="number" name="nId"
						value="${addNoticepId}" readonly  style="width: 7rem;"  required></label>
			
					<label class="h3 mb-3" style="color: blue;">Title</label>
					
					<div >
					<textarea class="h4" name="nTitle" id="textarea" rows="3" maxlength="100"
						placeholder="Write your notice title here..." style="width:100%;" required></textarea>
					<div class="text-end"><span  class="h5 text-danger"id="rchars" >100</span> / 100</div>
				</div>

				
					<label class="h3 mb-3" style="color: blue;">Select your file</label>
					 <input class="h5" type="file" name="nFile"
					 required style="cursor: pointer;">
				

								<button class="mt-4 h4" type="submit" id="postbtn">Post</button>
				
				
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


	<!-- Use of Ajax for printing success, errror, etc message -->
	<% /**
<script type="text/javascript">
    $(document).ready(function(e){
		$("#add_post_notice_form").on("submit", function(event) {
    	   
    	 //thisn code called when form is submitted
			event.preventDefault();
    	   console.log("form submitted....")
    	   
    	   
    	   let form = new FormData(this);

				//now requesting to server
       
       $.ajax({
					url : "/SOES/AddPostNoticeServlet",
					type : 'POST',
					data : form,
					success : function(data, textStatus, jqXHR) {
				    	   console.log("succc....")
				    	   				    	   console.log(data)

//success

					},
					error : function(data, textStatus, errorThrown) {

				    	   console.log("error")
//error
					},
					processData: false,
					contentType: false
				})
         
		}); 
    });
</script>**/
%>

	<!-- Js for success or failure or server error message -->



	<% /**
<script type="text/javascript">
    $(document).ready(function(e){
		
    	   alert("alert....")
    	   $("#add_post_notice_form").on("submit", function(event) {
    	   
    	 //thisn code called when form is submitted
			event.preventDefault();
	    	   console.log("form submitted....")

    	   
    	   let form = new FormData(this);

				//now requesting to server
       
    	   $.ajax({
				url : "/SOES/AddPostNoticeServlet",
				type : 'POST',
				data : form,
				success : function(data, textStatus, jqXHR) {
			    	   console.log("succc....")
			    	   				    	   if(data.trim()=='succefully post with new name'){
			    	   				    		swal("Post publish with change name successfully!", "You clicked the button!", "success");
			    	   				    	   }
			    	   				    	   else if(data.trim()=='done'){
	   				    		swal("Post publish ccessfully!", "You clicked the button!", "success");
				    	   }
			    	   				    	   else{
			    	   				    		   swal("bad job!", "You clicked the button!", "success");

			    	   				    	   }

//success

				},
				error : function(data, textStatus, errorThrown) {

		    		   swal("");

			    	   console.log("external error");
//error
				},
				processData: false,
				contentType: false
			})
    	   })
    
	}); 

 
    </script>
    **/%>
    
    
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