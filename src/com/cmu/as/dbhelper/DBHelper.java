package com.cmu.as.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by SafenZhai on 4/13/14.
 */
public final class DBHelper  {
	
    public static Connection getConnection() { 
        Connection conn = null; 
        
        try { 
            String driver = "com.mysql.jdbc.Driver"; // Database Drive
            String url = "jdbc:mysql://localhost:3306/dataserver";// Database
            String user = "root"; // UserName
            String password = "111111"; // Password
            Class.forName(driver); // Load Database
            if (null == conn) { 
                conn = DriverManager.getConnection(url, user, password); 
            } 
        } catch (ClassNotFoundException e) { 
            System.out.println("Sorry,can't find the Driver!"); 
            e.printStackTrace(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return conn; 
    } 
    
    public void init(){
        Connection conn = null; 
        Statement stmt = null; 
        
        
        try { 
            conn = getConnection(); 
            stmt = conn.createStatement(); 
            
            
            stmt.execute("DROP TABLE IF EXISTS appointment");
            stmt.execute("DROP TABLE IF EXISTS department");
            stmt.execute("DROP TABLE IF EXISTS doctor");
            stmt.execute("DROP TABLE IF EXISTS hospital");
            stmt.execute("DROP TABLE IF EXISTS patient");
            
            
            stmt.execute("CREATE TABLE hospital (HosID VARCHAR(50) PRIMARY KEY, HosName VARCHAR(20), " +
                    "HosAdd VARCHAR(100), HosLon VARCHAR(100), HosLat VARCHAR(100),HosDis VARCHAR(100), HosPhone VARCHAR(10))");
            stmt.execute("CREATE TABLE department (DepID VARCHAR(50) PRIMARY KEY, HosID VARCHAR(50), " +
                    "DepName VARCHAR(50))");
            stmt.execute("CREATE TABLE doctor (DocID VARCHAR(50) PRIMARY KEY, DocPsw VARCHAR(10), DepID VARCHAR(50), " +
                    "DocName VARCHAR(50), DocPhone VARCHAR(10), DocSpeciality VARCHAR(20))");
            stmt.execute("CREATE TABLE patient (PatID VARCHAR(50) PRIMARY KEY, PatPsw VARCHAR(10), " +
                    "PatName VARCHAR(50), PatAge VARCHAR(3), PatGender VARCHAR(10), PatInsurance VARCHAR(10))");
           stmt.execute("CREATE TABLE appointment (AppID VARCHAR(50) PRIMARY KEY, DocID VARCHAR(50), PatID VARCHAR(50), " +
                    "AppDate VARCHAR(20), AppTime VARCHAR(20), AppAvailability VARCHAR(10), AppCheckIn VARCHAR(10), HosName VARCHAR(20), DocName VARCHAR(50))");


            
        } catch (SQLException err) { 
            err.printStackTrace(); 
        } 

    	
    	
    }
    
    public synchronized void insert(Map<String, String> values, String table){
    	
        Connection conn = null; 
        Statement stmt = null; 

    	
    	StringBuilder sql = new StringBuilder("INSERT INTO ").append(table).append(" (");
    	StringBuilder placeholders = new StringBuilder();

    	for (@SuppressWarnings("rawtypes")
		Iterator it = values.entrySet().iterator(); it.hasNext();) {
    		@SuppressWarnings("rawtypes")
			Map.Entry pairs = (Map.Entry)it.next();
    		sql.append(pairs.getKey());
    	    placeholders.append("\""+pairs.getValue()+"\"");
    		it.remove();


    	    if (it.hasNext()) {
    	        sql.append(",");
    	        placeholders.append(",");
    	    }
    	}

    	sql.append(") VALUES (").append(placeholders).append(")");
    	
    	System.out.print(sql+"\n");
    	
        try { 
            conn = getConnection(); 
            stmt = conn.createStatement(); 
            stmt.execute(sql.toString());
        } catch (SQLException err) { 
            err.printStackTrace(); 
        } 
    	
    }
    
    public synchronized void delete(String table, String whereClause, String whereValue){
        Connection conn = null; 
        Statement stmt = null; 
        
        try { 
            conn = getConnection(); 
            stmt = conn.createStatement(); 
            stmt.execute("DELETE FROM "+table+" WHERE "+whereClause+"= \""+whereValue+"\"");
        } catch (SQLException err) { 
            err.printStackTrace(); 
        } 
        
        
        
    }
    
    public synchronized void update(Map<String, String> values, String table, String whereClause, String whereArgs){
        
    	Connection conn = null; 
        Statement stmt = null; 

    	
    	StringBuilder sql = new StringBuilder("UPDATE ").append(table).append(" SET ");

    	for (@SuppressWarnings("rawtypes")
		Iterator it = values.entrySet().iterator(); it.hasNext();) {
    		@SuppressWarnings("rawtypes")
			Map.Entry pairs = (Map.Entry)it.next();
    	    sql.append(pairs.getKey()+"=\""+pairs.getValue()+"\"");

    	    if (it.hasNext()) {
    	        sql.append(",");
    	    }
    	}

    	sql.append(" WHERE "+whereClause+"=\""+whereArgs+"\"");
    	
        try { 
            conn = getConnection(); 
            stmt = conn.createStatement(); 
            stmt.execute(sql.toString());
        } catch (SQLException err) { 
            err.printStackTrace(); 
        } 
        
    	System.out.print(sql);

    }

    public synchronized ResultSet query(String table) throws SQLException{

    	Connection conn = null; 
        Statement stmt = null; 
        String sql = "select * from "+table;
        ResultSet rs;



        conn = getConnection(); 
        stmt = conn.createStatement(); 
        rs = stmt.executeQuery(sql.toString());
    	System.out.print(sql+"\n");

        
        return rs;
        

    }
    
    public synchronized ResultSet generalQuery(String sql) throws SQLException{
    	Connection conn = null; 
        Statement stmt = null; 
        ResultSet rs;



        conn = getConnection(); 
        stmt = conn.createStatement(); 
        rs = stmt.executeQuery(sql);
    	System.out.print(sql+"\n");

        
        return rs;
    }
    
    public synchronized Boolean isExist(String sql) throws SQLException{
    	Connection conn = null; 
        Statement stmt = null; 
    	ResultSet rs = null; 
    	
    	
    	System.out.println(sql);
        conn = getConnection(); 
        stmt = conn.createStatement(); 

        rs = stmt.executeQuery(sql); 
        rs.last(); 
        int count = rs.getRow(); 
        if (count > 0) { 
            return true; 
        } else { 
            return false; 
        } 

    }

}
