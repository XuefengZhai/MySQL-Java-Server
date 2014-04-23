package com.cmu.as.entities.department;

import java.io.Serializable;

public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String DepID;
	String HosID;
	String DepName;
	/**
	 * @return the depID
	 */
	public String getDepID() {
		return DepID;
	}
	/**
	 * @return the hosID
	 */
	public String getHosID() {
		return HosID;
	}
	/**
	 * @return the depName
	 */
	public String getDepName() {
		return DepName;
	}
	/**
	 * @param depID the depID to set
	 */
	public void setDepID(String depID) {
		DepID = depID;
	}
	/**
	 * @param hosID the hosID to set
	 */
	public void setHosID(String hosID) {
		HosID = hosID;
	}
	/**
	 * @param depName the depName to set
	 */
	public void setDepName(String depName) {
		DepName = depName;
	}
	
	
}
