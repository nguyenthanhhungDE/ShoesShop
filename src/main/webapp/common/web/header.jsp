<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="<c:url value='/trang-chu'/>"><img src="<c:url value='/template/web/img/logo.png'/>" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="<c:url value='/trang-chu'/>">Home</a></li>
							<li class="nav-item submenu dropdown">
								<a href="<c:url value='/san-pham'/>" class="nav-link dropdown-toggle" role="button" aria-haspopup="true"
								 aria-expanded="false">Shop</a>
							</li>
							<c:if test="${not empty accountModel}">
								<li class="nav-item submenu dropdown">
									<a href="" class="nav-link dropdown-toggle">Hello, ${sessionScope.accountModel.username}</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value='/nguoi-dung'/>">My account</a></li>
										<li class="nav-item"><a class="nav-link" href='<c:url value="/dang-xuat"/>'>Logout</a></li>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty accountModel}">
								<li class="nav-item submenu dropdown">
									<a href='<c:url value="/dang-nhap"/>' class="nav-link dropdown-toggle" >Login</a>								
								</li>
								<li class="nav-item submenu dropdown">
									<a href='<c:url value="/dang-ky"/>' class="nav-link dropdown-toggle" role="button" aria-haspopup="true"
								 aria-expanded="false">Sign Up</a>
								</li>
							</c:if>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<%-- <li class="nav-item"><a href="<c:url value='/gio-hang'/>" class="cart"><span class="ti-shopping-cart"></span></a></li> --%>
							<li class="nav-item" id="b">
                                <a href="<c:url value='/gio-hang'/>" class="cart">
                                <c:if test="${not empty orderDetail.detailModels && not empty accountModel}">
                                	<span class="fa-stack fa-2x" data-count="${orderDetail.detailModels.size()}">
                                      <i class="ti-shopping-cart red-cart"></i>
                                	</span>
                               	</c:if>
                               	<c:if test="${empty orderDetail.detailModels || empty accountModel}">
                               		<span class="fa-2x" data-count="">
                                    	<i class="ti-shopping-cart red-cart"></i>
                                	</span>
                               	</c:if>
                                </a>
                            </li>
							<li class="nav-item">
								<button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="search_input" id="search_input_box">
			<div class="container">
				<form class="d-flex justify-content-between">
					<input type="text" value="${txt}" oninput="searchByName(this)" class="form-control" id="search_input" placeholder="Search Here">
					<button type="submit" class="btn"></button>
					<span class="lnr lnr-cross" onclick="loadAgain()" id="close_search" title="Close Search"></span>
				</form>
			</div>
		</div>
	</header>
	<!-- End Header Area -->