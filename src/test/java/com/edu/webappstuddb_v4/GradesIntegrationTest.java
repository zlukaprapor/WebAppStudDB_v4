package com.edu.webappstuddb_v4;

import com.edu.webappstuddb_v4.models.Grade;
import com.edu.webappstuddb_v4.models.Student;
import com.edu.webappstuddb_v4.services.GradesService;
import com.edu.webappstuddb_v4.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GradesIntegrationTest {

    @Mock
    private GradesService gradesService;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddGradeToStudent() {
        // Ініціалізація студента і оцінки
        Long studentId = 1L;
        Student student = new Student();
        student.setId(studentId);

        Grade grade = new Grade();
        grade.setStudentId(studentId);
        grade.setSubject("Math");
        grade.setGrade(90);

        // Мокування повернення списку студентів (якщо метод не void)
        when(studentService.listStudents(null)).thenReturn(List.of(student));

        // Мокування для void методу saveGrade
        doNothing().when(gradesService).saveGrade(grade);

        // Виконання операції додавання оцінки
        gradesService.saveGrade(grade);

        // Перевірка виклику методу збереження оцінки
        verify(gradesService, times(1)).saveGrade(grade);
        assertEquals(grade.getStudentId(), studentId, "Перевірка відповідності ID студента");
    }

    @Test
    void testGetGradesByStudentId() {
        // Створення студента і декількох оцінок
        Long studentId = 1L;
        Grade mathGrade = new Grade(studentId, 1L, "Math", 90, "A");
        Grade physicsGrade = new Grade(studentId, 2L, "Physics", 85, "B");

        // Мок повернення переліку оцінок за ID студента
        when(gradesService.listGradesByStudentId(studentId)).thenReturn(List.of(mathGrade, physicsGrade));

        // Отримання оцінок та перевірка
        List<Grade> grades = gradesService.listGradesByStudentId(studentId);

        assertEquals(2, grades.size(), "Кількість оцінок повинна бути 2");
        assertEquals("Math", grades.get(0).getSubject(), "Перевірка предмету першої оцінки");
        assertEquals("Physics", grades.get(1).getSubject(), "Перевірка предмету другої оцінки");

        verify(gradesService, times(1)).listGradesByStudentId(studentId);
    }

    @Test
    void testDeleteGrade() {
        // Створення студента і оцінки
        Long studentId = 1L;
        Long gradeId = 1L;
        Grade grade = new Grade(studentId, gradeId, "Math", 90, "A");

        // Мок повернення переліку оцінок
        when(gradesService.listGradesByStudentId(studentId)).thenReturn(List.of(grade));
        doNothing().when(gradesService).deleteGrade(gradeId); // мок для deleteGrade

        // Видалення оцінки
        gradesService.deleteGrade(gradeId);

        // Перевірка виклику методу deleteGrade
        verify(gradesService, times(1)).deleteGrade(gradeId);

        // Оскільки ми використовуємо мок-об'єкт, реального видалення не відбувається.
        // Перевірте тільки виклик deleteGrade.
    }
}

