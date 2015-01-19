package app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DISCIPLINE")
public class Discipline {

	@Id
	@Column(name = "DISCIPLINE_ID")
	@GeneratedValue
	private Integer disciplineID;

	@Column(name = "DISCIPLINENAME")
	private String disciplinename;

	@ManyToMany(mappedBy = "disciplines")
	private List<Term> terms = new ArrayList<Term>();

	public Integer getDisciplineID() {
		return disciplineID;
	}

	public void setDisciplineID(Integer disciplineID) {
		this.disciplineID = disciplineID;
	}

	public String getDisciplinename() {
		return disciplinename;
	}

	public void setDisciplinename(String disciplinename) {
		this.disciplinename = disciplinename;
	}

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

}
