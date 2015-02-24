package app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import app.domain.Discipline;
import app.domain.Term;
import app.service.DisciplineService;
import app.service.TermService;

@Controller
@SessionAttributes
public class TermController {

	@Autowired
	private TermService termService;

	@Autowired
	private DisciplineService disciplineService;
	
	

	// @InitBinder
	// protected void initBinder(WebDataBinder binder) {
	// binder.registerCustomEditor(List.class, "disciplines",
	// new CustomCollectionEditor(List.class) {
	//
	// @Override
	// protected Object convertElement(Object element) {
	//
	// Integer id = null;
	//
	// if (element instanceof String
	// && !((String) element).equals("")) {
	// System.out.println("Test 1");
	// try {
	// System.out.println("Test 2");
	// id = Integer.parseInt((String) element);
	//
	// } catch (NumberFormatException e) {
	// System.out.println("Test 3");
	// e.printStackTrace();
	// }
	// } else if (element instanceof Integer) {
	// System.out.println("Test 4");
	// id = (Integer) element;
	// }
	//
	// return id != null ? disciplineService
	// .getDisciplineById(id) : null;
	// }
	// });
	// }
	

	@RequestMapping("/TermsList")
	public String listTerms(ModelMap map) {

		map.addAttribute("termList", termService.listTerm());

		return "TermsList";
	}

	@RequestMapping(value = "/addTerm", method = RequestMethod.GET)
	public String creatingTerm(ModelMap map) {

		map.addAttribute("term", new Term());
		map.addAttribute("termList", termService.listTerm());
		map.addAttribute("discipline", new Discipline());
		map.addAttribute("disciplineList", disciplineService.listDiscipline());

		return "TermCreating";
	}

	@RequestMapping(value = "/addTerm", method = RequestMethod.POST)
	public String addTerm(@ModelAttribute(value = "term") Term term) {

		termService.addTerm(term);

		return "redirect:/TermsList";
	}

	@RequestMapping("/TermModdifying")
	public String modifyingTerm(@ModelAttribute("Term") Term term) {
		return "TermModifying";
	}

	@RequestMapping("/deleteTerm/{termId}")
	public String deleteTerm(@PathVariable("termID") Integer termID) {

		termService.removeTerm(termID);

		return "redirect:/TermsList";
	}

	@RequestMapping(value = "/editTerm/{termID}", method = RequestMethod.GET)
	public String editTerm(@PathVariable("termID") Integer termID, Model model) {

		model.addAttribute("term", termService.getTerm(termID));

		return "TermModifying";
	}

	@RequestMapping(value = "/saveTerm", method = RequestMethod.POST)
	public String saveTerm(@ModelAttribute("term") Term term, Model model) {

		this.termService.editTerm(term);

		return "redirect:/TermsList";
	}

}
