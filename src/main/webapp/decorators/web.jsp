<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="template/web/img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Karma Shop</title>
	<!--
		CSS
		============================================= -->
	<link rel="stylesheet" href="<c:url value='/template/web/css/linearicons.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/font-awesome.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/themify-icons.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/owl.carousel.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/nice-select.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/nouislider.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/ion.rangeSlider.css'/>" />
	<link rel="stylesheet" href="<c:url value='/template/web/css/ion.rangeSlider.skinFlat.css'/>" />
	<link rel="stylesheet" href="<c:url value='/template/web/css/magnific-popup.css'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/css/main.css'/>">
	<style>
        .display {
            display: inline-block !important;
            margin-left: 20px;
        }
        .form-info {
            margin-top: 30px;
            display: flex ;
            flex-wrap: wrap;
            margin-right: 0;
            margin-left: 0;
        }
        #table-info {
            display: none;
        }

        #table-orderdetail {
            display: none;
        }
    </style>
	<link rel="stylesheet" href="<c:url value='/template/admin/css/libs/css/style.css'/>">
	<!-- <style>
		.lhk {
			display: none;
		}
		.lhk:nth-child(1){
			display: block;
		}
		.lhk:nth-child(2){
			display: block;
		}
		.lhk:nth-child(3){
			display: block;
		}
	</style> -->
