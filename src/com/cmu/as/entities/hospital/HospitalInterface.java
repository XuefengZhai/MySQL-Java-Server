package com.cmu.as.entities.hospital;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cmu.as.dbhelper.DBHelper;
import com.cmu.as.entities.department.Department;

public class HospitalInterface {

    DBHelper dbHelper;

    public void insertHospital(Hospital h) {

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("HosID", h.getHosID());
        values.put("HosName", h.getHosName());
        values.put("HosLat", h.getHosLat());
        values.put("HosLon", h.getHosLon());
        values.put("HosAdd",h.getHosAdd());
        values.put("HosPhone", h.getHosPhone());
        values.put("HosDis", h.getHosDis());

        dbHelper.insert(values,"hospital");

    }
    
    public void deleteHospital(String HosID){

        dbHelper = new DBHelper();
        dbHelper.delete("hospital","HosID", HosID);
    }



    public void updateHospital(Hospital h){

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("HosID", h.getHosID());
        values.put("HosName", h.getHosName());
        values.put("HosLat", h.getHosLat());
        values.put("HosLon", h.getHosLon());
        values.put("HosAdd",h.getHosAdd());
        values.put("HosPhone", h.getHosPhone());
        values.put("HosDis", h.getHosDis());

        dbHelper.update(values,"hospital","HosID", h.getHosID());

    }
    
    public ArrayList<Hospital> getHospitalList() throws SQLException {
        dbHelper = new DBHelper();

        ArrayList<Hospital> hosList = new ArrayList<Hospital>();



        ResultSet rs = dbHelper.query("hospital");
        while (rs.next()){
            String HosID = rs.getString("HosID");
            String HosName = rs.getString("HosName");
            String HosLat = rs.getString("HosLat");
            String HosLon = rs.getString("HosLon");
            String HosAdd = rs.getString("HosAdd");
            String HosPhone = rs.getString("HosPhone");
            String HosDis = rs.getString("HosDis");

            Hospital h = new Hospital();

            h.setHosID(HosID);
            h.setHosName(HosName);
            h.setHosLon(HosLon);
            h.setHosLat(HosLat);
            h.setHosPhone(HosPhone);
            h.setHosAdd(HosAdd);
            h.setHosDis(HosDis);
            
            hosList.add(h);
        }

        return hosList;

    }
    
    
    public Hospital getHotByID(String HosID)throws SQLException{
        dbHelper = new DBHelper();

        Hospital h = new Hospital();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM hospital WHERE HosID=\""+HosID+"\"");
        while (rs.next()){
            
            String HosID2 = rs.getString("HosID");
            String HosName = rs.getString("HosName");
            String HosLat = rs.getString("HosLat");
            String HosLon = rs.getString("HosLon");
            String HosAdd = rs.getString("HosAdd");
            String HosPhone = rs.getString("HosPhone");
            String HosDis = rs.getString("HosDis");

            
            h.setHosID(HosID2);
            h.setHosName(HosName);
            h.setHosLon(HosLon);
            h.setHosLat(HosLat);
            h.setHosPhone(HosPhone);
            h.setHosAdd(HosAdd);
            h.setHosDis(HosDis);

        }

        return h;

    }


}
