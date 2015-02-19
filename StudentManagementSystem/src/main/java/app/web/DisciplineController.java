package app.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.domain.Discipline;
import app.service.DisciplineService;

@Controller
public class DisciplineController {
	
	@Autowired
	private DisciplineService disciplineService;
	
	@RequestMapping("/DisciplinesList")
	public String listDiscipline(Map<String, Object> map) {
		
		map.put("discipline", new Discipline());
		map.put("disciplineList", disciplineService.listDiscipline());
		
		return "DisciplinesList";
	}
		
	@RequestMapping("/DisciplineCreating")
	public String creatingDiscipline(@ModelAttribute("discipline") Discipline discipline) {
		
		return "DisciplineCreating";
	}
	
	@RequestMapping("/DisciplineModifying")
	public String modifyingDiscipline(@ModelAttribute("discipline") Discipline discipline) {
		
		return "DisciplineModifying";
	}
	
	@RequestMapping(value = "/addDiscipline", method = RequestMethod.POST)
	public String addDiscipline(@ModelAttribute("discipline") Discipline discipline) {
		
		disciplineService.addDiscipline(discipline);
		
		return "redirect:/DisciplinesList";
	}
	
	@RequestMapping("/deleteDiscipline/{disciplineID}")
	public String deleteDiscipline(@PathVariable("disciplineID") Integer disciplineID) {
		
		disciplineService.removeDiscipline(disciplineID);
		
		return "redirect:/DisciplinesList";
	}
	
	@RequestMapping(value = "/editDiscipline/{disciplineID}", method = RequestMethod.GET)
	public String editDiscipline(@PathVariable("disciplineID") Integer disciplineID, Model model) {
		
		model.addAttribute("discipline", disciplineService.getDisciplineById(disciplineID));
		
		return "DisciplineModifying";
	}
	
	@RequestMapping(value = "/saveDiscipline", method = RequestMethod.POST)
	public String saveDiscipline(@ModelAttribute("discipline") Discipline discipline, Model model) {
		
		this.disciplineService.editDiscipline(discipline);
		
		return "redirect:/DisciplinesList";
	}

}
