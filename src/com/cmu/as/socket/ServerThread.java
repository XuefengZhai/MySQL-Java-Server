package com.cmu.as.socket;


import com.cmu.as.entities.appointment.Appointment;
import com.cmu.as.entities.appointment.AppointmentInterface;
import com.cmu.as.entities.department.Department;
import com.cmu.as.entities.department.DepartmentInterface;
import com.cmu.as.entities.doctor.Doctor;
import com.cmu.as.entities.doctor.DoctorInterface;
import com.cmu.as.entities.hospital.Hospital;
import com.cmu.as.entities.hospital.HospitalInterface;
import com.cmu.as.entities.patient.*;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by SafenZhai on 4/19/14.
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInput in;
    private Object inObject;

    @SuppressWarnings("unchecked")
	public void run() {

        try {
            serverSocket = new ServerSocket(8888);
            clientSocket = serverSocket.accept();
            System.out.println("New Connection!");

            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            int key = -1;
            ArrayList<String> value = null;
            
            while((inObject = in.readObject())!= null){
            	Map<Integer,ArrayList<String>> m = new HashMap<Integer,ArrayList<String>>();
            	m = (Map<Integer, ArrayList<String>>) inObject;
            
            	for (Map.Entry<Integer, ArrayList<String>> entry : m.entrySet()) {
            		key =  entry.getKey();
            		System.out.println("Choice:"+key);
            		value = entry.getValue();
            		
            	}
            
            	switch(key){
            
            	case 1: //patient Login
            		String PatID = value.get(0);
            		System.out.println(PatID);
            		String PatPsw = value.get(1);
            		System.out.println(PatPsw);
            		PatientInterface PI = new PatientInterface();
            		Boolean result;
            		result = PI.logIn(PatID, PatPsw);
            		out.writeObject(result);
            		
            		if (result == true){
            		//send patient
            		
                    out.writeObject(PI.getPatient(PatID));
                    System.out.println("Send patient! ");
                    
                    //send hospital within 3 miles
                    
                    Double lat = Double.parseDouble(value.get(2));
                    Double lon = Double.parseDouble(value.get(3));
                    
                    ArrayList<Hospital> hos = new ArrayList<Hospital>();
                    ArrayList<Hospital> allHos = new ArrayList<Hospital>();
                    
                    HospitalInterface HI = new HospitalInterface();
                    
                    allHos = HI.getHospitalList();
                    
                    for(Hospital p: allHos){
                    	Double hLat = Double.parseDouble(p.getHosLat());
                    	Double hLon = Double.parseDouble(p.getHosLon());
                    	
                    	double earthRadius = 3958.75;
                        double dLat = Math.toRadians(lat-hLat);
                        double dLng = Math.toRadians(lon-hLon);
                        double sindLat = Math.sin(dLat / 2);
                        double sindLng = Math.sin(dLng / 2);
                        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                                * Math.cos(Math.toRadians(hLat)) * Math.cos(Math.toRadians(lat));
                        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
                        double dist = earthRadius * c;
                        
                        p.setHosDis(Double.toString(dist));
                        
                        System.out.print("Mile"+dist);
                        
                        System.out.println("Dis"+p.getHosDis());
                        System.out.println("Name"+p.getHosName());
                        if (dist <3)
                        {
                        	hos.add(p);
                        }

                    }
                    out.writeObject(hos);
                    System.out.println("Send hospital! ");
            		}
            		
            		break;
            		
            	//send department and doctor in the hospital 	
            	case 2:
            		String qHosID = value.get(0);
            		System.out.println(qHosID);
            		DepartmentInterface DI = new DepartmentInterface();
            		ArrayList<Department> depList = new ArrayList<Department>();
            		ArrayList<String> depName = new ArrayList<String>();
            		depList = DI.getDepList(qHosID);
            		
            		for(Department dep: depList){
            			depName.add(dep.getDepName());
            		}
            		
            		out.writeObject(depName);
            		
            		
            		for(String d: depName){
            			System.out.println("DepName:"+d);
            		}
            		
            		
            		System.out.println("Send department! ");
            		
            		ArrayList<Doctor> docList = new ArrayList<Doctor>();
            		ArrayList<ArrayList<String>> depDoc = new ArrayList<ArrayList<String>>();
        			DoctorInterface DoI = new DoctorInterface();
            		for(Department dep: depList){
                		ArrayList<String> docName = new ArrayList<String>();
            			docList = DoI.getDoctorList(dep.getDepID());
            			for(Doctor d: docList){
                    		docName.add(d.getDocName());
            			}
            			depDoc.add(docName);
            		}
            		
            		for(ArrayList<String> a: depDoc){
            			for(String s: a){
            				System.out.println("DocName:"+s);
            			}
            		}
            		
            		
            		out.writeObject(depDoc);
            		System.out.println("Send department doctor! ");
            		break;
            	
            	//send selected doctor 	
            	case 3:
            		String DocName = value.get(0);
            		System.out.println(DocName);
            		Doctor d = new Doctor();
            		DoctorInterface DocI = new DoctorInterface();
            		d = DocI.getDoctorByName(DocName);
            		
            		out.writeObject(d);
            		System.out.println("DocID:"+d.getDocID());
            		System.out.println("send Doctor!!!");
            		break;
            	
            	//send available appointment
            	case 4:
            		String DID = value.get(0);
            		System.out.println("DoctorID:"+DID);
            		ArrayList<Appointment> appList = new ArrayList<Appointment>();
            		AppointmentInterface AI = new AppointmentInterface();
            		appList = AI.getAppListByDoc(DID);
            		
            		for(Appointment a: appList){
            			System.out.println("App"+a.getAppID());
            		}
            		
            		out.writeObject(appList);
            		break;
            	
            	//update appointment mark unavailable and set patID
            	case 5:
            		String AppID = value.get(0);
            		String PatID2 = value.get(1); 
            		System.out.println("AppID"+AppID);
            		System.out.println("PatID"+PatID2);
            		AppointmentInterface AI4 = new AppointmentInterface();
            		AI4.updateAppMarkUnA(AppID, PatID2);
            		
            		String success = "1";
            		out.writeObject(success);
            		
            		break;
            	
            	//send past appointment
            	case 6:
            		String PID = value.get(0);
            		System.out.println("PatientID:"+PID);
            		ArrayList<Appointment> pastAppList = new ArrayList<Appointment>();
            		AppointmentInterface AI2 = new AppointmentInterface();
            		pastAppList = AI2.getAppListPast(PID);
            		
            		for(Appointment a: pastAppList){
            			System.out.println("App"+a.getAppID());
            		}
            		
            		out.writeObject(pastAppList);
            		break;
            	
            	//send future appointment
            	case 7:
            		String PID2 = value.get(0);
            		System.out.println("PatientID:"+PID2);
            		ArrayList<Appointment> futureAppList = new ArrayList<Appointment>();
            		AppointmentInterface AI3 = new AppointmentInterface();
            		futureAppList = AI3.getAppListFuture(PID2);
            		
            		for(Appointment a: futureAppList){
            			System.out.println("App"+a.getAppID());
            		}

            		out.writeObject(futureAppList);
            		break;
            	
            	//cancel appointment
            	case 8:
            		String PatID3 = value.get(0);
            		String AppID2 = value.get(1);
            		System.out.println("AppID2:"+AppID2);
            		AppointmentInterface AI5 = new AppointmentInterface();
            		AI5.cancelApp(AppID2, PatID3);
            		
            		String success2 = "1";
            		out.writeObject(success2);
            		
            		break;
                 	}
            }

            out.close();

            serverSocket.close();

            clientSocket.close();

            out.close();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
