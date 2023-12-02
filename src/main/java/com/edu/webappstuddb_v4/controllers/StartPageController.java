package com.edu.webappstuddb_v4.controllers;

import com.edu.webappstuddb_v4.models.Student;
import com.edu.webappstuddb_v4.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StartPageController {
    private final StudentService studentService;


    @GetMapping("/")
    public String startpage(Model model) {
        model.addAttribute("students", studentService.listStudents());

        return "startpage";
    }

    @PostMapping("/student/send")
    public String sendStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }
    @PostMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.delStudent(id);
        return "redirect:/";
    }
}
