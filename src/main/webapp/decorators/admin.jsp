<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin page</title>

<link rel="stylesheet"
	href='<c:url value="/template/admin/css/bootstrap.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/template/admin/css/style.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/template/admin/css/libs/css/style.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/template/admin/css/libs/css/styles.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/template/admin/css/themify-icons.csss"/>'>
	<style>
        #table-order {
            display: none;
        }

        #table-product {
            display: none;
        }
        
        #table-topproduct{
        	display: none;
        }
        
        #table-topcustomer {
        	display: none;
        }
    </style>
    <style type="text/css">
	    .disabled {
		  pointer-events: none;
		  cursor: default;
		}
	</style>
</head>
<body>

	<!-- main wrapper -->
    <!-- ============================================================== -->
    <div class="dashboard-main-wrapper">

		<jsp:include page="/common/admin/header.jsp" flush="true"/>
		
		<jsp:include page="/common/admin/left.jsp" flush="true"/>
		
		<!-- start body -->
		<dec:body/>
		<!-- end body -->
	
	</div>
    <!-- ============================================================== -->
    <!-- end main wrapper  -->


	<script
		src='<c:url value="/template/admin/js/vendor/jquery-2.2.4.min.js"/>'></script>
	<script
		src='<c:url value="/template/admin/js/vendor/bootstrap.bundle.js"/>'></script>
	<script type="text/javascript">
		const btn_order = document.getElementById('btn-order');
	    const btn_product = document.getElementById('btn-product');
	    const btn_topproduct = document.getElementById('btn-topproduct');
	    const btn_topcustomer = document.getElementById('btn-topcustomer');
	    const table_order = document.getElementById('table-order');
	    const table_product = document.getElementById('table-product');
	    const table_topproduct = document.getElementById('table-topproduct');
	    const table_topcustomer = document.getElementById('table-topcustomer');
	    var myid = document.getElementById('myid');
	    var nav_link = document.getElementsByClassName('nav-link');
	
	
	    btn_order.addEventListener('click', function () {
	        if (table_order.style.display == '') {
	            table_order.style.display = 'block';
	            table_product.style.display = '';
	            table_topproduct.style.display = '';
	            table_topcustomer.style.display = '';
	        }
	    });
	
	    btn_product.addEventListener('click', function () {
	        if (table_product.style.display == '') {
	            table_product.style.display = 'block';
	            table_order.style.display = '';
	            table_topproduct.style.display = '';
	            table_topcustomer.style.display = '';
	        }
	    });
	    
	    btn_topproduct.addEventListener('click', function () {
	        if (table_topproduct.style.display == '') {
	        	table_topproduct.style.display = 'block';
	            table_order.style.display = '';
	            table_product.style.display = '';
	            table_topcustomer.style.display = '';
	        }
	    });
	    
	    btn_topcustomer.addEventListener('click', function () {
	        if (table_topcustomer.style.display == '') {
	        	table_topcustomer.style.display = 'block';
	            table_order.style.display = '';
	            table_product.style.display = '';
	            table_topproduct.style.display = '';
	        }
	    });
	
	    for (var i = 0; i < nav_link.length; i++) {
	        nav_link[i].addEventListener('click', function () {
	            var current = document.getElementsByClassName("active");
	
	            if (current.length > 0) {
	                current[0].className = current[0].className.replace(" active", "");
	            }
	
	            this.className += " active";
	        });
	    }
	</script>
	<script type="text/javascript">
		function showOrders() {
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-home",
				type: "post",
				data: {
					action: "order"
				},
				success: function (response){
					var r = document.getElementById("bdo");
					r.innerHTML = response;
				}
			});
		}
		
		function showProducts() {
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-home",
				type: "post",
				data: {
					action: "product"
				},
				success: function (response){
					var r = document.getElementById("bdp");
					r.innerHTML = response;
				}
			});
		}
		
		function showTopProducts() {
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-home",
				type: "post",
				data: {
					action: "topproduct"
				},
				success: function (response){
					var r = document.getElementById("toppr");
					r.innerHTML = response;
				}
			});
		}
		
		function showTopCustomers() {
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-home",
				type: "post",
				data: {
					action: "topcustomer"
				},
				success: function (response){
					var r = document.getElementById("topcus");
					r.innerHTML = response;
				}
			});
		}
		
		function editOrders(id, act){
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-edit",
				type: "post",
				data: {
					orderid: id,
					action: act
				},
				success: function (response){
					showOrders();
				}
			});
		}
		function addProduct(){
			var prname = $('#productname').val();
			var pimage = $('#image').val();
			var pquantity = $('#quantity').val();
			var pprice = $('#price').val();
			var pdiscount = $('#discount').val();
			var psize = $('#size').val();
			var cid = $('#categoryid').val();
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-addproduct",
				type: "post",
				data: {
					productname: prname,
					image: pimage,
					quantity: pquantity,
					price: pprice,
					discount: pdiscount,
					size: psize,
					categoryid: cid
				},
				success: function (response){
					showProducts();
				}
			});
		}
		
		function updateProduct(){
			var prname = $('#uproductname').val();
			var pimage = $('#uimage').val();
			var pquantity = $('#uquantity').val();
			var pprice = $('#uprice').val();
			var pdiscount = $('#udiscount').val();
			var pid = $('#uproductid').val();
			var cid = $('#ucategoryid').val();
			var pstatus = $('#ustatus').val();
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-updateproduct",
				type: "post",
				data: {
					productname: prname,
					image: pimage,
					quantity: pquantity,
					price: pprice,
					discount: pdiscount,
					productid: pid,
					categoryid: cid,
					status: pstatus
				},
				success: function (response){
					showProducts();
				}
			});
		}
		
		function removeProduct(id){
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-removeproduct",
				type: "post",
				data: {
					pid: id
				},
				success: function (response){
					showProducts();
				}
			});
		}
		
		function showModal() {
            $('#myModal').modal('show');
        }
		
		function showEditModal(id){
			$.ajax({
				url: "/Jsp_Servlet_MVC/admin-home",
				type: "post",
				data: {
					pid: id,
					action: "editproduct"
				},
				success: function (response){
					var r = document.getElementById("editp");
					r.innerHTML = response;
				}
			});
            $('#myEditModal').modal('show');
        }
	</script>
</body>
</html>