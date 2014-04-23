package com.cmu.as.entities.appointment;

import java.io.Serializable;

public class Appointment implements Serializable{

    //        db.execSQL("CREATE TABLE appointment (AppID INTEGER PRIMARY KEY, DocID INTEGER, PatID INTEGER" +
    //    "AppDate VARCHAR, AppTime VARCHAR, AppAvailability INTEGER)");

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String AppID;
    private String DocID;
    private String PatID;
    private String AppDate;
	private String AppTime;
    private String AppAvailability; //1 available
    private String AppCheckIn; //1 past
    private String HosName;
    private String DocName;

    /**
	 * @return the appID
	 */
	public String getAppID() {
		return AppID;
	}
	/**
	 * @return the docID
	 */
	public String getDocID() {
		return DocID;
	}
	/**
	 * @return the patID
	 */
	public String getPatID() {
		return PatID;
	}
	/**
	 * @return the appDate
	 */
	public String getAppDate() {
		return AppDate;
	}
	/**
	 * @return the appTime
	 */
	public String getAppTime() {
		return AppTime;
	}
	/**
	 * @param appID the appID to set
	 */
	public void setAppID(String appID) {
		AppID = appID;
	}
	/**
	 * @param docID the docID to set
	 */
	public void setDocID(String docID) {
		DocID = docID;
	}
	/**
	 * @param patID the patID to set
	 */
	public void setPatID(String patID) {
		PatID = patID;
	}
	/**
	 * @param appDate the appDate to set
	 */
	public void setAppDate(String appDate) {
		AppDate = appDate;
	}
	/**
	 * @param appTime the appTime to set
	 */
	public void setAppTime(String appTime) {
		AppTime = appTime;
	}
	public String getAppAvailability() {
		return AppAvailability;
	}
	public void setAppAvailability(String appAvailability) {
		AppAvailability = appAvailability;
	}
	public String getAppCheckIn() {
		return AppCheckIn;
	}
	public void setAppCheckIn(String appCheckIn) {
		AppCheckIn = appCheckIn;
	}
	public String getHosName() {
		return HosName;
	}
	public void setHosName(String hosName) {
		HosName = hosName;
	}
	public String getDocName() {
		return DocName;
	}
	public void setDocName(String docName) {
		DocName = docName;
	}




}
