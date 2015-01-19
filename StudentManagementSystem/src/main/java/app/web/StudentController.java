package app.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping("/StudentsList")
	public String listStudents(Map<String, Object> map) {

		map.put("student", new Student());
		map.put("studentList", studentService.listStudent());

		return "StudentsList";
	}
	
	@RequestMapping("/TitlePage")
	public String TitlePage() {
		return "TitlePage";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/TitlePage";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "redirect:/TitlePage";
	}

	@RequestMapping("/StudentCreating")
	public String creatingStudent(@ModelAttribute("student") Student student) {

		return "StudentCreating";
	}

	@RequestMapping("/StudentModifying")
	public String modifyingStudent(@ModelAttribute("student") Student student) {

		return "StudentModifying";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {

		studentService.addStudent(student);

		return "redirect:/StudentsList";
	}

	@RequestMapping("/deleteStudent/{studentID}")
	public String deleteStudent(@PathVariable("studentID") Integer studentId) {

		studentService.removeStudent(studentId);

		return "redirect:/StudentsList";
	}

	@RequestMapping(value = "/editStudent/{studentID}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("studentID") Integer studentID, Model model) {

		model.addAttribute("student", studentService.getStudent(studentID));

		return "StudentModifying";
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student, Model model) {

		this.studentService.editStudent(student);

		return "redirect:/StudentsList";
	}

}