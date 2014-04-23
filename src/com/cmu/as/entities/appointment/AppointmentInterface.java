package com.cmu.as.entities.appointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cmu.as.dbhelper.DBHelper;

public class AppointmentInterface {
    
	DBHelper dbHelper;

    public void insertApp(Appointment a) {

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("AppID", a.getAppID());
        values.put("DocID", a.getDocID());
        values.put("PatID",a.getPatID());
        values.put("AppTime", a.getAppTime());
        values.put("AppDate", a.getAppDate());
        values.put("AppAvailability",a.getAppAvailability());
        values.put("AppCheckIn", a.getAppCheckIn());
        values.put("HosName",a.getHosName());
        values.put("DocName", a.getDocName());

        dbHelper.insert(values,"appointment");

    }
    //Mark appointment unavailable
    public void updateAppMarkUnA(String AppID, String PatID){

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("PatID",PatID);
        values.put("AppAvailability","0");
        values.put("AppCheckIn", "0");
        

        dbHelper.update(values,"appointment","AppID", AppID);

    }
    
    
    public void cancelApp(String AppID, String PatID){

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("PatID","");
        values.put("AppAvailability","1");
        values.put("AppCheckIn", "0");
        

        dbHelper.update(values,"appointment","AppID", AppID);

    }

    
    public void deleteApp(String AppID){

        dbHelper = new DBHelper();
        dbHelper.delete("appointment","AppID", AppID);
    }


    public ArrayList<Appointment> getAppListByDoc(String DID) throws SQLException {
        dbHelper = new DBHelper();

        ArrayList<Appointment> appList = new ArrayList<Appointment>();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM appointment WHERE DocID =\""+DID+"\" AND AppAvailability=1");
        while (rs.next()){
            
        	String AppID = rs.getString("AppID");
            String DocID = rs.getString("DocID");
            String PatID = rs.getString("PatID");
            String AppTime = rs.getString("AppTime");
            String AppDate = rs.getString("AppDate");
            String AppAvailability = rs.getString("AppAvailability");
            String AppCheckIn = rs.getString("AppCheckIn");
            String HosName = rs.getString("HosName");
            String DocName = rs.getString("DocName");

            Appointment a = new Appointment();
            
            a.setAppID(AppID);
            a.setDocID(DocID);
            a.setPatID(PatID);
            a.setAppTime(AppTime);
            a.setAppDate(AppDate);
            a.setAppAvailability(AppAvailability);
            a.setAppCheckIn(AppCheckIn);
            a.setHosName(HosName);
            a.setDocName(DocName);
            
            appList.add(a);
            
        }

        return appList;

    }
    
    
    public ArrayList<Appointment> getAppListPast(String PID) throws SQLException {
        dbHelper = new DBHelper();

        ArrayList<Appointment> appList = new ArrayList<Appointment>();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM appointment WHERE PatID =\""+PID+"\" AND AppCheckIn=1");
        while (rs.next()){
            
        	String AppID = rs.getString("AppID");
            String DocID = rs.getString("DocID");
            String PatID = rs.getString("PatID");
            String AppTime = rs.getString("AppTime");
            String AppDate = rs.getString("AppDate");
            String AppAvailability = rs.getString("AppAvailability");
            String AppCheckIn = rs.getString("AppCheckIn");
            String HosName = rs.getString("HosName");
            String DocName = rs.getString("DocName");

            Appointment a = new Appointment();
            
            a.setAppID(AppID);
            a.setDocID(DocID);
            a.setPatID(PatID);
            a.setAppTime(AppTime);
            a.setAppDate(AppDate);
            a.setAppAvailability(AppAvailability);
            a.setAppCheckIn(AppCheckIn);
            a.setHosName(HosName);
            a.setDocName(DocName);

            
            appList.add(a);
            
        }

        return appList;

    }
    
    public ArrayList<Appointment> getAppListFuture(String PID) throws SQLException {
        dbHelper = new DBHelper();

        ArrayList<Appointment> appList = new ArrayList<Appointment>();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM appointment WHERE PatID =\""+PID+"\" AND AppCheckIn=0");
        while (rs.next()){
            
        	String AppID = rs.getString("AppID");
            String DocID = rs.getString("DocID");
            String PatID = rs.getString("PatID");
            String AppTime = rs.getString("AppTime");
            String AppDate = rs.getString("AppDate");
            String AppAvailability = rs.getString("AppAvailability");
            String AppCheckIn = rs.getString("AppCheckIn");
            String HosName = rs.getString("HosName");
            String DocName = rs.getString("DocName");

            Appointment a = new Appointment();
            
            a.setAppID(AppID);
            a.setDocID(DocID);
            a.setPatID(PatID);
            a.setAppTime(AppTime);
            a.setAppDate(AppDate);
            a.setAppAvailability(AppAvailability);
            a.setAppCheckIn(AppCheckIn);
            a.setHosName(HosName);
            a.setDocName(DocName);
            
            appList.add(a);
            
        }

        return appList;

    }
    
    
}
