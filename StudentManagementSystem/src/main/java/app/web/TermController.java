package app.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, "disciplines",
				new CustomCollectionEditor(List.class) {

					@Override
					protected Object convertElement(Object element) {

						Integer id = null;

						if (element instanceof String
								&& !((String) element).equals("")) {
							try {
								id = Integer.parseInt((String) element);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						} else if (element instanceof Integer) {
							id = (Integer) element;
						}

						return id != null ? termService.getTerm(id) : null;
					}
				});
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder, WebRequest request) {
	//
	// binder.registerCustomEditor(Discipline.class, "disciplines",
	// new PropertyEditorSupport() {
	// @Override
	// public void setAsText(String text) {
	// setValue((text.equals("")) ? null : disciplineService
	// .getDiscipline(Integer.parseInt((String) text)));
	// }
	// });
	// }

	@RequestMapping("/TermsList")
	public String listTerms(Map<String, Object> map) {

		map.put("term", new Term());
		map.put("termList", termService.listTerm());

		return "TermsList";
	}

	@RequestMapping("/TermCreating")
	public String creatingTerm(Map<String, Object> map) {

		map.put("term", new Term());
		map.put("termList", termService.listTerm());
		map.put("discipline", new Discipline());
		map.put("disciplineList", disciplineService.listDiscipline());

		return "TermCreating";
	}

	@RequestMapping("/TermModdifying")
	public String modifyingTerm(@ModelAttribute("Term") Term term) {
		return "TermModifying";
	}

	@RequestMapping(value = "/addTerm", method = RequestMethod.POST)
	public String addTerm(@ModelAttribute("Term") Term term) {

		termService.addTerm(term);

		return "redirect:/TermsList";
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
