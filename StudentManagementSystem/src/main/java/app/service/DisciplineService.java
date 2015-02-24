package app.service;

import java.util.List;

import app.domain.Discipline;

public interface DisciplineService {
	
	public void addDiscipline(Discipline discipline);
	
	public List<Discipline> listDiscipline();
	
	public void removeDiscipline (Integer id);
	
	public void editDiscipline(Discipline discipline);
	
	public Discipline getDiscipline(Integer disciplineID);
}
