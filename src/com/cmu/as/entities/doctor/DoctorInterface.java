package com.cmu.as.entities.doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cmu.as.dbhelper.DBHelper;

public class DoctorInterface {

    DBHelper dbHelper;

    public void insertDoctor(Doctor d) {

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("DocID", d.getDocID());
        values.put("DepID", d.getDepID());
        values.put("DocName",d.getDocName());
        values.put("DocPhone", d.getDocPhone());
        values.put("DocSpeciality", d.getDocSpeciality());
        values.put("DocPsw",d.getDocPsw());

        dbHelper.insert(values,"doctor");

    }
    
    public void deleteDoctor(String DocID){

        dbHelper = new DBHelper();
        dbHelper.delete("doctor","DocID", DocID);
    }



    public void updateDoctor(Doctor d){

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("DocID", d.getDocID());
        values.put("DepID", d.getDepID());
        values.put("DocName",d.getDocName());
        values.put("DocPhone", d.getDocPhone());
        values.put("DocSpeciality", d.getDocSpeciality());
        values.put("DocPsw",d.getDocPsw());
        
        dbHelper.update(values,"doctor","DocID", d.getDocID());

    }
    
    public ArrayList<Doctor> getDoctorList(String qDepID) throws SQLException {
        dbHelper = new DBHelper();

        ArrayList<Doctor> doctorList = new ArrayList<Doctor>();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM doctor WHERE DepID=\""+qDepID+"\"");
        while (rs.next()){
            
        	String DocID = rs.getString("DocID");
            String DepID = rs.getString("DepID");
            String DocName = rs.getString("DocName");
            String DocPhone = rs.getString("DocPhone");
            String DocSpeciality = rs.getString("DocSpeciality");

            Doctor d = new Doctor();
            
            d.setDocID(DocID);
            d.setDepID(DepID);
            d.setDocName(DocName);
            d.setDocName(DocName);
            d.setDocPhone(DocPhone);
            d.setDocSpeciality(DocSpeciality);
            
            
            doctorList.add(d);
        }

        return doctorList;

    }
    
    public Doctor getDoctor(String DID)throws SQLException{
        dbHelper = new DBHelper();

        Doctor d = new Doctor();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM doctor WHERE DocID=\""+DID+"\"");
        while (rs.next()){
            
        	String DocID = rs.getString("DocID");
            String DepID = rs.getString("DepID");
            String DocName = rs.getString("DocName");
            String DocPhone = rs.getString("DocPhone");
            String DocSpeciality = rs.getString("DocSpeciality");

            
            d.setDocID(DocID);
            d.setDepID(DepID);
            d.setDocName(DocName);
            d.setDocName(DocName);
            d.setDocPhone(DocPhone);
            d.setDocSpeciality(DocSpeciality);

        }

        return d;

    }
    
    public Doctor getDoctorByName(String DName)throws SQLException{
        dbHelper = new DBHelper();

        Doctor d = new Doctor();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM doctor WHERE DocName=\""+DName+"\"");
        while (rs.next()){
            
        	String DocID = rs.getString("DocID");
            String DepID = rs.getString("DepID");
            String DocName = rs.getString("DocName");
            String DocPhone = rs.getString("DocPhone");
            String DocSpeciality = rs.getString("DocSpeciality");

            
            d.setDocID(DocID);
            d.setDepID(DepID);
            d.setDocName(DocName);
            d.setDocName(DocName);
            d.setDocPhone(DocPhone);
            d.setDocSpeciality(DocSpeciality);

        }

        return d;

    }
    
    
    public Boolean logIn(String DocID, String DocPsw) throws SQLException {
    	
        dbHelper = new DBHelper();
    	Boolean result;
    	
    	result = dbHelper.isExist("SELECT * FROM doctor WHERE DocID=\""+DocID+"\" AND DocPsw =\""+DocPsw+"\"");
    	
    	//System.out.println("result is:"+result);
    	
    	return result;
    
    }


}
