package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.TermDAO;
import app.domain.Term;

@Service
public class TermServiceImpl implements TermService {

	@Autowired
	private TermDAO termDAO;

	@Transactional
	public void addTerm(Term term) {
		termDAO.addTerm(term);
	}

	@Transactional
	public List<Term> listTerm() {

		return termDAO.listTerm();
	}

	@Transactional
	public void removeTerm(Integer termID) {
		termDAO.removeTerm(termID);
	}

	@Transactional
	public void editTerm(Term term) {
		termDAO.editTerm(term);
	}

	@Transactional
	public Term getTerm(Integer termID) {
		return termDAO.getTerm(termID);
	}

}
