<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Activities</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

</head>
<body>
<%@ include file="header.jsp" %>
<div class="container-fluid" style="background-color: lightyellow;">
			<h2 class="text-center text-light bg-success">Internal Activities</h2>

<div class="row" >
<div class="text-center mb-3  col-6 col-sm-4 ">
	<a href="images/internal_activity1.jpg"><img class="mb-2"src="images/internal_activity1.jpg" width="100%" height="200rem;"></a>
	<p class="h4 fw-normal text-danger">Theory implementation in Laboratory</p>
	</div>
	<div class="text-center mb-3  col-6 col-sm-4 ">
	<a href="images/internal_activity2.jpg"><img class="mb-2"src="images/internal_activity2.jpg" width="100%" height="200rem;"></a>
	<p class="h4 fw-normal text-danger">Sanitization</p>
	</div>
	<div class="text-center mb-3  col-6 col-sm-4">
	<a href="images/internal_activity3.jpg"><img class="mb-2"src="images/internal_activity3.jpg" width="100%" height="200rem;"></a>
	<p class=" h4 fw-normal text-danger">Hydropower model designing</p>
	</div>
	
	<div class="text-center mb-3  col-6 col-sm-4">
	<a href="images/internal_activity4.jpg"><img class="mb-2"src="images/internal_activity4.jpg" width="100%" height="200rem;"></a>
	<p class="h4 fw-normal text-danger">Online meeting</p>
	</div>
	<div class="text-center mb-3  col-6 col-sm-4">
	<a href="images/internal_activity5.jpg"><img class="mb-2"src="images/internal_activity5.jpg" width="100%" height="200rem;"></a>
	<p class="h4 fw-normal text-danger">Welcome program</p>
	</div>
	<div class="text-center mb-3  col-6 col-sm-4">
	<a href="images/internal_activity6.jpg"><img class="mb-2"src="images/internal_activity6.jpg" width="100%" height="200rem;"></a>
	<p class="h4 fw-normal text-danger">AutoCAD training</p>
	</div>
</div>
		<h2 class="text-center text-light bg-success">External Activities</h2>

<div class="row" >
<div class="text-center mb-3  col-6 col-sm-4">
	<a href="images/external_activity1.jpg"><img class="mb-2"src="images/external_activity1.jpg" width="100%" height="200rem;"></a>
	<p class="h4 fw-normal text-danger">Holi festival</p>
	</div>
	
	
</div>
</div>
<%@ include file="footer.jsp" %>

	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>