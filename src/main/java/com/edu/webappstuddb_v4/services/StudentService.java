package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Student;
import com.edu.webappstuddb_v4.models.User;
import com.edu.webappstuddb_v4.repositories.StudentRepository;
import com.edu.webappstuddb_v4.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
   private final StudentRepository studentRepository;
   private  final UserRepository userRepository;
    public List<Student> listStudents(String name){
        if (name != null) return studentRepository.findByName(name);
        return studentRepository.findAll();
    }

    public void saveStudent(Principal principal, Student student) throws IOException {
        student.setUser(getUserByPrincipal(principal));
        log.info("Saving new {}", student);
        studentRepository.save(student);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
