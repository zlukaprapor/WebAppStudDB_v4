package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Student;
import com.edu.webappstuddb_v4.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
   private final StudentRepository studentRepository;
    public List<Student> listStudents(String name){
        if (name != null) return studentRepository.findByName(name);
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        log.info("Saving new {}", student);
        studentRepository.save(student);
    }

    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }

//    public void getStudentByID(Long id){
//        return studentRepository.findById(id).orElse(null);
//    }
}
