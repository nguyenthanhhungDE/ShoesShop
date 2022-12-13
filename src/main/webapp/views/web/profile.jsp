<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="container">
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Profile page</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">Profile</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<div class="nav-left-sidebar sidebar-widgets" style="top: 428px; position: absolute;">
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- <a class="d-xl-none d-lg-none" href="#">Dashboard</a> -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <div class="compo-ava">
                                <div class="avatar">
                                    <img src="https://cf.shopee.vn/file/648e11f9ede6595e8f61b0968c4ba5c4_tn" alt="user" style="width: 100%; height: 100%; border-radius: 50%;"> 
                                </div>
                                <div class="compo-content"><h6 style="margin-top: 10px;">Xin chao</h6></div>
                            </div>
                            <li class="nav-item">
                                <a class="nav-link" id="btn-info" href="#" onclick="showInfo()" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1">Tài khoản của tôi</a>
                                <a class="nav-link" id="btn-orderdetail" onclick="showOrderDetail()" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1">Đơn hàng</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end left sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="dashboard-ecommerce">
                <div class="container-fluid dashboard-content ">
                    <div class="ecommerce-widget">
                        <div class="row">
                                          <!-- infomation  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12" id="table-info">
                                <div class="card">
                                    <h3 class="card-header text-center text-uppercase">Thông Tin Cá Nhân</h3>
                                    <form class="contact_form form-info" novalidate="novalidate" id="if">
                                        <!-- <div class="col-md-6 form-group p_star">
                                            <span>Họ</span>
                                            <input type="text" class="form-control" id="first" name="name" value="">
                                        </div>
                                        <div class="col-md-6 form-group p_star">
                                            <span>Tên</span>
                                            <input type="text" class="form-control" id="last" name="name" value="">
                                        </div>
                                        <div class="col-md-6 form-group p_star">
                                            <span>Số điện thoại</span>
                                            <input type="text" class="form-control" id="number" name="number" value="">
                                        </div>
                                        <div class="col-md-6 form-group p_star">
                                            <span>Email</span>
                                            <input type="email" class="form-control" id="email" name="compemailany" value="" readonly>
                                        </div>
                                        <div class="col-md-12 form-group">
                                            <fieldset>
                                                <span>Giới tính</span>
                                                <div>
                                                  <input class="display" type="radio" id="contactChoice1" name="contact" value="male" checked="checked" />
                                                  <label for="contactChoice1">Nam</label>
                                            
                                                  <input class="display" type="radio" id="contactChoice2" name="contact" value="female" />
                                                  <label for="contactChoice2">Nữ</label>
                                            
                                                  <input class="display" type="radio" id="contactChoice3" name="contact" value="other" />
                                                  <label for="contactChoice3">Khác</label>
                                                </div>
                                              </fieldset>
                                        </div>
                                        <div class="col-md-12 form-group p_star">
                                            <span>Địa chỉ</span>
                                            <input type="text" class="form-control" id="add2" name="add2" value="">
                                        </div>
                                        <div class="col-md-12 form-group">
                                            <input type="button" class="btn btn-success" id="btn" name="btn" value="Lưu" onclick="saveInfo()"></input>
                                        </div> -->
                                    </form>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end infomation  -->


                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12" id="table-orderdetail">
                                <div class="card">
                                    <h5 class="card-header">Recent Orders</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">#</th>
                                                        <th class="border-0">Image</th>
                                                        <th class="border-0">Product Name</th>
                                                        <th class="border-0">Quantity</th>
                                                        <th class="border-0">Price</th>
                                                        <th class="border-0">Status</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="ord">
                                                    <!-- <tr>
                                                        <td>1</td>
                                                        <td>
                                                            <div class="m-r-10"><img
                                                                    src="assets/images/product-pic.jpg" alt="user"
                                                                    class="rounded" width="45"></div>
                                                        </td>
                                                        <td>Product #1 </td>
                                                        <td>20</td>
                                                        <td>$80.00</td>
                                                        <td><span
                                                                class="badge-dot badge-brand mr-1"></span>InTransit
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <td>
                                                            <div class="m-r-10"><img
                                                                    src="assets/images/product-pic-2.jpg" alt="user"
                                                                    class="rounded" width="45"></div>
                                                        </td>
                                                        <td>Product #2 </td>
                                                        <td>12</td>
                                                        <td>$180.00</td>
                                                        <td><span
                                                                class="badge-dot badge-success mr-1"></span>Delivered
                                                        </td>
                                                    </tr> -->
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
</body>
</html>