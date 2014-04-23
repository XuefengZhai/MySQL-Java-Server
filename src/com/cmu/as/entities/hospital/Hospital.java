package com.cmu.as.entities.hospital;

import java.io.Serializable;

public class Hospital implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String HosID;
	String HosName;
	String HosAdd;
	String HosLon;
	String HosLat;
	String HosPhone;
	String HosDis;
	/**
	 * @return the hosID
	 */
	public String getHosID() {
		return HosID;
	}
	/**
	 * @return the hosName
	 */
	public String getHosName() {
		return HosName;
	}
	/**
	 * @return the hosAdd
	 */
	public String getHosAdd() {
		return HosAdd;
	}

	/**
	 * @return the hosPhone
	 */
	public String getHosPhone() {
		return HosPhone;
	}
	/**
	 * @param hosID the hosID to set
	 */
	public void setHosID(String hosID) {
		HosID = hosID;
	}
	/**
	 * @param hosName the hosName to set
	 */
	public void setHosName(String hosName) {
		HosName = hosName;
	}
	/**
	 * @param hosAdd the hosAdd to set
	 */
	public void setHosAdd(String hosAdd) {
		HosAdd = hosAdd;
	}
	/**
	 * @param hosPhone the hosPhone to set
	 */
	public void setHosPhone(String hosPhone) {
		HosPhone = hosPhone;
	}
	/**
	 * @return the hosLan
	 */
	public String getHosLon() {
		return HosLon;
	}
	/**
	 * @return the hosLot
	 */
	public String getHosLat() {
		return HosLat;
	}
	/**
	 * @param hosLan the hosLan to set
	 */
	public void setHosLon(String hosLon) {
		HosLon = hosLon;
	}
	/**
	 * @param hosLot the hosLot to set
	 */
	public void setHosLat(String hosLat) {
		HosLat = hosLat;
	}
	/**
	 * @return the hosDis
	 */
	public String getHosDis() {
		return HosDis;
	}
	/**
	 * @param hosDis the hosDis to set
	 */
	public void setHosDis(String hosDis) {
		HosDis = hosDis;
	}
	
}
