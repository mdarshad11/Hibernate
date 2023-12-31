package com.jsp.CRUD_Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int sId;
	private String sName;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + "]";
	}

}
