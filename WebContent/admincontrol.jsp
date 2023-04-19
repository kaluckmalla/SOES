<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Welcome Admin</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

<style>
#go-home-page a button {
	color: purple;
}

#go-home-page a button:hover {
background-color:red;
	color: white;
}

#logout a {
	color: maroon;
}

#logout a:hover {
	color: red;
}
.btn a button{
background-color:green;
color:yellow;
}
.btn a button:hover{
background-color:darkblue;
color:white;
}
</style>
</head>
<body>

	<!-- Admin main page -->

	<div class="container-fluid">
		<!-- Header -->
	
		<div class="row" style="background-color: lightgreen;">
			<div class="col-4 col-sm-4">
				<h2 class="text-break" style="color: darkblue;">
					Hi,
					<%
				String himessage = (String) session.getAttribute("HiMessage");
				if (himessage == null) {
					himessage = "";
				}
				%>
					<%=himessage%></h2>

			</div>
			<div class="text-center col-5 col-sm-4" id="go-home-page">
				<a class="h6 text-decoration-none" href="index.jsp"><button>Go
						to home page</button></a>
			</div>
			<div class="text-end col-3 col-sm-4" id="logout">
				<%
				session.setAttribute("logout", null);
				%>
				<a class="h5 text-decoration-none text-break" href="Logout">
					Logout <i class="fa fa-sign-out" aria-hidden="true"></i>
				</a>
			</div>

		</div>
	<%@ include file="adminheader.jsp" %>


		<!-- For managing website by admin -->
		<div class="row" style="background-color: lightblue;">
			<p class="h5 text-break fw-normal"  style="color: red">${AddPostNoticeMsg}</p>
		</div>
		
		<div class="row" style="background-color: lightblue;">

			<div class="notices border border-danger col-md-3" >
				<h2 style="color: purple;">Notice</h2>

				<div class="btn  mb-3">
					<a
						href="<%=request.getContextPath()%>/ShowIncrementedId?actionName=addPostNotice"><button>Add
							Notice</button></a>

				</div>
				<div class="btn mb-3">

					<a href="AdminManagePages/actiononpostnotice.jsp"><button>View/Edit/Delete</button></a>
				</div>

			</div>



			<div class="news border border-danger col-md-3">
				<h2 style="color: purple;">News</h2>
				
				<div class="btn  mb-3">
					<a
						href="<%=request.getContextPath()%>/ShowIncrementedId?actionName=addPostNews"><button>Add
							News</button></a>

				</div>
				<div class="btn mb-3">

					<a href="AdminManagePages/actiononpostnews.jsp"><button>View/Edit/Delete</button></a>
				</div>

			</div>


			<div class="event border border-danger col-md-3" >
				<h2 style="color: purple;">Event</h2>
				
				<div class="btn  mb-3">
					<a
						href="<%=request.getContextPath()%>/ShowIncrementedId?actionName=addPostEvent"><button>Add
							Event</button></a>

				</div>
				<div class="btn  mb-3">

					<a href="AdminManagePages/actiononpostevent.jsp"><button>View/Delete</button></a>
				</div>

			</div>
			<div class="images border border-danger col-md-3" >
				<h2 style="color: purple;">Image</h2>
				
				<div class="btn mb-3">
					<a
						href="<%=request.getContextPath()%>/ShowIncrementedId?actionName=addPostImages"><button>Add
							Image</button></a>

				</div>
				<div class="btn  mb-3">

					<a href="AdminManagePages/actiononpostimages.jsp"><button>View/Delete</button></a>
				</div>

			</div>
		</div>


	
		<div class="row">
			<div class="civil border border-danger col-md-4">
				<h2 style="color: purple;">Civil Engineering</h2>
				<div class="btn mb-3">
					<a href="AdminManagePages/civilsemester.jsp"><button>Add
							Material</button></a>
				</div>
				<div class="btn mb-3">
					<a href="AdminManagePages/actiononcivilstudymaterial.jsp"><button>View/Delete</button></a>
				</div>
			</div>
		
		
			<div class="computer border border-danger col-md-4">
				<h2 style="color: purple;">Computer Engineering</h2>
				<div class="btn mb-3">
					<a href="AdminManagePages/computersemester.jsp"><button>Add
							Material</button></a>
				</div>
				<div class="btn mb-3">
					<a href="AdminManagePages/actiononcomputerstudymaterial.jsp"><button>View/Delete</button></a>
				</div>
			</div>
		
			<div class="entrance border border-danger col-md-4">
				<h2 style="color: purple;">Entrance Preparation</h2>
				<div class="btn mb-3">
					<a
						href="<%=request.getContextPath()%>/ShowIncrementedSubjectPostId?semAction=entranceAdd"><button>Add
							Material</button></a>
				</div>
				<div class="btn mb-3">
					<a href="AdminManagePages/actiononentrancestudymaterial.jsp"><button>View/Delete</button></a>
				</div>
			</div>
		</div>
	</div>
		<%@ include file="footer.jsp" %>
		
	<!--For Security When Admin login Session is not available then go to Login -->
	<%
	HttpServletResponse httpResponse = (HttpServletResponse) response;

	httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	httpResponse.setHeader("Pragma", "no-cache");
	httpResponse.setDateHeader("Expires", 0);
	if (session.getAttribute("sessionEmail") == null && session.getAttribute("sessionPassword") == null) {
		response.sendRedirect("adminlogin.jsp");

	}
	%>
		
	
	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>