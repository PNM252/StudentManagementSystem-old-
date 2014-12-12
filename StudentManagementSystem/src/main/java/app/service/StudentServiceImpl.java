package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.StudentDAO;
import app.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Transactional
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Transactional
	public List<Student> listStudent() {
		
		return studentDAO.listStudent();
	}

	@Transactional
	public void removeStudent(int id) {
		studentDAO.removeStudent(id);
	}

	@Transactional
	public void editStudent(Student student) {
		studentDAO.editStudent(student);
	}

	@Transactional
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

}
