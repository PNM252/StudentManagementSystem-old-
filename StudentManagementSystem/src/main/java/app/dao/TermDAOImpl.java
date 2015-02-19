package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Term;

@Repository
public class TermDAOImpl implements TermDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTerm(Term term) {
		sessionFactory.getCurrentSession().save(term);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Term> listTerm() {
		return sessionFactory.getCurrentSession().createQuery("from Term")
				.list();
	}

	@Override
	public void editTerm(Term term) {
		sessionFactory.getCurrentSession().update(term);
	}

	@Override
	public void removeTerm(Integer termID) {
		Term term = (Term) sessionFactory.getCurrentSession().load(Term.class,
				termID);
		if (null != term) {
			sessionFactory.getCurrentSession().delete(term);

		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Term getTermById(Integer termID) {
		Session session = sessionFactory.getCurrentSession();
		List<Term> list = session
				.createQuery("from Term t where t.termID = :termID")
				.setParameter("termID", termID).list();
		return list.size() > 0 ? (Term) list.get(0) : null;
	}

}
