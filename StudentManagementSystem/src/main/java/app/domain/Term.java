package app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TERM")
public class Term {

	@Id
	@Column(name = "TERM_ID")
	@GeneratedValue
	private Integer termID;

	@Column(name = "TERMNUMBER")
	@GeneratedValue
	private String termnumber;

	@Column(name = "DURATION")
	private String duration;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Discipline> disciplines = new ArrayList<Discipline>();

	public Integer getTermID() {
		return termID;
	}

	public void setTermID(Integer termID) {
		this.termID = termID;
	}

	public String getTermnumber() {
		return termnumber;
	}

	public void setTermnumber(String termnumber) {
		this.termnumber = termnumber;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}


	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

}
