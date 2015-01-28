package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.DisciplineDAO;
import app.domain.Discipline;

@Service
public class DisciplineServiceImpl implements DisciplineService {

	@Autowired
	private DisciplineDAO disciplineDAO;

	@Transactional
	public void addDiscipline(Discipline discipline) {
		disciplineDAO.addDiscipline(discipline);

	}

	@Transactional
	public List<Discipline> listDiscipline() {

		return disciplineDAO.listDiscipline();
	}

	@Transactional
	public void removeDiscipline(Integer id) {
		disciplineDAO.removeDiscipline(id);
	}

	@Transactional
	public void editDiscipline(Discipline discipline) {
		disciplineDAO.editDiscipline(discipline);
	}

	@Transactional
	public Discipline getDiscipline(Integer disciplineID) {

		return disciplineDAO.getDiscipline(disciplineID);
	}

}
