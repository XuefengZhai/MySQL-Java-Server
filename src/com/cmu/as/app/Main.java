package com.cmu.as.app;

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
		p.setPatName("David");
		p.setPatGender("Male");
		p.setPatID("641");
		p.setPatInsurance("123455");
		p.setPatPsw("test");
		PI.insertPatient(p);
		
		p.setPatAge("99");
		p.setPatName("David1");
		p.setPatGender("Male2");
		p.setPatID("123435");
		p.setPatInsurance("9999199");
		p.setPatPsw("No");
		PI.insertPatient(p);
				
		Hospital h = new Hospital();
		HospitalInterface HI = new HospitalInterface();
		
		h.setHosID("11");
		h.setHosName("ChooseMe");
		h.setHosAdd("asdf");
		h.setHosDis("-1");
		h.setHosPhone("222333");
		h.setHosLat("38");
		h.setHosLon("77");
		HI.insertHospital(h);
		
		h.setHosID("22");
		h.setHosName("PPMM");
		h.setHosAdd("asdf");
		h.setHosDis("-1");
		h.setHosPhone("222333");
		h.setHosLat("38");
		h.setHosLon("77");
		HI.insertHospital(h);
		
		h.setHosID("33");
		h.setHosName("QQRR");
		h.setHosAdd("pptt");
		h.setHosDis("-1");
		h.setHosPhone("222333");
		h.setHosLat("22");
		h.setHosLon("33");
		HI.insertHospital(h);
		
		Department d = new Department();
		DepartmentInterface DI = new DepartmentInterface();
		
		d.setDepID("11");
		d.setHosID("11");
		d.setDepName("ChooseMe");
		DI.insertDep(d);
		
		d.setDepID("22");
		d.setHosID("11");
		d.setDepName("Outer");
		DI.insertDep(d);
		
		Doctor doc = new Doctor();
		DoctorInterface DocI = new DoctorInterface();
		
		doc.setDocID("11");
		doc.setDepID("11");
		doc.setDocName("ChooseMe");
		doc.setDocPhone("123456");
		doc.setDocPsw("test");
		doc.setDocSpeciality("Eye");
		DocI.insertDoctor(doc);
		
		doc.setDocID("22");
		doc.setDepID("11");
		doc.setDocName("Hello");
		doc.setDocPhone("123456");
		doc.setDocPsw("test");
		doc.setDocSpeciality("HeartDiease");
		DocI.insertDoctor(doc);
		
		Appointment app = new Appointment();
		AppointmentInterface AI = new AppointmentInterface();
		
		app.setAppID("11");
		app.setDocID("11");
		app.setPatID("");
		app.setAppDate("May-1-2014");
		app.setAppTime("03:30pm");
		app.setAppAvailability("1");
		app.setAppCheckIn("");
		app.setHosName("UPMM");
		app.setDocName("David");
		AI.insertApp(app);
		
		app.setAppID("22");
		app.setDocID("11");
		app.setPatID("");
		app.setAppDate("May-2-2014");
		app.setAppTime("04:30pm");
		app.setAppAvailability("1");
		app.setAppCheckIn("");
		app.setHosName("UPMM");
		app.setDocName("David");
		AI.insertApp(app);
		
		app.setAppID("33");
		app.setDocID("11");
		app.setPatID("641");
		app.setAppDate("Apr-2-2013");
		app.setAppTime("03:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("1");
		app.setHosName("UPMM");
		app.setDocName("David");
		AI.insertApp(app);
		
		app.setAppID("55");
		app.setDocID("11");
		app.setPatID("641");
		app.setAppDate("Apr-3-2013");
		app.setAppTime("04:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("1");
		app.setHosName("UPMM");
		app.setDocName("David");
		AI.insertApp(app);
		
		app.setAppID("44");
		app.setDocID("11");
		app.setPatID("641");
		app.setAppDate("May-1-2014");
		app.setAppTime("03:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("0");
		app.setHosName("UPMM");
		app.setDocName("David");
		AI.insertApp(app);
		
		app.setAppID("66");
		app.setDocID("11");
		app.setPatID("641");
		app.setAppDate("May-2-2014");
		app.setAppTime("04:30pm");
		app.setAppAvailability("0");
		app.setAppCheckIn("0");
		app.setHosName("UPMM");
		app.setDocName("David");
		AI.insertApp(app);
		
	
		ServerThread thread = new ServerThread();
		thread.start();
		
	}

}
