package app.dao;

import java.util.List;

import app.domain.Discipline;

public interface DisciplineDAO {
	
	public void addDiscipline(Discipline discipline);
	
	public List<Discipline> listDiscipline();
	
	public void editDiscipline(Discipline discipline);
	
	public void removeDiscipline(Integer id);
	
	public Discipline getDisciplineById(Integer disciplineID);
	
	
}
