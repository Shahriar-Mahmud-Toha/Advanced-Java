package dev.controller;
import dev.domain.Gender;
import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, HttpServletRequest request) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        // Checking if the "dateOfBirth" field is present in the form
        if (request.getParameter("dateOfBirth") != null && !request.getParameter("dateOfBirth").equals("")) {
            DateValidator dateValidator = new DateValidator();
            webDataBinder.registerCustomEditor(LocalDate.class, dateValidator);
        }

        // Checking if the "gender" field is present in the form
        if (request.getParameter("gender") != null && !request.getParameter("gender").equals("")) {
            webDataBinder.registerCustomEditor(Gender.class, new GenderPropertyEditor());
        }
    }
    @RequestMapping("/students/registration")
    public String Registration(Model model) {
        model.addAttribute("student", new Student());
        return "registration";
    }
    @RequestMapping("/students/create")
    public String Create(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            studentService.create(student);
            return "redirect:/students";
        }
    }
    @RequestMapping("/students")
    public String ViewAll(Model model) throws SQLException {
        model.addAttribute("students", studentService.getAll());
        return "viewAll";
    }
    @RequestMapping("/students/{id}")
    public String Get(@PathVariable ("id") int id, Model model) throws SQLException {
        Student student = studentService.get(id);
        if(student!=null){
            model.addAttribute("student", student);
            return "details";
        }
        else {
            return "redirect:/students";
        }
    }

    @RequestMapping("/students/{id}/edit")
    public String Edit(@PathVariable ("id") int id, Model model) throws SQLException {
        model.addAttribute("student", studentService.get(id));
        return "edit";
    }

    @RequestMapping("/update")
    public String Update(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) throws SQLException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student",student);
            return "edit";
        }
        else {
            studentService.update(student);
            return "redirect:/students";
        }
    }
    @RequestMapping("/students/{id}/delete")
    public String Delete(@PathVariable ("id") int id) throws SQLException {
        if(!studentService.delete(id)){
            return "redirect:/students";
        }
        else {
            return "redirect:/students";
        }
    }
    public static Gender ConvertToGender(String gender){
        if(gender.equals("MALE")){
            return Gender.MALE;
        }
        else {
            return Gender.FEMALE;
        }
    }
    public static class DateValidator extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            LocalDate date = LocalDate.parse(text);
            setValue(date);
        }
    }
    public static class GenderPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Gender gender;
            if(text.equalsIgnoreCase("male")){
                gender = Gender.MALE;
            }
            else {
                gender = Gender.FEMALE;
            }
            setValue(gender);
        }
    }
}
