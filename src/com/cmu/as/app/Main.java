package com.cmu.as.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;

import com.cmu.as.dbhelper.DBHelper;
import com.cmu.as.entities.appointment.Appointment;
import com.cmu.as.entities.appointment.AppointmentInterface;
import com.cmu.as.entities.department.Department;
import com.cmu.as.entities.department.DepartmentInterface;
import com.cmu.as.entities.doctor.Doctor;
import com.cmu.as.entities.doctor.DoctorInterface;
import com.cmu.as.entities.hospital.Hospital;
import com.cmu.as.entities.hospital.HospitalInterface;
import com.cmu.as.entities.patient.Patient;
import com.cmu.as.entities.patient.PatientInterface;
import com.cmu.as.socket.ServerThread;

public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		DBHelper dbHelper = new DBHelper();
		dbHelper.init();
		
		PatientInterface PI = new PatientInterface();	
		Patient p = new Patient();
		
		p.setPatAge("20");
		p.setPatName("DavidBeckham");
		p.setPatGender("M");
		p.setPatID("david@gmail.com");
		p.setPatInsurance("6498765434");
		p.setPatPsw("test");
		PI.insertPatient(p);
		
		p.setPatAge("22");
		p.setPatName("HarryPotter");
		p.setPatGender("F");
		p.setPatID("harry@gmail.com");
		p.setPatInsurance("99991899");
		p.setPatPsw("test");
		PI.insertPatient(p);
				
		Hospital h = new Hospital();
		HospitalInterface HI = new HospitalInterface();
		
		h.setHosID("11");
		h.setHosName("UPMC");
		h.setHosAdd("5000 Forbes, Pittsburgh, PA");
		h.setHosDis("-1");
		h.setHosPhone("412444333");
		h.setHosLat("40.44");
		h.setHosLon("-79.94");
		HI.insertHospital(h);
		
		h.setHosID("22");
		h.setHosName("UWMC");
		h.setHosAdd("5433 Ellsworth, Pittsburgh, PA");
		h.setHosDis("-1");
		h.setHosPhone("412333555");
		h.setHosLat("40.44");
		h.setHosLon("-79.94");
		HI.insertHospital(h);
		
		h.setHosID("33");
		h.setHosName("UUPC");
		h.setHosAdd("5566 Center, Pittsburgh, PA");
		h.setHosDis("-1");
		h.setHosPhone("4127778888");
		h.setHosLat("22");
		h.setHosLon("-85");
		HI.insertHospital(h);
		
		Department d = new Department();
		DepartmentInterface DI = new DepartmentInterface();
		
		d.setDepID("11");
		d.setHosID("11");
		d.setDepName("Cancer");
		DI.insertDep(d);
		
		d.setDepID("22");
		d.setHosID("11");
		d.setDepName("Dermatology");
		DI.insertDep(d);
		
		d.setDepID("33");
		d.setHosID("11");
		d.setDepName("Liver");
		DI.insertDep(d);
		
		d.setDepID("44");
		d.setHosID("22");
		d.setDepName("Cancer");
		DI.insertDep(d);
		
		d.setDepID("55");
		d.setHosID("22");
		d.setDepName("Dermatology");
		DI.insertDep(d);
		
		d.setDepID("66");
		d.setHosID("22");
		d.setDepName("Liver");
		DI.insertDep(d);

		Doctor doc = new Doctor();
		DoctorInterface DocI = new DoctorInterface();
		
		doc.setDocID("jean@gmail.com");
		doc.setDepID("11");
		doc.setDocName("JeanPollo");
		doc.setDocPhone("4125576664");
		doc.setDocPsw("test");
		doc.setDocSpeciality("BrainCancer");
		DocI.insertDoctor(doc);
		
		doc.setDocID("salv@gmail.com");
		doc.setDepID("11");
		doc.setDocName("SalvatoreFrag");
		doc.setDocPhone("4128897776");
		doc.setDocPsw("test");
		doc.setDocSpeciality("HeartCancer");
		DocI.insertDoctor(doc);
		
		doc.setDocID("zenes@gmail.com");
		doc.setDepID("11");
		doc.setDocName("BenesDippor");
		doc.setDocPhone("4536627766");
		doc.setDocPsw("test");
		doc.setDocSpeciality("MonthCancer");
		DocI.insertDoctor(doc);

		
		
		doc.setDocID("jim@gmail.com");
		doc.setDepID("22");
		doc.setDocName("JimQutter");
		doc.setDocPhone("4123376655");
		doc.setDocPsw("test");
		doc.setDocSpeciality("SkinCancer");
		DocI.insertDoctor(doc);
		
		doc.setDocID("pitt@gmail.com");
		doc.setDepID("22");
		doc.setDocName("PittBruno");
		doc.setDocPhone("4453364475");
		doc.setDocPsw("test");
		doc.setDocSpeciality("SkinBurn");
		DocI.insertDoctor(doc);
		
		doc.setDocID("kelly@gmail.com");
		doc.setDepID("22");
		doc.setDocName("KellyClars");
		doc.setDocPhone("4435564455");
		doc.setDocPsw("test");
		doc.setDocSpeciality("SkinSwell");
		DocI.insertDoctor(doc);
		
		
		doc.setDocID("mio@gmail.com");
		doc.setDepID("33");
		doc.setDocName("MioKu");
		doc.setDocPhone("6475543344");
		doc.setDocPsw("test");
		doc.setDocSpeciality("LiverCancer");
		DocI.insertDoctor(doc);
		
		
		Appointment app = new Appointment();
		AppointmentInterface AI = new AppointmentInterface();
		
		app.setAppID("11");
		app.setDocID("jean@gmail.com");
		app.setPatID("");
		app.setAppDate("May-9-2014");
		app.setAppTime("03:30pm");
		app.setAppAvailability("1");
		app.setAppCheckIn("");
		app.setHosName("UPMC");
		app.setDocName("JeanPollo");
		AI.insertApp(app);
		
		app.setAppID("22");
		app.setDocID("jean@gmail.com");
		app.setPatID("");
		app.setAppDate("May-10-2014");
		app.setAppTime("04:30pm");
		app.setAppAvailability("1");
		app.setAppCheckIn("");
		app.setHosName("UPMC");
		app.setDocName("JeanPollo");
		AI.insertApp(app);
		
		app.setAppID("33");
		app.setDocID("jean@gmail.com");
		app.setPatID("david@gmail.com");
		app.setAppDate("Apr-2-2013");
		app.setAppTime("03:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("1");
		app.setHosName("UPMC");
		app.setDocName("JeanPollo");
		AI.insertApp(app);
		
		app.setAppID("55");
		app.setDocID("pitt@gmail.com");
		app.setPatID("david@gmail.com");
		app.setAppDate("Apr-3-2013");
		app.setAppTime("04:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("1");
		app.setHosName("UPMC");
		app.setDocName("PittBruno");
		AI.insertApp(app);
		
		app.setAppID("44");
		app.setDocID("jean@gmail.com");
		app.setPatID("david@gmail.com");
		app.setAppDate("May-8-2014");
		app.setAppTime("03:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("0");
		app.setHosName("UPMC");
		app.setDocName("JeanPollo");
		AI.insertApp(app);
		
		app.setAppID("66");
		app.setDocID("pitt@gmail.com");
		app.setPatID("david@gmail.com");
		app.setAppDate("May-2-2014");
		app.setAppTime("04:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("0");
		app.setHosName("UPMC");
		app.setDocName("PittBruno");
		AI.insertApp(app);
		
		boolean listener = true;
	    try {
			ServerSocket serverSocket = new ServerSocket(8888);
			while(listener){
				
				new ServerThread(serverSocket.accept()).start();
				}
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	    
		

	}

}
