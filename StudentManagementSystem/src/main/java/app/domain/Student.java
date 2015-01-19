package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue
	private Integer studentID;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "STUDENTGROUP")
	private String studentgroup;

	@Column(name = "DATEOFADMISSION")
	private String dateofadmission;

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStudentgroup() {
		return studentgroup;
	}

	public void setStudentgroup(String studentgroup) {
		this.studentgroup = studentgroup;
	}

	public String getDateofadmission() {
		return dateofadmission;
	}

	public void setDateofadmission(String dateofadmission) {
		this.dateofadmission = dateofadmission;
	}

	// Getters and setters

}