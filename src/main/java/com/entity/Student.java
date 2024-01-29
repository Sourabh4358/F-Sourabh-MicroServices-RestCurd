package com.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentDB")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	
	private String studentFirstName;
	
	private String studentMiddleName;
	
	private String studentLastName;
	
	private String studentClass;
	
	private String studentSection;
	
	private String studentBloodGroup;
	
	private String studentAddress;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long studentId, String studentFirstName, String studentMiddleName, String studentLastName,
			String studentClass, String studentSection, String studentBloodGroup, String studentAddress) {
		super();
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentMiddleName = studentMiddleName;
		this.studentLastName = studentLastName;
		this.studentClass = studentClass;
		this.studentSection = studentSection;
		this.studentBloodGroup = studentBloodGroup;
		this.studentAddress = studentAddress;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentMiddleName() {
		return studentMiddleName;
	}

	public void setStudentMiddleName(String studentMiddleName) {
		this.studentMiddleName = studentMiddleName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public String getStudentBloodGroup() {
		return studentBloodGroup;
	}

	public void setStudentBloodGroup(String studentBloodGroup) {
		this.studentBloodGroup = studentBloodGroup;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFirstName=" + studentFirstName + ", studentMiddleName="
				+ studentMiddleName + ", studentLastName=" + studentLastName + ", studentClass=" + studentClass
				+ ", studentSection=" + studentSection + ", studentBloodGroup=" + studentBloodGroup
				+ ", studentAddress=" + studentAddress + "]";
	}

			
}
