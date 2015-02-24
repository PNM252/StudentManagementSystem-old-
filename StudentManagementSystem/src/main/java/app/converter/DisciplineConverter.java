package app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import app.domain.Discipline;
import app.service.DisciplineService;

public class DisciplineConverter implements Converter<String, Discipline> {

	@Autowired
	private DisciplineService disciplineService;

	@Override
	public Discipline convert(String disciplineID) {
		return disciplineService.getDiscipline(Integer.valueOf(disciplineID));
	}

}
