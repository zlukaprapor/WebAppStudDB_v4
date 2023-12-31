package com.edu.webappstuddb_v4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "discipline")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "discipline")
    private String discipline;
    @Column(name = "studentId")
    private Long studentId;
    @OneToMany(mappedBy = "disciplineId", cascade = CascadeType.ALL)
    private List<Grade> grades;
}
