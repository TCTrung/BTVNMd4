package com.example.baitapvnmd4.controller;

import com.example.baitapvnmd4.model.Student;
import com.example.baitapvnmd4.service.IStudentService;
import com.example.baitapvnmd4.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/students")
public class StudenController {
private final IStudentService studentService = new StudentService();
@GetMapping("")
    public String index (Model model){
    List<Student> students = studentService.findAll();
    model.addAttribute("students",students);
    return "/index";
}
@GetMapping("/sort")
    public String sort (Model model){
    List<Student> students = studentService.sortStudentsByAge();
    model.addAttribute("students",students);
    return "/viewsort";
}

@GetMapping("/create")
    public String create(Model model){
    model.addAttribute("student",new Student());
    return "/create";
}
@PostMapping("/save")
    public String save (Student student){
    studentService.save(student);
    return "redirect:/students";
}
@GetMapping("/{id}/update")
public String update(@PathVariable int id,Model model){
    model.addAttribute("student",studentService.findById(id));
    return "/update";
}
@PostMapping("/update")
    public String update(Student student){
    studentService.update(student.getId(),student);
    return "redirect:/students";
}
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Student student, RedirectAttributes redirect) {
        studentService.remove(student.getId());
        redirect.addFlashAttribute("success", "Removed student successfully!");
        return "redirect:/students";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/view";
    }
    @GetMapping("/search")
    public String search (@RequestParam String gender, Model model){
    List<Student> students;
    if (Objects.equals(gender, "")){
        students = studentService.findAll();
        model.addAttribute("students",students);
        return "/index";
    }
    students = studentService.searchStudentsByGender(gender);
        model.addAttribute("students",students);
        return "/index";
    }

}
