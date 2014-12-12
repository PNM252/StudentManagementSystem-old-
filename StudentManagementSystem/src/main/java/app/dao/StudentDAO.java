package app.dao;

import java.util.List;

import app.domain.Student;

public interface StudentDAO {

	public void addStudent(Student student);

	public List<Student> listStudent();
	
	public void editStudent(Student student);

	public void removeStudent(int id);
	
	public Student getStudent(int id);
}