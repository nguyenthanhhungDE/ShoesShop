<%@page import="com.lhk.model.ProductModel"%>
<%@page import="java.util.List"%>
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
					<h1>Shop Category page</h1>
					<nav class="d-flex align-items-center">
						<a href="<c:url value='/trang-chu'/>">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Fashon Category</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
	<div class="container container-lhk">
		<div class="row">
			<div class="col-xl-3 col-lg-4 col-md-5">
				<div class="sidebar-categories">
					<div class="head">Browse Categories</div>
					<ul class="main-categories">
					<c:forEach var="o" items="${categories}">
						<li class="main-nav-list active">
							<a class="border-bottom-0" onclick='searchByCategory("${o.categoryid}")' <%-- href="san-pham?cid=${o.categoryid}" --%> aria-expanded="false" style="cursor: pointer;">
								<span class="lnr lnr-arrow-right"></span>${o.categoryname}
								<!-- <span class="number">(48)</span> -->
							</a>
						</li>
					</c:forEach>
					</ul>
				</div>
				<div class="sidebar-filter mt-50">
					<%-- <div class="top-filter-head">Product Filters</div>
					<div class="common-filter">
						<div class="head">Brands</div>
						
						<form action="#">
						<c:forEach var="p" items="${brandbyid}">
							<ul>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="apple" name="brand"><label for="apple">${p.productname}<span>(29)</span></label></li>
							</ul>
						</c:forEach>
						</form>
						
					</div> --%>
					<!-- <div class="common-filter">
						<div class="head">Price</div>
						<ul>
							<li class="filter-list"><input class="pixel-radio" type="radio" value="1" name="price"><label>500000đ<span> - </span>1000000đ</label></li>
							<li class="filter-list"><input class="pixel-radio" type="radio" value="2" name="price"><label>1000000đ<span> - </span>1500000đ</label></li>
							<li class="filter-list"><input class="pixel-radio" type="radio" value="3" name="price"><label>1500000đ<span> - </span>2000000đ</label></li>
						</ul>
					</div> -->
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-7" id="m">
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="row" id="searchp">
						<!-- single product -->
						<c:forEach items="${products}" var="p">
							<div class="col-lg-4 col-md-6 lhk">
								<a href="san-pham-chi-tiet?pid=${p.productid}">
									<div class="single-product single-product-lhk">
										<img class="img-fluid img-lhk" src="${p.image}" alt="" />
										<div class="product-details product-details-lhk">
											<h6>${p.productname}</h6>
											<div class="price price-lhk">
												<h6>${p.discount}</h6>
												<h6 class="l-through">${p.price}d</h6>
											</div>
										</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</section>
				<!-- End Best Seller -->
				<!-- <div id="l" onclick="load()" class="btn-primary loadMore" style="
				display: block;
				width: 180px;
				height: 40px;
				text-align: center;
				border-radius: 8px;
				line-height: 38px;
				margin-left: auto;
				margin-right: auto;
				cursor: pointer;
				">Load More</div> -->
			</div>
			<!-- <div id="l" style="width: 100%; margin-left: 300px;">
				<div onclick="load()" class="btn-primary loadMore" style="
				display: block;
				width: 180px;
				height: 40px;
				text-align: center;
				border-radius: 8px;
				line-height: 38px;
				margin-left: auto;
				margin-right: auto;
				cursor: pointer;
				">Load More</div>
			</div> -->
		</div>
	</div>
</body>
</html>