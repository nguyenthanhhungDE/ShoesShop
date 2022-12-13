package com.lhk.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.OrderDetailModel;
import com.lhk.model.OrderModel;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = { "/change" })
public class QuantityIncDecController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String qty = req.getParameter("qty");
//		String pid = req.getParameter("pid");
//		String size = req.getParameter("size");
		
//		OrderModel orderModel = (OrderModel)SessionUtils.getInstance().getValue(req, "orderDetail");
//		List<OrderDetailModel> detailModels = orderModel.getDetailModels();
//		
//		for(OrderDetailModel x : detailModels) {
//			/*Them san pham da ton tai thi tang so luong*/
//			if (x.getProduct().getProductid().equals(pid) && x.getSize() == Integer.parseInt(size)) {
//				x.setQuantity(Integer.parseInt(qty));
//			}
//		}
//		
//		SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
//		
//		PrintWriter out = resp.getWriter();
//		
//		for(OrderDetailModel i : detailModels) {
//			if(i.getProduct().getProductid().equals(pid) && i.getSize() == Integer.parseInt(size)) {
//				out.println("<h5>"+i.getPrice() * i.getQuantity()+"</h5>");
//			}
//		}
		
		String action = req.getParameter("action");
		String pid = req.getParameter("pid");
		int size = Integer.parseInt(req.getParameter("size"));
		
		OrderModel orderModel = (OrderModel)SessionUtils.getInstance().getValue(req, "orderDetail");
		List<OrderDetailModel> list = orderModel.getDetailModels();
		
		try {
			if (action.equals("inc")) {
				for(OrderDetailModel x : list) {
					if (x.getProduct().getProductid().equals(pid) && x.getSize() == size) {
						int qty = x.getQuantity();
						qty++;
						x.setQuantity(qty);
						SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
					}
				}
			}
			
			if (action.equals("dec")) {
				for(OrderDetailModel x : list) {
					if (x.getProduct().getProductid().equals(pid) && x.getQuantity() >= 1 && x.getSize() == size) {
						int qty = x.getQuantity();
						qty--;
						if(qty < 1) {
							qty = 1;
						}
						x.setQuantity(qty);
						break;
					}
				}
				
				SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
			}
		}
		catch (Exception e) {
			PrintWriter out = resp.getWriter();
			out.println(e.getMessage());
		}
	}
}
