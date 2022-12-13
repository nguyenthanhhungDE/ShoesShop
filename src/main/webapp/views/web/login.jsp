<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Karma Shop</title>
</head>
<body>
	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Login/Register</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="login.html">Login/Register</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Login Box Area =================-->
	<section class="login_box_area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login_box_img">
						<img class="img-fluid" src="<c:url value='/template/web/img/login.jpg'/>" alt="">
						<div class="hover">
							<a class="primary-btn" href="<c:url value='/dang-ky'/>">Create an Account</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner">
						<%ServletContext sc = getServletContext();
						String a = (String)sc.getAttribute("message");
						if(a!=null){%>
							<div class="alert-warning" style="margin: 0 0 20px 0;">
								<Strong><%=a %></Strong>
							</div>
						<%}
						sc.removeAttribute("message");%>
						<h3>Log in to enter</h3>
						<form class="row login_form" action='<c:url value="/dang-nhap"/>' method="post" id="contactForm" novalidate="novalidate">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="username" name="username" placeholder="Username" />
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password" />
							</div>
							<div class="col-md-12 form-group">
								<!-- <div class="creat_account">
									<input type="checkbox" id="f-option2" name="selector">
									<label for="f-option2">Keep me logged in</label>
								</div> -->
							</div>
							<div class="col-md-12 form-group">
								<!-- <input type="hidden" value="login" name="action"/> -->
								<button type="submit" class="primary-btn">Log In</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->
</body>
</html>