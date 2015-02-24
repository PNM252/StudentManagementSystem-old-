package app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy = "disciplines")
	List<Term> term = new ArrayList<Term>();

	@Override
	public String toString(){
		return getDisciplineID() + " " + getDisciplinename();
	}
	
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

}
