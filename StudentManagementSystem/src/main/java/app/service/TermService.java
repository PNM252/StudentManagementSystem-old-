package app.service;

import java.util.List;

import app.domain.Term;

public interface TermService {

	public void addTerm(Term term);

	public List<Term> listTerm();

	public void removeTerm(int termID);

	public void editTerm(Term term);

	public Term getTerm(int termID);

}
