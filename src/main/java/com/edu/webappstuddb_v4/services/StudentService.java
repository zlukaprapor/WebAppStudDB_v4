package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    private long ID = 0;

    {
        students.add(new Student(++ID, "Oleksii", "Tkachenko", "test1@mail.com", "IN12", "ELIT"));
        students.add(new Student(++ID, "Nastia", "Ivanova", "test2@mail.com", "IN11", "ELIT"));
        students.add(new Student(++ID, "Ania", "Vasilkova", "test3@mail.com", "IN10", "ELIT"));
    }

    public List<Student> listStudents() {
        return students;
    }

    public void saveStudent(Student student) {
        student.setId(++ID);
        students.add(student);
    }

    public void delStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
