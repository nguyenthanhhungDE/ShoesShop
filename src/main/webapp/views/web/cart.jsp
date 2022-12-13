<%@page import="java.util.List"%>
<%@page import="com.lhk.model.OrderDetailModel"%>
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
                    <h1>Shopping Cart</h1>
                    <nav class="d-flex align-items-center">
                        <a href="trang-chu">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="#">Cart</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    <!--================Cart Area =================-->
    <section class="cart_area">
        <div class="container">
            <div class="cart_inner" id="c">
            <c:if test="${empty orderDetail.detailModels}">
            	<div class="compo">
            		<div class="compo-img">
            		</div>
            		<div class="compo-char">Giỏ hàng của bạn còn trống</div>
            		<button class="btn-primary compo-button">Mua hàng</button>
            	</div>
            </c:if>
            <c:if test="${not empty orderDetail.detailModels}">
                <div class="table-responsive">
                    <table class="table" id="a">
                        <thead>
                            <tr>
                                <th scope="col">Product</th>
                                <th scope="col">Size</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${orderDetail.detailModels}" var="p">
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="${p.product.image}" alt="" style="width: 140px; height: 110px;">
                                        </div>
                                        <div class="media-body">
                                            <p>${p.product.productname}</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                	<h5>${p.size}</h5>
                                </td>
                                <td>
                                    <h5>${p.price}</h5>
                                </td>
                                <td>
                                    <div class="product_count" id="content">
                                        <button
                                        class=" increase items-count" type="button" onclick='change("${p.product.productid}", "${p.size}", "inc")'><i class="lnr lnr-chevron-up"></i></button>
                                        <input type="text" name="qty" value="${p.quantity}" maxlength="2" max="10" min="1" size="1" id="number" class="input-text qty"/ readonly>
                                        <button
                                        class=" reduced items-count" type="button" onclick='change("${p.product.productid}", "${p.size}", "dec")'><i class="lnr lnr-chevron-down"></i></button>
                                    </div>
                                </td>
                                <td>
                                   <%--  <h5>${p.quantity * p.price}</h5> --%>
                                   <h5>${p.total()}</h5>
                                </td>
                                <td>
                                    <a onclick="removeCart('${p.product.productid}')" style="cursor: pointer;"><span class="ti-close"></span></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <div class="d-flex align-items-center" style="float: right;">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><h5>Subtotal</h5></td>
                                    <%-- <c:set var="total" value="${0}" />
                                    <c:forEach items="${orderDetail.detailModels}" var="t">
                                    	<c:set var="total" value="${total + t.quantity * t.price}" />
                                    </c:forEach>
                                    <td><h5>${total}</h5></td> --%>
                                    <td><h5>${orderDetail.sumTotal(orderDetail.detailModels)}</h5></td>
                                </div>
                            </tr>
                        </tfoot>
                    </table>
                    <div class="checkout_btn_inner d-flex align-items-center" style="float: right;">
                        <a class="gray_btn" href="<c:url value='/san-pham'/>">Continue Shopping</a>
                        <a class="primary-btn" href="<c:url value='/mua-hang'/>" style="line-height: 39px; border-radius: 0;">Proceed to checkout</a>
                    </div>
                </div>
            </c:if>
            </div>
        </div>
    </section>
    <!--================End Cart Area =================-->
</body>
</html>