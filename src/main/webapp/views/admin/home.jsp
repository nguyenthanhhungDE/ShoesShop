<%@page import="com.lhk.dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="dashboard-ecommerce">
                <div class="container-fluid dashboard-content ">
                    <div class="ecommerce-widget">
                        <div class="row">
                            <!-- recent orders  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12" id="table-order">
                                <div class="card">
                                    <h5 class="card-header">Recent Orders</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table" id="d">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">#</th>
                                                        <th class="border-0">Image</th>
                                                        <th class="border-0">Product Name</th>
                                                        <!-- <th class="border-0">Product Id</th> -->
                                                        <th class="border-0">Quantity</th>
                                                        <th class="border-0">Price</th>
                                                        <th class="border-0">Order Time</th>
                                                        <th class="border-0">Customer</th>
                                                        <th class="border-0">Status</th>
                                                        <th class="border-0">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="bdo">
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end recent orders  -->



                            <!-- Danh sách sản phẩm  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12" id="table-product">
                                <div class="card">
                                    <h5 class="card-header">Danh sách sản phẩm</h5>
                                    <div class="checkout_btn_inner align-items-center">
                                        <input type="button" onclick="showModal()" class="btn btn-primary" style="float: right;margin: 6px 12px 6px 0;line-height: 24px;padding: 3px 4px;
                                        border-radius: 4px;background: #5969ff;" value="Them san pham"></input>
                                    </div>
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
                                                        <th class="border-0">Discount</th>
                                                        <th class="border-0">Category Name</th>
                                                        <th class="border-0">Status</th>
                                                        <th class="border-0">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="bdp">
                                                
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end danh sách sản phẩm  -->
                            
                            
                            <!-- Danh sách top sản phẩm  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12" id="table-topproduct">
                                <div class="card">
                                    <h5 class="card-header">Danh sách top 5 sản phẩm bán chạy nhất</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">#</th>
                                                        <th class="border-0">Product ID</th>
                                                        <th class="border-0">Image</th>
                                                        <th class="border-0">Product Name</th>
                                                        <th class="border-0">Quantity</th>
                                                        <th class="border-0">Total</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="toppr">
                                                
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end danh top sách sản phẩm  -->
                            
                            
                            <!-- Danh sách top sản phẩm  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12" id="table-topcustomer">
                                <div class="card">
                                    <h5 class="card-header">Danh sách top khách hàng</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">#</th>
                                                        <th class="border-0">Customer ID</th>
                                                        <th class="border-0">Lastname</th>
                                                        <th class="border-0">Firstname</th>
                                                        <th class="border-0">Order number</th>
                                                        <th class="border-0">Total</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="topcus">
                                                
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end danh top sách sản phẩm  -->
                            
                            
                            <!-- modal thêm sản phẩm -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title" style="float: left;">Thêm sản phẩm</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="card">
                                                <div class="card-body">
                                                    <fieldset class="form-group">
                                                        <label>Product Name</label> <input type="text" value=""
                                                            class="form-control" name="productname" id="productname" required="required">
                                                    </fieldset>
                                    
                                                    <fieldset class="form-group">
                                                        <label>Image</label> <input type="text" value=""
                                                            class="form-control" name="image" id="image">
                                                    </fieldset>
                                    
                                                    <fieldset class="form-group">
                                                        <label>Quantity</label> <input type="text" value=""
                                                            class="form-control" name="quantity" id="quantity">
                                                    </fieldset>
                                    
                                                    <fieldset class="form-group">
                                                        <label>Price</label> <input type="text" value=""
                                                            class="form-control" name="price" id="price">
                                                    </fieldset>
                                    
                                                    <fieldset class="form-group">
                                                        <label>Discount</label> <input type="text" value=""
                                                            class="form-control" name="discount" id="discount">
                                                    </fieldset>
                                                    
                                                    <fieldset class="form-group">
                                                        <label>Size</label> <input type="text" value=""
                                                            class="form-control" name="size" id="size">
                                                    </fieldset>
                                    
                                                    <fieldset class="form-group">
                                                        <label>Category</label> 
                                                        <select name="categoryname" id="categoryid">
                                                            <c:forEach items="${categoryModels}" var="c">
                                                            	<option value="${c.categoryid}">${c.categoryname}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </fieldset>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-success" data-dismiss="modal" onclick="addProduct()">Save</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Modal sửa sản phẩm -->
                            <div class="modal fade" id="myEditModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title" style="float: left;">Sửa sản phẩm</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="card">
                                                <div class="card-body" id="editp">
                                                	
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-success" data-dismiss="modal" onclick="updateProduct()">Save</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end wrapper  -->
</body>
</html>