package com.viettel.vdt2024.controller;

import com.viettel.vdt2024.model.Student;
import com.viettel.vdt2024.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Integer id) {
        Optional<Student> studentOptional = studentService.findStudent(id);
        return studentOptional.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student){
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping
    public void delete(@RequestBody Student student){
        studentService.delete(student);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentService.findStudent(id);
        if(!student.isEmpty()){
            studentService.deleteById(id);
        }
        return student.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
