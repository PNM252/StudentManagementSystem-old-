package app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().save(student); 
	}

	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {

		return sessionFactory.getCurrentSession().createQuery("from Student")
				.list();
	}

	public void removeStudent(int studentID) {
		Student student = (Student) sessionFactory.getCurrentSession().load(
				Student.class, studentID);
		if (null != student) {
			sessionFactory.getCurrentSession().delete(student);
		}

	}

	public void editStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
	}

	public Student getStudent(int studentID) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class,
				studentID);
	}

}
