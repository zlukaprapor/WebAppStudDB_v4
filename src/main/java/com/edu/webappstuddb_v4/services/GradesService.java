package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Grade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradesService {

    private List<Grade> grades = new ArrayList<>();
    private long ID = 0;

    {

        grades.add(new Grade(++ID, 1, 1, "Test", 100, "A"));
        grades.add(new Grade(++ID, 2, 4, "Test", 100, "A"));
        grades.add(new Grade(++ID, 3, 7, "Test", 100, "A"));
        grades.add(new Grade(++ID, 1, 2, "Exam", 90, "B"));
        grades.add(new Grade(++ID, 2, 5, "Exam", 90, "B"));
        grades.add(new Grade(++ID, 3, 8, "Exam", 90, "B"));
        grades.add(new Grade(++ID, 1, 3, "Lab", 80, "D"));
        grades.add(new Grade(++ID, 2, 6, "Lab", 80, "D"));
        grades.add(new Grade(++ID, 3, 9, "Lab", 80, "D"));

    }

    public List<Grade> getGradesByStudentId(Long studentId) {
        return grades.stream()
                .filter(grade -> grade.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

    public void saveGrade(Grade grade) {
        grade.setId(++ID);
        grades.add(grade);
    }

    public void delGrade(Long id) {
        grades.removeIf(grade -> grade.getId().equals(id));
    }
}
