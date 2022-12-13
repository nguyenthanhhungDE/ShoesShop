<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
        <!-- left sidebar -->
        <!-- ============================================================== -->
        <div class="nav-left-sidebar sidebar-dark">
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">
                                <div class="avt">
                                    <div class="shop-avt"></div>
                                    <div class="info"></div>
                                </div>
                            </li>
                            <li class="nav-item" id="myid">
                                <!-- <button id="btn-order" class="nav-link" onclick="showOrders()"
                                    type="button">Danh sách đơn hàng</button> -->
                                <a id="btn-order" class="nav-link" href="#" aria-expanded="false" onclick="showOrders()"
                                    data-target="#submenu-1" aria-controls="submenu-1">Danh sách đơn hàng</a>
                                <a id="btn-product" class="nav-link" href="#" aria-expanded="false" onclick="showProducts()"
                                    data-target="#submenu-1" aria-controls="submenu-1">Danh sách sản phẩm</a>
                                <a id="btn-topproduct" class="nav-link" href="#" aria-expanded="false" onclick="showTopProducts()"
                                    data-target="#submenu-1" aria-controls="submenu-1">Danh sách top sản phẩm</a>
                                <a id="btn-topcustomer" class="nav-link" href="#" aria-expanded="false" onclick="showTopCustomers()"
                                    data-target="#submenu-1" aria-controls="submenu-1">Danh sách top khách hàng</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end left sidebar -->