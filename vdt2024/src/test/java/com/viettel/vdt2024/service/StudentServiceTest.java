package com.viettel.vdt2024.service;

import com.viettel.vdt2024.model.Student;
import com.viettel.vdt2024.repository.StudentRepository;
import com.viettel.vdt2024.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindStudent_Success() {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));

        Optional<Student> result = studentService.findStudent(1);

        assertTrue(result.isPresent());
        assertEquals(student.getFullname(), result.get().getFullname());
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    public void testFindStudent_NotFound() {
        when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());

        Optional<Student> result = studentService.findStudent(1);

        assertFalse(result.isPresent());
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    public void testFindAll_Success() {
        Student student1 = new Student();
        student1.setId(1);
        student1.setFullname("John Doe");
        student1.setGender("Male");
        student1.setSchool("Some School");

        Student student2 = new Student();
        student2.setId(2);
        student2.setFullname("Jane Doe");
        student2.setGender("Female");
        student2.setSchool("Another School");

        List<Student> students = Arrays.asList(student1, student2);

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.findAll();

        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testSaveStudent_Success() {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student result = studentService.save(student);

        assertNotNull(result);
        assertEquals(student.getFullname(), result.getFullname());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testUpdateStudent_Success() {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student result = studentService.update(student);

        assertNotNull(result);
        assertEquals(student.getFullname(), result.getFullname());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testDeleteStudent_Success() {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        doNothing().when(studentRepository).delete(any(Student.class));

        studentService.delete(student);
        verify(studentRepository, times(1)).delete(student);
    }
    @Test
    public void testDeleteStudentById_Success() {
        doNothing().when(studentRepository).deleteById(anyInt());

        studentService.deleteById(1);

        verify(studentRepository, times(1)).deleteById(1);
    }
}
