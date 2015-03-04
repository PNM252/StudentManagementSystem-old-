package app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import app.domain.Discipline;
import app.service.DisciplineService;

final public class StringToDiscipline  implements Converter<String, Discipline>{
	
	@Autowired DisciplineService disciplineService;
	
	@Override
	public Discipline convert (String discipline) {
		return disciplineService.getDiscipline(Integer.valueOf(discipline));
	}

}
