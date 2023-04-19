<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->

    <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title></title>

<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Custom css file -->
<link rel="icon" href="images/soeslogo.jpg">

<link rel="stylesheet" type="text/css" href="css/style.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</head>
<body>
	<header>
		<div class="container-fluid px-0">
			<div class="row gx-0" id="topbar">

				<div class="topbar1 col-sm-12 col-8 col-xl-6 col-xxl-6">

					<ul>

						<li><i class="fa fa-phone-square" aria-hidden="true"></i> <a
							href="tel:9866108495">9866108495</a></li>
						<li><i class="fa fa-envelope" aria-hidden="true"></i> <a
							href="mailto:kalakmalla732c@gmail.com">kalakmalla732c@gmail.com</a>
						<li id="follow_us">Follow Us</li>
						<li><a href="#"><i class="fab fa-facebook"
								title="Facebook" aria-hidden="true"
								style="color: royalblue; font-size: 1rem;"></i></a></li>
						<li><a href="#"><i class="fab fa-twitter" title="Twitter"
								aria-hidden="true" style="color: dodgerblue; font-size: 1rem;"></i></a>
						</li>

					</ul>
				</div>
				<!-- For generating current date -->
				<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
				String date = sdf.format(new Date());
				%>
				<div class="topbar2 col-sm-12 col-4 col-xl-6 col-xxl-6">

					<ul>

						<li id="date"><b>Date :</b> <%=date%></li>
						<li><a href="adminlogin.jsp"><i class="fa fa-user"
								style="color: blue"></i> Login</a></li>



					</ul>
				</div>
			</div>

		</div>

		<div class="container-fluid px-0">

			<div class="row gx-0">
				<div class="col-2 col-md-2 col-lg-1 col-xl-1">


					<a href="index.jsp"> <img src="images/soeslogo.jpg"
						class="soes-logo" alt="An Official Site of SOES" />
					</a>

				</div>
				<div class="col-10 col-md-8 col-lg-4 col-xl-3">


					<a href="index.jsp"> <img src="images/soesname.png"
						class="soes-name" alt="An Official Site of SOES" />
					</a>

				</div>



			</div>
		</div>

		<!-- Nav Bar -->

		<div>

			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="index.jsp">HOME</a></li>
							<li class="nav-item"><a class="nav-link active"
								href="aboutus.jsp">ABOUT US</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link active dropdown-toggle" href="#"
								id="navbarDropdown" role="button" data-bs-toggle="dropdown"
								aria-expanded="false">PROGRAMS </a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="civilengineering.jsp" id="navbarDropdown">Civil
											Engineering</a></li>
									<li><hr class="dropdown-divider"></li>

									<li><a class="dropdown-item" href="computerengineering.jsp">Computer
											Engineering</a></li>

								</ul></li>


							<li class="nav-item dropdown"><a
								class="nav-link active dropdown-toggle" href="#"
								id="navbarDropdown" role="button" data-bs-toggle="dropdown"
								aria-expanded="false"> NEWS and NOTICES </a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">

									<li><a class="dropdown-item" href="allnoticelist.jsp">Notice</a></li>
																		<li><hr class="dropdown-divider"></li>
									
									<li><a class="dropdown-item" href="allnewslist.jsp">News</a></li>

								</ul></li>

							<li class="nav-item dropdown"><a
								class="nav-link active dropdown-toggle" href="#"
								id="navbarDropdown" role="button" data-bs-toggle="dropdown"
								aria-expanded="false">OUR TEAM </a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="students.jsp" id="navbarDropdown">Students</a>
									</li>
									<li><hr class="dropdown-divider"></li>

									<li><a class="dropdown-item" href="teachers.jsp">Teachers</a></li>

								</ul></li>
							<li class="nav-item"><a class="nav-link active"
								href="alleventlist.jsp">EVENT</a></li>

							<li class="nav-item"><a class="nav-link active"
								href="#soescontact">CONTACT US</a></li>

						</ul>

					</div>
				</div>
			</nav>




		</div>

	</header>

	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>