</head>
<body>

	<!-- start header -->
	<%@ include file="/common/web/header.jsp" %>
	<%-- <jsp:include page="/common/web/header.jsp" flush="true"/> --%>
	<!-- end header -->

	<!-- start body -->
	<dec:body/>
	<!-- end body -->

	<!-- start footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- end footer -->

	<script src="<c:url value='/template/web/js/vendor/jquery-2.2.4.min.js'/>"></script>
	<script src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js'/>" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="<c:url value='/template/web/js/vendor/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.ajaxchimp.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.nice-select.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.sticky.js'/>"></script>
	<script src="<c:url value='/template/web/js/nouislider.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/countdown.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.magnific-popup.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
	<!--gmaps Js-->
	<script src="<c:url value='https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE'/>"></script>
	<script src="<c:url value='/template/web/js/gmaps.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/main.js'/>"></script>
	<script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>
	
	<script type="text/javascript">
		let deductBtnArr = document.getElementsByClassName('dec');
	    let addButtonArr = document.getElementsByClassName('inc');
	
	    for(let deductBtn of deductBtnArr){
	        deductBtn.onclick = function() {
	            let currentInputBox = deductBtn.previousElementSibling;
	            currentInputBox.value = currentInputBox.value - 1;
	            if (currentInputBox.value == 0){
	                currentInputBox.value = 1;
	            }
	        }
	    }
	
	    for(let addButton of addButtonArr){
	        addButton.onclick = () => {
	            let currentInputBox = addButton.nextElementSibling;
	            currentInputBox.value = parseInt(currentInputBox.value) + 1;
	        }
	    }
    </script>
    
    <script>
	    var item = document.querySelectorAll('.lhk');
		var btnload = document.querySelector('.loadMore');
		var currentitem = 3;
		function load(){
			for(var i = currentitem; i < currentitem + 3; i++){
				if(item[i]){
					item[i].style.display = 'block';
				}
			}
			currentitem += 3;
			if(currentitem >= item.length){
				event.target.style.display = 'none';
			}
		}
		
	</script>
	
	<script type="text/javascript">
		var check = document.getElementById('f-option3');
	    check.addEventListener('change', function(){
    	var textarea = document.getElementById('message');
	    	if(check.checked){
	    		textarea.removeAttribute("disabled");
	    		$('#f-option3').val("on");
	    	}
	    	else{
	    		textarea.setAttribute("disabled", "disabled");
	    	}
    	});
	</script>
	
	
	<script type="text/javascript">
		var nav_link = document.getElementsByClassName('nav-link');
	    const btn_info = document.getElementById('btn-info');
	    const btn_orderdetail = document.getElementById('btn-orderdetail');
	    const table_info = document.getElementById('table-info');
	    const table_orderdetail = document.getElementById('table-orderdetail');
	    
	    btn_info.addEventListener('click', function () {
	        if (table_info.style.display == '') {
	        	table_info.style.display = 'block';
	        	table_orderdetail.style.display = '';
	        }
	    });
	
	    btn_orderdetail.addEventListener('click', function () {
	        if (table_orderdetail.style.display == '') {
	        	table_orderdetail.style.display = 'block';
	            table_info.style.display = '';
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
	
		function change(id, s, ac) {
			$.ajax({
            	url: "/Jsp_Servlet_MVC/change",
            	type: "get", //send it through get method
            	data: {
            	  	pid: id,
            	  	size: s,
            	  	action: ac
            	},
            	success: function(response) {
            		$("#a").load(location.href + " #a > *", "");
            	}
            });
		}
		
		function searchByName(param){
			var txtsearch = param.value;
			$.ajax({
            	url: "/Jsp_Servlet_MVC/tim-kiem",
            	type: "post",
            	data: {
            	  	search: txtsearch
            	},
            	success: function(response) {
            		var r = document.getElementById("searchp");
					r.innerHTML = response;
            	}
            });
		}
		
		function loadAgain(){
			$.ajax({
            	url: "/Jsp_Servlet_MVC/tim-kiem",
            	type: "post", //send it through get method
            	data: {
            	  	search: ""
            	},
            	success: function(response) {
            		$("#m").load(location.href + " #m > *", "");
            	}
            });
		}
		
		function searchByCategory(id){
			$.ajax({
            	url: "/Jsp_Servlet_MVC/san-pham",
            	type: "post",
            	data: {
            	  	cid: id
            	},
            	success: function(response) {
            		//$('.lhk').remove();
            		//$('.lhk').css("display", "block");
            		$('#searchp').empty();
            		var r = document.getElementById("searchp");
					r.innerHTML = response;
					//$("#l").load(location.href + " #l > *", "");
            	}
            });
		} 
		
		function removeCart(id) {
			$.ajax({
				url: "/Jsp_Servlet_MVC/xoa-san-pham",
				type: "get",
				data: {
					pid: id
				},
				success: function (response) {
					//$("#a").load(location.href + " #a > *", "");
					$("#b").load(location.href + " #b > *", "");
					$("#c").load(location.href + " #c > *", "");
				}
			});
		}
		
		$(document).ready(function(){
			$('#click').click(function(){
				var pid = $('#pid').val();
				var pdiscount = $('#pdiscount').val();
				var size = $('#size').val();
				var qty = $('#qty').val();
				$.ajax({
					url: "/Jsp_Servlet_MVC/them-gio-hang",
					type: "post",
					data: {
						pid: pid,
						pdiscount: pdiscount,
						size: size,
						qty: qty
					},
					success: function (response){
						console.log(response);
						if(response == ""){
							$("#b").load(location.href + " #b > *", "");
						}
						else{
							window.location.href = '/Jsp_Servlet_MVC/dang-nhap';
						}
					}
				});
			});
		});
		
		function purchase() {
			var mess = $('#message').val();
			var op = $('#f-option3').val();
			var add = $('#add').val();
			$.ajax({
				url: "/Jsp_Servlet_MVC/mua-hang",
				type: "post",
				data: {
					message: mess,
					option: op,
					address: add
				},
				success: function (response){
					window.location.href = '/Jsp_Servlet_MVC/views/web/success.jsp';
				}
			});
		}
		
		function showInfo(){
			$.ajax({
				url: "/Jsp_Servlet_MVC/nguoi-dung",
				type: "post",
				data: {
					action: "info"
				},
				success: function (response){
					var r = document.getElementById("if");
					r.innerHTML = response;
				}
			});
		}
		
		function showOrderDetail(){
			$.ajax({
				url: "/Jsp_Servlet_MVC/nguoi-dung",
				type: "post",
				data: {
					action: "ord"
				},
				success: function (response){
					var r = document.getElementById("ord");
					r.innerHTML = response;
				}
			});
		}
		
		function saveInfo(id){
			var g = $('input[type="radio"][class="display"]:checked').val();
			var fname = $('#first').val();
			var lname = $('#last').val();
			var phone = $('#number').val();
			var add = $('#add2').val();
			$.ajax({
				url: "/Jsp_Servlet_MVC/nguoi-dung",
				type: "post",
				data: {
					action: "editInfo",
					customerid: id,
					firstname: fname,
					lastname: lname,
					phone: phone,
					gender: g,
					address: add
					
				},
				success: function (response){
					showInfo();
					alert("Thanh cong");
				}
			});
		}
	
	</script>
</body>
</html>