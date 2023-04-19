<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required below  meta tags change gareko x -->
    <meta charset="utf-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Content View</title>
<!-- Bootstrap css file which is must be above custom css file -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="images/soeslogo.jpg">

</head>

<body>

	<%@ include file="header.jsp" %>



	<div class=container-fluid>
		<!-- For content view header -->
		<div class="row" style="background-color: darkblue;">
			<h5 class="text-white">${notice}&#8658; ${contentDate}</h5>

		</div>

		<!-- For Show Notice detail -->

		<div class="row text-center" style="background-color: lightyellow;">
			<h2 class="mt-2">
				<a class="text-decoration-none text-break"	href="uploads/notice/${contentFileName}">${contentNoticeTitle}</a>
			</h2>
			<h1 class="fw-bold text-break mb-3" style="color: maroon">${contentNoticeTitleOfImage}</h1>
			<div id="hide">
				<img alt="" onerror="this.style.display='none'"
					src="uploads/notice/${contentFileName}" id="imageFrame" width="95%"
					height="auto">
			</div>

		</div>

		<!-- For Show News detail -->
		<div class="row text-center" style="background-color: lightyellow;">
			<h1 class="fw-bold text-break mb-3"  style="color: maroon">${contentNewsTitle}</h1>
			<div id="hide">
				<img alt="" onerror="this.style.display='none'"
					src="uploads/news/${contentImageName}" width="70%" height="350rem"
					id="imageFrame">
			</div>
			<p class="text-break text-start mt-5 mb-5 h3">${contentDescription}</p>
		</div>
	</div>

	<%@ include file="footer.jsp" %>

	<!-- JQuery must be above bootstrap js file -->
	<!-- Bootstrap js file or JavaScript Bundle with Popper -->
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>