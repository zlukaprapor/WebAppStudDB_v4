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
}
