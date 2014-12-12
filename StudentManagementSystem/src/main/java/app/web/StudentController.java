package app.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.domain.Student;
import app.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/index")
	public String listStudents(Map<String, Object> map) {

		map.put("student", new Student());
		map.put("studentList", studentService.listStudent());

		return "StudentsList";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/StudentCreating")
	public String creatingStudent(@ModelAttribute("student") Student student) {

		return "StudentCreating";
	}

	@RequestMapping("/StudentModifying")
	public String modifyingStudent(@ModelAttribute("student") Student student) {

		return "StudentModifying";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student,
			BindingResult result) {

		studentService.addStudent(student);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Integer studentId) {

		studentService.removeStudent(studentId);

		return "redirect:/index";
	}
	
	
	
	
	@RequestMapping(value = "/edit/{studentId}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("studentId") Integer id, Model model) {

		model.addAttribute("student", studentService.getStudent(id));

		return "StudentModifying";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {

		this.studentService.editStudent(student);

		return "redirect:/index";
	}

/*	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	 public ModelAndView editStudent(@RequestParam("id") Integer id) {
	 ModelAndView mav = new ModelAndView("StudentModifying");
	 Student student = studentService.getStudent(id);
	 mav.addObject("StudentModifying", student);
	 return mav;
	 }
	
	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
	 public String updateStudent(
	 @ModelAttribute("StudentModifying") Student student,
	 BindingResult result, SessionStatus status) {
	 studentService.editStudent(student);
	 status.setComplete();
	 return "redirect:/index";
	 }
*/

}