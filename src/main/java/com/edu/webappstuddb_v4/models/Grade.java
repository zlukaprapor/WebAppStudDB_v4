package com.edu.webappstuddb_v4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "studentId")
    private Long studentId;
    @Column(name = "disciplineId")
    private Long disciplineId;
    @Column(name = "subject")
    private String subject;
    @Column(name = "grade")
    private int grade;
    @Column(name = "ects")
    private String ects;

    // Спеціальний конструктор без id
    public Grade(Long studentId, Long disciplineId, String subject, int grade, String ects) {
        this.studentId = studentId;
        this.disciplineId = disciplineId;
        this.subject = subject;
        this.grade = grade;
        this.ects = ects;
    }
}
