package com.cmu.as.entities.department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cmu.as.dbhelper.DBHelper;
import com.cmu.as.entities.doctor.Doctor;

public class DepartmentInterface {

	DBHelper dbHelper;

    public void insertDep(Department d) {

        dbHelper = new DBHelper();

        Map<String, String> values = new HashMap<String,String>();
        values.put("DepID", d.getDepID());
        values.put("HosID", d.getHosID());
        values.put("DepName",d.getDepName());

        dbHelper.insert(values,"department");

    }
    
    public void deleteDep(String DepID){

        dbHelper = new DBHelper();
        dbHelper.delete("department","DepID", DepID);
    }


    public ArrayList<Department> getDepList(String qHosID) throws SQLException {
        dbHelper = new DBHelper();

        ArrayList<Department> depList = new ArrayList<Department>();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM department WHERE HosID=\""+qHosID+"\"");
        while (rs.next()){
            
        	String DepID = rs.getString("DepID");
            String HosID = rs.getString("HosID");
            String DepName = rs.getString("DepName");

            Department d = new Department();
            
            d.setDepID(DepID);
            d.setHosID(HosID);
            d.setDepName(DepName);
            
            depList.add(d);
            
        }

        return depList;

    }
    
    
    
    public Department getDeptByID(String DepID)throws SQLException{
        dbHelper = new DBHelper();

        Department d = new Department();



        ResultSet rs = dbHelper.generalQuery("SELECT * FROM department WHERE DepID=\""+DepID+"\"");
        while (rs.next()){
            
            String DepID2 = rs.getString("DepID");
            String DepName = rs.getString("DepName");
            String HosID = rs.getString("HosID");

            
            d.setDepID(DepID2);
            d.setDepName(DepName);
            d.setHosID(HosID);

        }

        return d;

    }

    

}
