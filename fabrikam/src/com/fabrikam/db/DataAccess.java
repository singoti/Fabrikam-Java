package com.fabrikam.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.fabrikam.common.Customer;
import com.fabrikam.common.ServiceTicket;

public class DataAccess {
	
	private static DataAccess dataAccess = new DataAccess();
	
	public static DataAccess getInstance(){
		return dataAccess;
	}
	
	public DataAccess(){}
	
	public ArrayList getServiceTickets(){
		String qry = "SELECT s.ID,STATUSVALUE,ESCALATIONLEVEL,TITLE,e.FirstName + ' ' + e.LastName as name, OPENED FROM SERVICETICKETS s inner join Employees e on s.AssignedToID=e.ID";
		Dbcon db = new Dbcon();
		db.mkcon();
		ArrayList list = new ArrayList();
		ResultSet rs = db.fetch(qry);
		try{
			while (rs.next()){
				int ref = rs.getInt(1);
				int status = rs.getInt(2);
				int escalation= rs.getInt(3);
				String title = rs.getString(4);
				String name = rs.getString(5);
				Timestamp openedDate= rs.getTimestamp(6);
				ServiceTicket ticket = new ServiceTicket(
						ref,status,escalation,title,name,openedDate);
				list.add(ticket);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList getCustomers(){
		String qry = "SELECT ID,FIRSTNAME,LASTNAME,ADDRESS_STREET,ADDRESS_CITY,ADDRESS_STATE,ADDRESS_ZIP  FROM CUSTOMERS";
		Dbcon db = new Dbcon();
		db.mkcon();
		ArrayList list = new ArrayList();
		ResultSet rs = db.fetch(qry);
		try{
			while (rs.next()){
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName= rs.getString(3);
				String street = rs.getString(4);
				String city = rs.getString(5);
				String state = rs.getString(6);
				String zip = rs.getString(7);
				Customer customer = new Customer(
						id,firstName,lastName,street,city,state,zip);
				list.add(customer);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public Customer getCustomer(int id){
		String qry = "SELECT ID,FIRSTNAME,LASTNAME,ADDRESS_STREET,ADDRESS_CITY,ADDRESS_STATE,ADDRESS_ZIP  FROM CUSTOMERS " +
				"WHERE ID="+id;
		Dbcon db = new Dbcon();
		db.mkcon();
		ArrayList list = new ArrayList();
		ResultSet rs = db.fetch(qry);
		try{
			while (rs.next()){
				int idNo = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName= rs.getString(3);
				String street = rs.getString(4);
				String city = rs.getString(5);
				String state = rs.getString(6);
				String zip = rs.getString(7);
				Customer customer = new Customer(
						idNo,firstName,lastName,street,city,state,zip);
				return customer;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean saveCustomer(Customer customer){
	
		String qry = "INSERT INTO CUSTOMERS (FIRSTNAME,LASTNAME,ADDRESS_STREET,ADDRESS_CITY,ADDRESS_STATE,ADDRESS_ZIP) VALUES (?,?,?,?,?,?)";
		Dbcon db = new Dbcon();
		Connection con = db.getcon();
        boolean returnValue=false;
		try{
			PreparedStatement stmt = con.prepareStatement(qry);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setString(3, customer.getStreet());
			stmt.setString(4, customer.getCity());
			stmt.setString(5, customer.getState());
			stmt.setString(6, customer.getZip());
			stmt.execute();
			returnValue=true;
		}
		catch(Exception e){
			e.printStackTrace();
		} 
		return returnValue;
	}
	
	public boolean updateCustomer(Customer customer){
		
		String qry = "UPDATE CUSTOMERS SET FIRSTNAME=? ,LASTNAME=?,ADDRESS_STREET=?,ADDRESS_CITY=?,ADDRESS_STATE=?,ADDRESS_ZIP=? WHERE ID=?";
		Dbcon db = new Dbcon();
		Connection con = db.getcon();
        boolean returnValue=false;
		try{
			PreparedStatement stmt = con.prepareStatement(qry);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setString(3, customer.getStreet());
			stmt.setString(4, customer.getCity());
			stmt.setString(5, customer.getState());
			stmt.setString(6, customer.getZip());
			stmt.setInt(7, customer.getId());
			stmt.execute();
			returnValue=true;
		}
		catch(Exception e){
			e.printStackTrace();
		} 
		return returnValue;
	}
	
	public boolean deleteCustomer(int id){
		
		String qry = "DELETE FROM CUSTOMERS WHERE ID ="+id;
		Dbcon db = new Dbcon();
		Connection con = db.getcon();
        boolean returnValue=false;
		try{
			PreparedStatement stmt = con.prepareStatement(qry);
			stmt.execute();
			returnValue=true;
		}
		catch(Exception e){
			e.printStackTrace();
		} 
		return returnValue;
	}
	
	public static void main(String [] args){
		DataAccess access = new DataAccess();
		ArrayList<Customer> list = access.getCustomers();
		for(Customer obj:list){
			System.out.println(obj.getId());
			System.out.println(obj.getFirstName());
		}
			
		System.out.println(list.size());
	}
} 