<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@page import="java.util.ArrayList"%>
<%@page import="SqlConn.ConnectionProvider"%>
<%@page import="noticeManage.AddPostNoticeClass"%>
<%@page import="noticeManage.AddPostNoticeDao"%>
<%@page import="newsManage.AddPostNewsClass"%>
<%@page import="newsManage.AddPostNewsDao"%>
<%@page import="eventManage.AddPostEventClass"%>
<%@page import="eventManage.AddPostEventDao"%>




<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name='robots' content='max-image-preview:large' />
	
<title>An Official Site of Society of Engineering Student,
	Far&#8211;Western University, Mahendranagar, Kanchanpur</title>



<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Custom css file -->
<link rel="icon" href="images/soeslogo.jpg">

<link rel="stylesheet" type="text/css" href="css/sty.css">

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
							href="mailto:kalakmalla732c@gmail.com">kalakmalla732@gmail.com</a>
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
								aria-expanded="false"> PROGRAM </a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">

									<li><a class="dropdown-item" href="civilengineering.jsp">Civil Engineering</a></li>
																		<li><hr class="dropdown-divider"></li>
									
									<li><a class="dropdown-item" href="computerengineering.jsp">Computer Engineering</a></li>

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




	<!-- Carousel -->


	<div id="carouselExampleCaptions" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images/slide_pic1.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption  d-md-block">
					<h2>First slide label</h2>
					<h6>Some representative placeholder content for the first
						slide.</h6>
				</div>
			</div>
			<div class="carousel-item">
				<img src="images/slide_pic2.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption  d-md-block">
					<h2>Second slide label</h2>
					<h6>Some representative placeholder content for the second
						slide.</h6>
				</div>
			</div>
			<div class="carousel-item">
				<img src="images/slide_pic3.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption  d-md-block">
					<h2>Third slide label</h2>
					<h6>Some representative placeholder content for the third
						slide.</h6>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>


	<div>







		<!-- Notice and news board data fetching from database using  pojo class and after click on link title goes to ContentView servlet  usnig notice id and news id  -->
		<section class="section-1">
			<div class="container-fluid">

				<div class="row" style="background-color: lightyellow">


					<div class="notice mt-4 mb-4 col-md-6">
						<h2 class="text-center text-info bg-dark">NOTICE BOARD</h2>


						<%
						try {
							Connection con = ConnectionProvider.getCon();

							AddPostNoticeDao npdao = new AddPostNoticeDao();
							ArrayList<AddPostNoticeClass> noticepostlist = npdao.getAllPost();

							int i = 0;

							for (AddPostNoticeClass n : noticepostlist) {
								while (i < 5) {
							AddPostNoticeClass noticeindexpage = noticepostlist.get(i);
						%>


						<div class="card">
							<div class="single-notice">
								<div class="post-head mx-4 text-break">
									<p class="notice-date mb-0"><%=noticeindexpage.getpDate()%></p>
									<h5>
										<a
											href="<%=request.getContextPath()%>/NoticeView?noticeId=<%=noticeindexpage.getpId()%>"
											class="text-decoration-none"><%=noticeindexpage.getpTitle()%></a>
									</h5>
								</div>

							</div>
						</div>


						<%
						i++;
						}

						}
						con.close();
						} catch (Exception e) {
						String resultMessage = "Server error occur : " + e.getMessage();

						request.setAttribute("Message", resultMessage);
						RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
						dispatcher.forward(request, response);
						}
						%>

						<div class="v-more bg-dark float-end">
							<a class="fs-4 text-decoration-none text-white float-end"
								href="allnoticelist.jsp">view more</a>
						</div>

					</div>


					<div class="news mt-4 mb-4 col-md-6 ">
						<h2 class="text-center text-info bg-dark">NEWS BOARD</h2>


						<%
						try {
							Connection con = ConnectionProvider.getCon();

							AddPostNewsDao npdao = new AddPostNewsDao();
							ArrayList<AddPostNewsClass> newspostlist = npdao.getAllPost();

							int i = 0;

							for (AddPostNewsClass n : newspostlist) {
								while (i < 5) {
							AddPostNewsClass newsindexpage = newspostlist.get(i);
						%>


						<div class="card">
							<div class="single-notice">
								<div class="post-head mx-4 text-break">
									<p class="notice-date mb-0"><%=newsindexpage.getpDate()%></p>
									<h5>
										<a
											href="<%=request.getContextPath()%>/NewsView?newsId=<%=newsindexpage.getpId()%>"
											class="text-decoration-none"><%=newsindexpage.getpTitle()%></a>
									</h5>
								</div>

							</div>
						</div>


						<%
						i++;
						}

						}
						con.close();
						} catch (Exception e) {
						String resultMessage = "Server error occur : " + e.getMessage();

						request.setAttribute("Message", resultMessage);
						RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
						dispatcher.forward(request, response);
						}
						%>

						<div class="v-more bg-dark float-end">
							<a class="fs-4 text-decoration-none text-white float-end"
								href="allnewslist.jsp">view more</a>
						</div>
					</div>
				</div>
			</div>

		</section>

		<hr
			style="height: .1rem; color: maroon; margin-top: 0; margin-bottom: 0;" />


		<!-- For different different content -->
		<section class="section-2">

			<div class="container-fluid px-3 py-5"
				style="background-color: lightyellow;">

				<div class="row gx-0 ">
					<div class="image-container  col-sm-6 col-12 col-xxl-4">


						<a href="ourstory.jsp"> <img src="images/our_story.jpg"
							class="content-image mt-3 mb-3" alt="An Official Site of SOES" />
							<span class="txtoverimg" style="background-color: lightgray;">Our Story</span>

						</a>

					</div>
					<div class="image-container col-sm-6 col-12 col-xxl-4">


						<a href="teachers.jsp"> <img src=images/teachers_team.jpg
							class="content-image mt-3 mb-3" alt="An Official Site of SOES" />
							<span class="txtoverimg" style="background-color: lightgray;">Teachers Team</span>

						</a>

					</div>
					<div class="image-container col-sm-6 col-12 col-xxl-4">


						<a href="students.jsp"> <img src="images/students_team.jpg"
							class="content-image mt-3 mb-3" alt="An Official Site of SOES" />
							<span class="txtoverimg" style="background-color: lightgray;">Students Team</span>

						</a>

					</div>

					
					<div class="image-container col-sm-6 col-12 col-xxl-4">


						<a href="activities.jsp"> <img src="images/activities.jpg"
							class="content-image mt-3 mb-3" alt="An Official Site of SOES" />
							<span class="txtoverimg" style="background-color: lightgray;">Activities</span>

						</a>

					</div>
					<div class="image-container col-sm-6 col-12 col-xxl-4">


						<a href="services.jsp"> <img src="images/services.jpg"
							class="content-image mt-3 mb-3" alt="An Official Site of SOES" />
							<span class="txtoverimg" style="background-color: lightgray;">Services</span>

						</a>

					</div>

					<div class="image-container col-sm-6 col-12 col-xxl-4">


						<a href="photogallery.jsp"> <img src="images/photogallery.jpg"
							class="content-image mt-3 mb-3" alt="An Official Site of SOES" />
							<span class="txtoverimg" style="background-color: lightgray;">Photo Gallery</span>

						</a>

					</div>




				</div>
			</div>

		</section>


	</div>


	<!-- For study material............ -->

	<section class="section-3">
		<div class="related-to-study">
			<h2 class="text-info bg-dark">STUDY MATERIAL</h2>
			<div class="container">
				<div class="row">

					<div class="civil-engineering col-sm-12 col-12 col-xl-4 col-xxl-4">
						<h4 class="text-light bg-success">Civil Engineering</h4>
						<div>
							<ul>
								<li class="study-item dropdown"><a
									class="nav-link active dropdown-toggle" href="#"
									id="navbarDropdown" role="button" data-bs-toggle="dropdown"
									aria-expanded="false">Books </a>
									<ul class="dropdown-menu" id="study-related-dropdown"
										aria-labelledby="navbarDropdown">

										<li><a class="dropdown-item"
											href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB1st">1st
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item"
											href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB2nd">2nd
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB3rd">3rd
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB4th">4th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB5th">5th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB6th">6th
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB7th">7th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilB8th">8th
												Sem</a></li>


									</ul></li>

								<li class="study-item dropdown"><a
									class="nav-link active dropdown-toggle" href="#"
									id="navbarDropdown" role="button" data-bs-toggle="dropdown"
									aria-expanded="false">Notes </a>
									<ul class="dropdown-menu" id="study-related-dropdown"
										aria-labelledby="navbarDropdown">
										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN1st">1st Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN2nd">2nd
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN3rd">3rd
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN4th">4th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN5th">5th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN6th">6th
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN7th">7th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilN8th">8th
												Sem</a></li>


									</ul></li>
								<li class="study-item dropdown"><a
									class="nav-link active dropdown-toggle" href="#"
									id="navbarDropdown" role="button" data-bs-toggle="dropdown"
									aria-expanded="false">Old Question Collection </a>
									<ul class="dropdown-menu" id="study-related-dropdown"
										aria-labelledby="navbarDropdown">
										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC1st">1st Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC2nd">2nd
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC3rd">3rd
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC4th">4th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC5th">5th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC6th">6th
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC7th">7th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=civilQC8th">8th
												Sem</a></li>


									</ul></li>
							</ul>
						</div>
					</div>

					<div
						class="computer-engineering col-sm-12 col-12 col-xl-4 col-xxl-4">
						<h4 class="text-light bg-success">Computer Engineering</h4>
						<div>
							<ul>
								<li class="study-item dropdown"><a
									class="nav-link active dropdown-toggle" href="#"
									id="navbarDropdown" role="button" data-bs-toggle="dropdown"
									aria-expanded="false">Books </a>
									<ul class="dropdown-menu" id="study-related-dropdown"
										aria-labelledby="navbarDropdown">
										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB1st">1st Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB2nd">2nd
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB3rd">3rd
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB4th">4th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB5th">5th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB6th">6th
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB7th">7th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerB8th">8th
												Sem</a></li>


									</ul></li>

								<li class="study-item dropdown"><a
									class="nav-link active dropdown-toggle" href="#"
									id="navbarDropdown" role="button" data-bs-toggle="dropdown"
									aria-expanded="false">Notes </a>
									<ul class="dropdown-menu" id="study-related-dropdown"
										aria-labelledby="navbarDropdown">
										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN1st">1st Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN2nd">2nd
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN3rd">3rd
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN4th">4th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN5th">5th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN6th">6th
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN7th">7th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerN8th">8th
												Sem</a></li>


									</ul></li>
								<li class="study-item dropdown"><a
									class="nav-link active dropdown-toggle" href="#"
									id="navbarDropdown" role="button" data-bs-toggle="dropdown"
									aria-expanded="false">Old Question Collection </a>
									<ul class="dropdown-menu" id="study-related-dropdown"
										aria-labelledby="navbarDropdown">
										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC1st">1st Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC2nd">2nd
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC3rd">3rd
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC4th">4th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC5th">5th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC6th">6th
												Sem</a></li>
										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC7th">7th
												Sem</a></li>

										<li><hr class="dropdown-divider"></li>

										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=computerQC8th">8th
												Sem</a></li>


									</ul></li>
							</ul>
						</div>
					</div>
					<div
						class="entrance-preparation col-sm-12 col-12 col-xl-4 col-xxl-4">
						<h4 class="text-light bg-success">Entrance Preparation</h4>
						<div>
							<ul>
								<li class="study-item dropdown "><a class="nav-link active"
									href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=entranceB" role="button">Books </a></li>

								<li class="study-item dropdown"><a class="nav-link active"
									href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=entranceN" role="button">Notes </a></li>
								<li class="study-item dropdown"><a class="nav-link active"
									href="<%=request.getContextPath()%>/SubjectNameWithMaterial?type=entranceQC" role="button">Old Question Collection </a></li>
							</ul>

						</div>
					</div>


				</div>
			</div>
		</div>
	</section>

	<!-- for event -->
	<section class="section-4-event">

		<%
		try {
			Connection con = ConnectionProvider.getCon();

			AddPostEventDao pedao = new AddPostEventDao();
			ArrayList<AddPostEventClass> eventpostlist = pedao.getAllPost();

			int i = 0;

			for (AddPostEventClass n : eventpostlist) {
				while (i < 1) {
			AddPostEventClass eventindexpage = eventpostlist.get(i);
		%>

		<div class="container-fluid  d-flex justify-content-center"
			style="background-color: lightgray;">
			<div class="row col-md-8 float-center"
				style="background-color: lightyellow;">
				<h2 class="text-info bg-dark text-center ">UPCOMING
					EVENT</h2>

				<p class="mb-0 text-end fst-italic">
					Published Date :
					<%=eventindexpage.getpDate()%></p>
				<h3 class="text-decoration-underline text-success text-center text-break"><%=eventindexpage.getpTitle()%></h3>
				<div class="row">
					<div class="col-md-6 text-center">
						<p class="fw-bold mb-0">Start Date</p>
						<p class="mb-0"><%=eventindexpage.getpStartDate()%></p>
						<p class="fw-bold mb-0">Start Time</p>
						<p class="mb-0"><%=eventindexpage.getpStartTime()%></p>
					</div>
					<div class="col-md-6 text-center">
						<p class="fw-bold mb-0">End Date</p>
						<p class="mb-0"><%=eventindexpage.getpEndDate()%></p>
						<p class="fw-bold mb-0">End Time</p>
						<p class="mb-0"><%=eventindexpage.getpEndTime()%></p>
					</div>
				</div>
				<h4 class="fw-bold mb-0 text-info">About Event</h4>
				<p class="text-break"><%=eventindexpage.getpDescription()%></p>
				<div class="v-more bg-dark float-end">
					<a class="fs-4 text-decoration-none text-white float-end"
						href="alleventlist.jsp">view more</a>
				</div>
			</div>

		</div>
		<%
		i++;
		}

		}
		con.close();
		} catch (Exception e) {
		String resultMessage = "Server error occur : " + e.getMessage();

		request.setAttribute("Message", resultMessage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
		dispatcher.forward(request, response);
		}
		%>

	</section>


	<!-- for Footer -->

	<footer>
		<div class="top-footer-section" style="background-color: lightblue;">
			<div class="container">
					<div class="row">

						<div class="col-sm-6 col-md-3" id="soescontact">
							<!-- 2 -->


							<section>
								<h4 class="mt-4 mb-3 text-success">Contact Us</h4>
								<div >Society of Engineering Students<br />
									Far-Western University <br /> Bheemdatta Municipality-18,
									Mahendranagar, Kanchanpur, Nepal<br /> <strong>Telephone:</strong>+977-61-504046
									<br /> <strong>Post Box: </strong>427 <br /> <strong>
										E-mail:</strong> info@pu.edu.np
								</div>
							</section>
						</div>
						<div class="col-sm-6 col-md-3">
							<!-- 3 -->
							<section>
								<h4 class="mt-4 mb-3 text-success">Faculty Inquiry</h4>
								<div >
									Civil Engineering : +977-61-504076<br /> Computer Engineering
									: +977-61-504075<br />
								</div>
							</section>


						</div>
						<div class="col-sm-6 col-md-3">
							<!-- 4 -->
							<section>
								<h4 class="mt-4 mb-3 text-success">Information Officer</h4>
								<div >
									Kaluck Malla : +977- 98-58751161<br />
								</div>
							</section>


						</div>
						<div class="col-sm-6 col-md-3">
							<!-- 4 -->
							<section>
								<h4 class="mt-4 mb-3 text-success text-success">Far-Western University Central office link</h4>
								<div >
									<a href="https://fwu.edu.np/" >click here</a>
								</div>
							</section>
						</div>
					</div>
				</div>

			</div>
		
		<!-- For copy right section -->
		<div class="bottom-footer-section">
			<div class="container">
				<div class="row">
					<div class="copyright col-sm-6 col-12 col-xl-6 col-xxl-6">
						<p>Copyright © 2022 | SOES.</p>
					</div>
					<div
						class="social-media-container col-sm-6 col-12 col-xl-6 col-xxl-6">
						<div class="social-media">
							<span><a href="#"><i class="fab fa-twitter"></i></a> </span> <span><a
								href="#"><i class="fab fa-facebook-f"></i></a> </span> <span><a
								href="#"><i class="fab fa-youtube"></i></a> </span> <span><a
								href="#"><i class="fab fa-instagram"></i></a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>







	<!-- Return to Top -->
	<a id="back2Top" title="Back to top" href="#">&#10148;</a>

	<!-- Return to Top jquery -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

	<!-- Return to Top js or javascript -->

	<script>
		$(window).scroll(function() {
			var height = $(window).scrollTop();
			if (height > 100) {
				$('#back2Top').fadeIn();
			} else {
				$('#back2Top').fadeOut();
			}
		});
		$(document).ready(function() {
			$("#back2Top").click(function(event) {
				event.preventDefault();
				$("html, body").animate({
					scrollTop : 0
				}, "slow");
				return false;
			});

		});
	</script>


	

	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>


</body>
</html>