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
	<!-- start banner Area -->
	<section class="banner-area">
		<div class="container">
			<div class="row fullscreen align-items-center justify-content-start">
				<div class="col-lg-12">
					<div class="active-banner-slider owl-carousel">
						<!-- single-slide -->
						<div class="row single-slide align-items-center d-flex">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1> New <br>Collection!</h1>
									<!-- <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p> -->
									<!-- <div class="add-bag d-flex align-items-center">
										<a class="add-btn" href=""><span class="lnr lnr-cross"></span></a>
										<span class="add-text text-uppercase">Add to Bag</span>
									</div> -->
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="<c:url value='/template/web/img/banner/banner-img.png'/>" alt="">
								</div>
							</div>
						</div>
						<!-- single-slide -->
						<div class="row single-slide">
							<div class="col-lg-5">
								<div class="banner-content">
									<h1> New <br>Collection!</h1>
									<!-- <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p> -->
									<!-- <div class="add-bag d-flex align-items-center">
										<a class="add-btn" href=""><span class="lnr lnr-cross"></span></a>
										<span class="add-text text-uppercase">Add to Bag</span>
									</div> -->
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="<c:url value='/template/web/img/banner/banner-img.png'/>" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- start product Area -->
	<section class="owl-carousel active-product-area section_gap">
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>Latest Products</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<c:forEach items="${newproduct}" var="np">
						<div class="col-lg-3 col-md-6">
							<a href="san-pham-chi-tiet?pid=${np.productid}">
								<div class="single-product single-product-lhk">
									<img class="img-fluid img-lhk" src="${np.image}" alt="">
									<div class="product-details product-details-lhk">
										<h6>${np.productname}</h6>
										<div class="price price-lhk">
											<h6>${np.discount}</h6>
											<h6 class="l-through">${np.price}</h6>
										</div>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>Top Products</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<c:forEach items="${tproduct}" var="t">
						<div class="col-lg-3 col-md-6">
							<div class="single-product single-product-lhk">
								<a href="san-pham-chi-tiet?pid=${t.productid}">
									<img class="img-fluid img-lhk" src="${t.image}" alt="">
									<div class="product-details product-details-lhk">
										<h6>${t.productname}</h6>
										<div class="price price-lhk">
											<h6>${t.discount}</h6>
											<h6 class="l-through">${t.price}</h6>
										</div>
									</div>
								</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<!-- end product Area -->
</body>
</html>