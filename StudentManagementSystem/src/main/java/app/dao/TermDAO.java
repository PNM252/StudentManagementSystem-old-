package app.dao;

import java.util.List;

import app.domain.Term;

public interface TermDAO {

	public void addTerm(Term term);
	
	public List<Term> listTerm();
	
	public void editTerm(Term term);
	
	public void removeTerm(int termID);
	
	public Term getTerm(int termID);
}
