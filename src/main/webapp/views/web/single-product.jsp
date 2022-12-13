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
					<h1>Product Details Page</h1>
					<nav class="d-flex align-items-center">
						<a href="<c:url value='/trang-chu'/>">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="san-pham">Shop<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">product-details</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Single Product Area =================-->
	<div class="product_image_area product_image_area-lhk">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="s_Product_carousel">
						<div class="single-prd-item">
							<img class="img-fluid" src="${productdetail.image}" alt="" style="width: -webkit-fill-available;">
						</div>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<form>
						<div class="s_product_text">
							<input name="pid" id="pid" type="hidden" value="${productdetail.productid}"/>
							<input name="pdiscount" id="pdiscount" type="hidden" value="${productdetail.discount}"/>
							<h3>${productdetail.productname}</h3>
							<h2>${productdetail.discount}</h2>
							<ul class="list">
								<li><a class="active" href="#"><span>Category</span> :
										${category.getCategoryname()}</a></li>
								<!-- <li><a href="#"><span>Availibility</span> : In Stock</a></li> -->
							</ul>
							<div class="product_size">
								<!-- <label for="size">Size:</label> -->
								<span>Size:</span>
								<div class="btn-group" role="group" aria-label="First group">
									<select name="size" id="size">
										<c:forEach items="${productsize}" var="p">
											<option value="${p.size}">${p.size}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="product_count product_count-lhk">
								<label for="qty">Quantity:</label> 
								<button
								 class="increase items-count inc" type="button"><i class="lnr lnr-chevron-up"></i></button>
								 <input type="text" name="qty" value="1" maxlength="2" max="10" size="1" id="qty" class="input-text qty" readonly/>
								 <button
								 class="reduced items-count dec" type="button"><i class="lnr lnr-chevron-down"></i></button>
							</div>
							<div class="card_area d-flex align-items-center">
								<button class="primary-btn" id="click" type="button">Add to Cart</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->
</body>
</html>