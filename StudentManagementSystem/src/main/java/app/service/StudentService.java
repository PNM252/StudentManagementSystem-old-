package app.service;

import java.util.List;

import app.domain.Student;

public interface StudentService {

	public void addStudent(Student student);

	public List<Student> listStudent();

	public void removeStudent(int studentID);
	
	public void editStudent(Student student);
	
	public Student getStudent(int studentID);
}
