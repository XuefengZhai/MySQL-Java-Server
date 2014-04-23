package com.cmu.as.entities.patient;


import com.cmu.as.dbhelper.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PatientInterface {

    DBHelper dbHelper;
    
    //Insert one Patient
    public void insertPatient(Patient p) {

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("PatID", p.getPatID());
        values.put("PatPsw", p.getPatPsw());
        values.put("PatName", p.getPatName());
        values.put("PatAge",p.getPatAge());
        values.put("PatGender", p.getPatGender());
        values.put("PatInsurance", p.getPatInsurance());

        dbHelper.insert(values,"patient");

    }
    
    //Delete one Patient
    public void deletePatient(String PatID){

        dbHelper = new DBHelper();
        dbHelper.delete("patient","PatID", PatID);
    }

    //Update one Patient
    public void updatePatient(Patient p){

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("PatID", p.getPatID());
        values.put("PatPsw", p.getPatPsw());
        values.put("PatName", p.getPatName());
        values.put("PatAge",p.getPatAge());
        values.put("PatGender", p.getPatGender());
        values.put("PatInsurance", p.getPatInsurance());

        dbHelper.update(values,"patient","PatID", p.getPatID());

    }
    
    //Get List of all Patient
    public ArrayList<Patient> getPatientList() throws SQLException {
        dbHelper = new DBHelper();

        ArrayList<Patient> patientList = new ArrayList<Patient>();



        ResultSet rs = dbHelper.query("patient");
        while (rs.next()){
            String PatID = rs.getString("PatID");

            //String PatPsw = c.getString(c.getColumnIndex("PatPsw"));
            String PatName = rs.getString("PatName");
            String PatAge = rs.getString("PatAge");

            String PatGender = rs.getString("PatGender");
            String PatInsurance = rs.getString("PatInsurance");

            Patient p = new Patient();

            p.setPatID(PatID);
            //p.setPatPsw(PatPsw);
            p.setPatName(PatName);
            p.setPatAge(PatAge);
            p.setPatGender(PatGender);
            p.setPatInsurance(PatInsurance);

            patientList.add(p);
        }

        return patientList;

    }
    
    //Get 1 Patient by Patient ID
    public Patient getPatient(String PID) throws SQLException {
    	
    	dbHelper = new DBHelper();
    	
    	Patient p = new Patient();
    	
    	ResultSet rs = dbHelper.generalQuery("SELECT * FROM patient WHERE PatID=\""+PID+"\"");
       
    	while (rs.next()){
            String PatID = rs.getString("PatID");
            String PatPsw = rs.getString("PatPsw");
            String PatName = rs.getString("PatName");
            String PatAge = rs.getString("PatAge");
            String PatGender = rs.getString("PatGender");
            String PatInsurance = rs.getString("PatInsurance");

            p.setPatID(PatID);
            p.setPatPsw(PatPsw);
            p.setPatName(PatName);
            p.setPatAge(PatAge);
            p.setPatGender(PatGender);
            p.setPatInsurance(PatInsurance);
        }
    	
    	
    	return p;
    	
    }
    
    //Return true if exist
     public Boolean logIn(String PatID, String PatPsw) throws SQLException {
    	
        dbHelper = new DBHelper();
    	Boolean result;
    	
    	result = dbHelper.isExist("SELECT * FROM patient WHERE PatID=\""+PatID+"\" AND PatPsw =\""+PatPsw+"\"");
    	
    
    	return result;
    
    }


}









