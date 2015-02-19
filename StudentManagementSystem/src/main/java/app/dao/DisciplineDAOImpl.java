package app.dao;

import java.util.List;

import org.hibernate.Session;
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

	public void removeDiscipline(Integer disciplineID) {
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
	@SuppressWarnings("unchecked")
	public Discipline getDisciplineById(Integer disciplineID) {
		Session session = sessionFactory.getCurrentSession();
		List<Discipline> list = session
				.createQuery(
						"from Discipline d where d.disciplineID = :disciplineID")
				.setParameter("disciplineID", disciplineID).list();
		return list.size() > 0 ? (Discipline) list.get(0) : null;
	}

}
