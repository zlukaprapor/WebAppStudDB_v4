package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Discipline;
import com.edu.webappstuddb_v4.models.Grade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplineService {

    private List<Discipline> disciplines = new ArrayList<>();
    private long ID = 0;

    {
        disciplines.add(new Discipline(++ID, 1, "Math"));
        disciplines.add(new Discipline(++ID, 1, "Physics"));
        disciplines.add(new Discipline(++ID, 1, "History"));
        disciplines.add(new Discipline(++ID, 2, "Math"));
        disciplines.add(new Discipline(++ID, 2, "Physics"));
        disciplines.add(new Discipline(++ID, 2, "History"));
        disciplines.add(new Discipline(++ID, 3, "Math"));
        disciplines.add(new Discipline(++ID, 3, "Physics"));
        disciplines.add(new Discipline(++ID, 3, "History"));
    }

    public List<Discipline> getDisciplineByStudentId(Long studentId) {
        return disciplines.stream()
                .filter(discipline -> discipline.getStudentId() == studentId)
                .collect(Collectors.toList());
    }


}

