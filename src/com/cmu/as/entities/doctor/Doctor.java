package com.cmu.as.entities.doctor;

import java.io.Serializable;

public class Doctor implements Serializable{
    //       db.execSQL("CREATE TABLE doctor (DocID INTEGER PRIMARY KEY, DepID INTEGER, " +
     //       "DocName VARCHAR, DocPhone VARCHAR, DocSpeciality VARCHAR)");


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String DocID;
    private String DepID;
    private String DocName;
    private String DocPhone;
    private String DocSpeciality;
    private String DocPsw;

    public String getDocID() {
        return DocID;
    }

    public void setDocID(String docID) {
        DocID = docID;
    }

    public String getDepID() {
        return DepID;
    }

    public void setDepID(String depID) {
        DepID = depID;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    public String getDocPhone() {
        return DocPhone;
    }

    public void setDocPhone(String docPhone) {
        DocPhone = docPhone;
    }

    public String getDocSpeciality() {
        return DocSpeciality;
    }

    public void setDocSpeciality(String docSpeciality) {
        DocSpeciality = docSpeciality;
    }

	public String getDocPsw() {
		return DocPsw;
	}

	public void setDocPsw(String docPsw) {
		DocPsw = docPsw;
	}

}