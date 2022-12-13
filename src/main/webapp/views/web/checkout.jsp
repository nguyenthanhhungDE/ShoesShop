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
                    <h1>Checkout</h1>
                    <nav class="d-flex align-items-center">
                        <a href="<c:url value='/trang-chu'/>">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="single-product.html">Checkout</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    <!--================Checkout Area =================-->
    <section class="checkout_area section_gap">
        <div class="container">
            <div class="billing_details">
                <div class="row">
                    <div class="col-lg-8">
                        <h3>Billing Details</h3>
                        <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="first" name="name" readonly value="${userModel.lastname}">
                                <!-- <span class="placeholder">abc</span> -->
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="last" name="name" readonly value="${userModel.firstname}">
                                <!-- <span class="placeholder" data-placeholder="Last name"></span> -->
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="number" name="number" readonly value="${userModel.phone}">
                                <!-- <span class="placeholder" data-placeholder="Phone number"></span> -->
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="gender" name="gender" readonly value="${userModel.gender}">
                                <!-- <span class="placeholder" data-placeholder="Gender"></span> -->
                            </div>
                            <div class="col-md-12 form-group p_star">
                                <input type="text" class="form-control" id="add" name="add" readonly value="${userModel.address}">
                                <!-- <span class="placeholder" data-placeholder="Address"></span> -->
                            </div>
                            <!-- <div class="col-md-12 form-group">
                                <div class="creat_account">
                                    <input type="checkbox" id="f-option2" name="selector">
                                    <label for="f-option2">Create an account?</label>
                                </div>
                            </div> -->
                            <div class="col-md-12 form-group">
                                <div class="creat_account">
                                    <h3>Shipping Details</h3>
                                    <input type="checkbox" id="f-option3" name="selector" value="">
                                    <label for="f-option3">Ship to a different address?</label>
                                </div>
                                <textarea class="form-control" name="message" id="message" rows="1" placeholder="Order Notes" disabled></textarea>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-4">
                        <div class="order_box">
                            <h2>Your Order</h2>
                            <ul class="list">
                                <li><a href="#">Product <span>Total</span></a></li>
                                <c:forEach items="${orderDetail.detailModels}" var="p">
                                	<li style=" display: flex; justify-content: space-between;"><a href="#" class="an">${p.product.productname}</a> <span class="last">${p.total()}</span></li>
                                </c:forEach>
                            </ul>
                            <ul class="list list_2">
                                <li><a href="">Total <span>${orderDetail.sumTotal(orderDetail.detailModels)}</span></a></li>
                            </ul>
                            <button class="primary-btn" onclick="purchase()" type="button">Proceed to Purchase</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Checkout Area =================-->
</body>
</html>