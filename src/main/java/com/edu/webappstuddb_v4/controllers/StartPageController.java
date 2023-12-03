package com.edu.webappstuddb_v4.controllers;

import com.edu.webappstuddb_v4.models.Discipline;
import com.edu.webappstuddb_v4.models.Grade;
import com.edu.webappstuddb_v4.models.Student;
import com.edu.webappstuddb_v4.services.DisciplineService;
import com.edu.webappstuddb_v4.services.GradesService;
import com.edu.webappstuddb_v4.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StartPageController {
    private final StudentService studentService;
    private final GradesService gradesService;
    private final DisciplineService disciplineService;


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
    public String deleteStudent(@PathVariable Long id) {
        studentService.delStudent(id);
        return "redirect:/";
    }

    @GetMapping("/grades")
    public String viewGrades(@RequestParam Long studentId, Model model) {

        List<Grade> studentGrades = gradesService.getGradesByStudentId(studentId);
        List<Discipline> studentDiscipline = disciplineService.getDisciplineByStudentId(studentId);

        model.addAttribute("grades", studentGrades);
        model.addAttribute("disciplines", studentDiscipline);

        return "grades";
    }

}
