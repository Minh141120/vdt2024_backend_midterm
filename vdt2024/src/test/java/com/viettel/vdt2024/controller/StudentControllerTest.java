package com.viettel.vdt2024.controller;

import com.viettel.vdt2024.model.Student;
import com.viettel.vdt2024.service.StudentService;
import com.viettel.vdt2024.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StudentControllerTest {
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testFindStudent_Success() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        when(studentService.findStudent(anyInt())).thenReturn(Optional.of(student));

        mockMvc.perform(get("http://localhost:8080/api/student/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.fullname", is("John Doe")))
                .andExpect(jsonPath("$.gender", is("Male")))
                .andExpect(jsonPath("$.school", is("Some School")));
    }

    @Test
    public void testFindStudent_NotFound() throws Exception {
        when(studentService.findStudent(anyInt())).thenReturn(Optional.empty());

        mockMvc.perform(get("http://localhost:8080/api/student/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAll_Success() throws Exception {
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

        when(studentService.findAll()).thenReturn(students);

        mockMvc.perform(get("http://localhost:8080/api/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].fullname", is("John Doe")))
                .andExpect(jsonPath("$[0].gender", is("Male")))
                .andExpect(jsonPath("$[0].school", is("Some School")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].fullname", is("Jane Doe")))
                .andExpect(jsonPath("$[1].gender", is("Female")))
                .andExpect(jsonPath("$[1].school", is("Another School")));
    }

    @Test
    public void testSaveStudent_Success() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        when(studentService.save(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("http://localhost:8080/api/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"fullname\":\"John Doe\",\"gender\":\"Male\",\"school\":\"Some School\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.fullname", is("John Doe")))
                .andExpect(jsonPath("$.gender", is("Male")))
                .andExpect(jsonPath("$.school", is("Some School")));
    }
    @Test
    public void testUpdateStudent_Success() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        when(studentService.update(any(Student.class))).thenReturn(student);

        mockMvc.perform(put("http://localhost:8080/api/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"fullname\":\"John Doe\",\"gender\":\"Male\",\"school\":\"Some School\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.fullname", is("John Doe")))
                .andExpect(jsonPath("$.gender", is("Male")))
                .andExpect(jsonPath("$.school", is("Some School")));
    }

    @Test
    public void testDeleteStudent_Success() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setFullname("John Doe");
        student.setGender("Male");
        student.setSchool("Some School");

        when(studentService.findStudent(anyInt())).thenReturn(Optional.of(student));
        doNothing().when(studentService).deleteById(anyInt());

        mockMvc.perform(delete("http://localhost:8080/api/student/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.fullname", is("John Doe")))
                .andExpect(jsonPath("$.gender", is("Male")))
                .andExpect(jsonPath("$.school", is("Some School")));

        verify(studentService, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteStudent_NotFound() throws Exception {
        when(studentService.findStudent(anyInt())).thenReturn(Optional.empty());

        mockMvc.perform(delete("http://localhost:8080/api/student/{id}", 1))
                .andExpect(status().isNotFound());

        verify(studentService, never()).deleteById(anyInt());
    }
}
