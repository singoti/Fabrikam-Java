package com.fabrikam.db;

import java.sql.*;




public class Dbcon
{

    Connection con;
    Statement st;
    ResultSet rs;
    int i;
    String connectionURL;
    String driver;
    public Dbcon()
    {
        con = null;
        st = null;
        rs = null;
        i = 0;
        connectionURL = PvsIniFileAccessor.getInstance().getIniInfo("db.url");
        driver = PvsIniFileAccessor.getInstance().getIniInfo("db.driver");
        try
        {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(connectionURL,PvsIniFileAccessor.getInstance().getIniInfo("db.user"), PvsIniFileAccessor.getInstance().getIniInfo("db.password"));
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void mkcon()
    {
        try
        {
           
            st = con.createStatement();
            
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public int dbupdate(String s)
    {
        try
        {
            i = st.executeUpdate(s);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
        return i;
    }

    public ResultSet fetch(String s)
    {
        try
        {
            rs = st.executeQuery(s);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
            exception.printStackTrace();
        }
        return rs;
    }
    public Connection getcon()
    {
    	return con;
    		
    }
    
    public void closeCon()
    {
        try
        {
           
            if (con!=null)
            	con.close();
            
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
    
    public static void main(String args[]){
    	Dbcon db = new Dbcon();
    }
    
    
    
}

