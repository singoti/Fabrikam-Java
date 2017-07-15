package com.fabrikam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fabrikam.common.Customer;
import com.fabrikam.db.DataAccess;

/**
 * Servlet implementation class CreateCustomers
 */
public class CreateCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip"); 
		String action = request.getParameter("action");
		Customer customer = new Customer(firstName,lastName,street,
				city,state,zip);
		DataAccess access = DataAccess.getInstance();
		if ("edit".equalsIgnoreCase(action)){
			String id = request.getParameter("id");
			int idNo=Integer.parseInt(id);
			customer.setId(idNo);
			if (access.updateCustomer(customer)){
				response.sendRedirect("CustomerIndex.jsp");
			}		
		}
		else {
			if (access.saveCustomer(customer)){
				response.sendRedirect("CustomerIndex.jsp");
			}
		}
		
		
	}

}
