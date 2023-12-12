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

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StartPageController {
    private final StudentService studentService;
    private final GradesService gradesService;
    private final DisciplineService disciplineService;


    @GetMapping("/")
    public String startpage(@RequestParam(name = "name", required = false) String name,Principal principal, Model model) {
        model.addAttribute("students", studentService.listStudents(name));
        model.addAttribute("user", studentService.getUserByPrincipal(principal));
        return "startpage";
    }

    @PostMapping("/student/create")
    public String sendStudent(Student student, Principal principal) throws IOException {
        studentService.saveStudent(principal, student);
        return "redirect:/";
    }

    @PostMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delStudent(id);
        return "redirect:/";
    }

    @GetMapping("/grades/{studentId}")
    public String grades(@PathVariable Long studentId, Model model) {
        List<Grade> studentGrades = gradesService.listGradesByStudentId(studentId);
        List<Discipline> studentDisciplines = disciplineService.getDisciplinesForStudent(studentId);
        model.addAttribute("grades", studentGrades);
        model.addAttribute("studentId", studentId);
        model.addAttribute("disciplines", studentDisciplines);
        return "grades";
    }

    @PostMapping("/grades/add")
    public String addGrade(@ModelAttribute Grade grade,  @RequestParam(name = "disciplineId") Long disciplineId) {
        grade.setDisciplineId(disciplineId);
        gradesService.saveGrade(grade);
        return "redirect:/grades/" + grade.getStudentId();
    }




    @PostMapping("/grades/delete")
    public String deleteGrade(@RequestParam Long gradeId, @RequestParam Long studentId) {
        gradesService.deleteGrade(gradeId);
        return "redirect:/grades/" + studentId;
    }
    @PostMapping("/disciplines/add")
    public String addDiscipline(@RequestParam Long studentId, @RequestParam String disciplineName) {
        Discipline discipline = new Discipline();
        discipline.setStudentId(studentId);
        discipline.setDiscipline(disciplineName);
        disciplineService.saveDiscipline(discipline);
        return "redirect:/grades/" + studentId;
    }

    @PostMapping("/disciplines/delete")
    public String deleteDiscipline(@RequestParam Long disciplineId, @RequestParam Long studentId) {
        disciplineService.deleteDiscipline(disciplineId);
        return "redirect:/grades/" + studentId;
    }
}
