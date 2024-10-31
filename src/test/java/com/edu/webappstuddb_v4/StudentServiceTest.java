package com.edu.webappstuddb_v4;

import com.edu.webappstuddb_v4.models.Student;
import com.edu.webappstuddb_v4.models.User;
import com.edu.webappstuddb_v4.repositories.StudentRepository;
import com.edu.webappstuddb_v4.repositories.UserRepository;
import com.edu.webappstuddb_v4.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListStudents_WithName() {
        String name = "TestName";
        List<Student> students = new ArrayList<>();
        students.add(new Student());

        when(studentRepository.findByName(name)).thenReturn(students);

        List<Student> result = studentService.listStudents(name);

        assertEquals(students, result);
        verify(studentRepository, times(1)).findByName(name);
    }

    @Test
    void testListStudents_NoName() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.listStudents(null);

        assertEquals(students, result);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testSaveStudent() throws IOException {
        Principal principal = mock(Principal.class);
        Student student = new Student();
        User user = new User();

        when(principal.getName()).thenReturn("test@example.com");
        when(userRepository.findByEmail(principal.getName())).thenReturn(user);

        studentService.saveStudent(principal, student);

        assertEquals(user, student.getUser());
        verify(studentRepository, times(1)).save(student);
    }
}

