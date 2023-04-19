<!-- For using nepali language  charactset and page encoding update gareko -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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