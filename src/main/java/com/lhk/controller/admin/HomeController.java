package com.lhk.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.dto.OrderDTO;
import com.lhk.dto.ProductDTO;
import com.lhk.dto.TopCustomerDTO;
import com.lhk.dto.TopProductDTO;
import com.lhk.model.CategoryModel;
import com.lhk.model.ProductModel;
import com.lhk.service.ICategoryService;
import com.lhk.service.ICustomerService;
import com.lhk.service.IOrderService;
import com.lhk.service.IProductService;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrderService iOrderService;
	
	@Inject
	private IProductService iProductService;
	
	@Inject
	private ICategoryService iCategoryService;
	
	@Inject
	private ICustomerService iCustomerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		
		if (obj != null) {
			List<CategoryModel> categoryModels = iCategoryService.findAllCategory();
			req.setAttribute("categoryModels", categoryModels);
			req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		String action = req.getParameter("action");
		String status = "";
		String clas = "";
		String disable = "";
		
		if(action.equals("order")) {
			List<OrderDTO> models = iOrderService.findAllOrders();
			
			PrintWriter out = resp.getWriter();
			int i = 1;
			for(OrderDTO o : models) {
				if(o.getStatus() == 0) {
					status = "Chua duyet";
					clas = "badge-brand";
					disable = "";
				}
				else if(o.getStatus() == 1){
					status = "Da duyet";
					clas = "badge-success";
					disable = "disabled";
				}
				else if (o.getStatus() == 2) {
					status = "Huy";
					clas = "badge-danger";
					disable = "disabled";
				}
				out.println("<tr>\r\n"
						+ "	                                                        <td>"+i+"</td>\r\n"
						+ "	                                                        <td>\r\n"
						+ "	                                                            <div class=\"m-r-10\"><img\r\n"
						+ "	                                                                    src=\""+o.getImage()+"\" alt=\"image\"\r\n"
						+ "	                                                                    class=\"rounded\" width=\"45\"></div>\r\n"
						+ "	                                                        </td>\r\n"
						+ "	                                                        <td>"+o.getProductname()+" </td>\r\n"
						+ "	                                                        <!-- <td>id000001 </td> -->\r\n"
						+ "	                                                        <td>"+o.getQuantity()+"</td>\r\n"
						+ "	                                                        <td>"+o.getPrice()+"</td>\r\n"
						+ "	                                                        <td>"+o.getOrderdate()+"</td>\r\n"
						+ "	                                                        <td>"+o.getLastname() +" " + o.getFirstname()+" </td>\r\n"
						+ "		                                                    <td><span class=\"badge-dot "+clas+" mr-1\"></span>"+status+"\r\n"
						+ "		                                                    </td>\r\n"
						+ "	                                                        <td><a href=\"#\" class=\""+disable+"\" onclick=\"editOrders('"+o.getOrderdetailid()+"', '"+'D'+"')\">Duyet</a> | <a href=\"#\" class=\""+disable+"\" onclick=\"editOrders('"+o.getOrderdetailid()+"', '"+'H'+"')\">Huy</a></td>\r\n"
						+ "	                                                    </tr>");
				i++;
			}
		}
		else if (action.equals("product")){
			resp.setCharacterEncoding("UTF-8");
			List<ProductDTO> pmodels = iProductService.findAllProducts();
			PrintWriter out = resp.getWriter();
			int i = 1;
			for(ProductDTO p : pmodels) {
				if(p.getStatus() == 0) {
					status = "Het hang";
					clas = "badge-brand";
				}
				else {
					status = "Con hang";
					clas = "badge-success";
				}
				out.println("<tr>\r\n"
						+ "                                                        <td>"+i+"</td>\r\n"
						+ "                                                        <td>\r\n"
						+ "                                                            <div class=\"m-r-10\"><img src=\""+p.getImage()+"\"\r\n"
						+ "                                                                    alt=\"user\" class=\"rounded\" width=\"45\"></div>\r\n"
						+ "                                                        </td>\r\n"
						+ "                                                        <td>"+p.getProductname()+" </td>\r\n"
						+ "                                                        <td>"+p.getQuantity()+"</td>\r\n"
						+ "                                                        <td>"+p.getPrice()+"</td>\r\n"
						+ "                                                        <td>"+p.getDiscount()+"</td>\r\n"
						+ "                                                        <td>"+p.getCategoryname()+" </td>\r\n"
						+ "                                                        <td><span class=\"badge-dot "+clas+" mr-1\"></span>"+status+"\r\n"
						+ "                                                        </td>\r\n"
						+ "                                                        <td><a href=\"#\" onclick=\"showEditModal('"+p.getProductid()+"')\">Sửa</a> | <a href=\"#\" onclick=\"removeProduct('"+p.getProductid()+"')\">Xóa</a></td>\r\n"
						+ "                                                    </tr>");
				i++;
			}
			
		}
		else if (action.equals("topproduct")) {
			List<TopProductDTO> topProducts = iProductService.topProducts();
			PrintWriter out = resp.getWriter();
			int i = 1;
			for(TopProductDTO t : topProducts) {
				out.println("<tr>\r\n"
						+ "                                                        <td>"+i+"</td>\r\n"
						+ "                                                        <td>"+t.getProductid()+" </td>\r\n"
						+ "                                                        <td>\r\n"
						+ "                                                            <div class=\"m-r-10\"><img src=\""+t.getImage()+"\"\r\n"
						+ "                                                                    alt=\"user\" class=\"rounded\" width=\"45\"></div>\r\n"
						+ "                                                        </td>\r\n"
						+ "                                                        <td>"+t.getProductname()+"</td>\r\n"
						+ "                                                        <td>"+t.getQuantity()+"</td>\r\n"
						+ "                                                        <td>"+t.getTotal()+"</td>\r\n"
						+ "                                                    </tr>");
				i++;
			}
		}
		else if (action.equals("topcustomer")) {
			List<TopCustomerDTO> topCustomers = iCustomerService.topCustomers();
			PrintWriter out = resp.getWriter();
			int i = 1;
			for(TopCustomerDTO cu : topCustomers) {
				out.println("<tr>\r\n"
						+ "                                                        <td>"+i+"</td>\r\n"
						+ "                                                        <td>"+cu.getCustomerid()+" </td>\r\n"
						+ "                                                        <td>"+cu.getLastname()+" </td>\r\n"
						+ "                                                        <td>"+cu.getFirstname()+"</td>\r\n"
						+ "                                                        <td>"+cu.getOrdernumber()+"</td>\r\n"
						+ "                                                        <td>"+cu.getTotal()+"</td>\r\n"
						+ "                                                    </tr>");
				i++;
			}
		}
		else if (action.equals("editproduct")) {
			String pid = req.getParameter("pid");
			ProductModel productModel = iProductService.findProductByProductId(pid).get(0);
			CategoryModel categoryModel = iCategoryService.findCategoryByProductId(pid).get(0);
			
			String x = "";
			
			if (productModel.getStatus() == 1) {
				x = "<option value=\"1\">Con hang</option>\r\n" + "<option value=\"0\">Het hang</option>\r\n";
			}
			else {
				x = "<option value=\"0\">Het hang</option>\r\n" + "<option value=\"1\">Con hang</option>\r\n";
			}
			
			PrintWriter out = resp.getWriter();
			out.println("<fieldset class=\"form-group\">\r\n"
					+ "                                                        <label>Product Name</label> <input type=\"text\" value=\""+productModel.getProductname()+"\"\r\n"
					+ "                                                            class=\"form-control\" name=\"productname\" id=\"uproductname\" required=\"required\">\r\n"
					+ "                                                            <input type=\"hidden\" value=\""+productModel.getProductid()+"\" name=\"\" id=\"uproductid\">\r\n"
					+ "                                                    </fieldset>\r\n"
					+ "                                    \r\n"
					+ "                                                    <fieldset class=\"form-group\">\r\n"
					+ "                                                        <label>Image</label> <input type=\"text\" value=\""+productModel.getImage()+"\"\r\n"
					+ "                                                            class=\"form-control\" name=\"image\" id=\"uimage\">\r\n"
					+ "                                                    </fieldset>\r\n"
					+ "                                    \r\n"
					+ "                                                    <fieldset class=\"form-group\">\r\n"
					+ "                                                        <label>Quantity</label> <input type=\"text\" value=\""+productModel.getQuantity()+"\"\r\n"
					+ "                                                            class=\"form-control\" name=\"quantity\" id=\"uquantity\">\r\n"
					+ "                                                    </fieldset>\r\n"
					+ "                                    \r\n"
					+ "                                                    <fieldset class=\"form-group\">\r\n"
					+ "                                                        <label>Price</label> <input type=\"text\" value=\""+productModel.getPrice()+"\"\r\n"
					+ "                                                            class=\"form-control\" name=\"price\" id=\"uprice\">\r\n"
					+ "                                                    </fieldset>\r\n"
					+ "                                    \r\n"
					+ "                                                    <fieldset class=\"form-group\">\r\n"
					+ "                                                        <label>Discount</label> <input type=\"text\" value=\""+productModel.getDiscount()+"\"\r\n"
					+ "                                                            class=\"form-control\" name=\"discount\" id=\"udiscount\">\r\n"
					+ "                                                    </fieldset>\r\n"
					+ "                                                    \r\n"
					+ "                                                    <fieldset class=\"form-group\">\r\n"
					+ "                                                        <label>Category</label> <input type=\"text\" value=\""+categoryModel.getCategoryname()+"\"\r\n"
					+ "                                                            class=\"form-control\" name=\"category\" id=\"category\" readonly>\r\n"
					+ "                                                            <input type=\"hidden\" value=\""+categoryModel.getCategoryid()+"\" name=\"\", id=\"ucategoryid\">\r\n"
					+ "                                                    </fieldset>\r\n"
					+ "                                                    \r\n"
					+ "                                                    <fieldset class=\"form-group\">\r\n"
					+ "                                                        <label>Status</label> \r\n"
					+ "                                                        <select name=\"\" id=\"ustatus\">\r\n"
					+ 															x
					+ "                                                        </select>\r\n"
					+ "                                                    </fieldset>");
		}
	}
}
