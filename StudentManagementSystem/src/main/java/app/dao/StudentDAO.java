package app.dao;

import java.util.List;

import app.domain.Student;

public interface StudentDAO {

	public void addStudent(Student student);

	public List<Student> listStudent();
	
	public void editStudent(Student student);

	public void removeStudent(int studentID);
	
	public Student getStudent(int studentID);
}