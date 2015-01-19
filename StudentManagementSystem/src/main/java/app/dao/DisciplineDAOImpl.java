package app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Discipline;

@Repository
public class DisciplineDAOImpl implements DisciplineDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addDiscipline(Discipline discipline) {
		sessionFactory.getCurrentSession().save(discipline);
	}

	@SuppressWarnings("unchecked")
	public List<Discipline> listDiscipline() {

		return sessionFactory.getCurrentSession()
				.createQuery("from Discipline").list();
	}

	public void removeDiscipline(int disciplineID) {
		Discipline discipline = (Discipline) sessionFactory.getCurrentSession()
				.load(Discipline.class, disciplineID);
		if (null != discipline) {
			sessionFactory.getCurrentSession().delete(discipline);
		}
	}

	public void editDiscipline(Discipline discipline) {
		sessionFactory.getCurrentSession().update(discipline);
	}

	@Override
	public Discipline getDiscipline(int disciplineID) {

		return (Discipline) sessionFactory.getCurrentSession().get(
				Discipline.class, disciplineID);
	}

}
