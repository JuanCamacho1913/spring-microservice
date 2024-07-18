package com.student.presentation.controllers;

import com.student.domain.services.StudentService;
import com.student.presentation.dtos.StudentRequest;
import com.student.presentation.dtos.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/findAll")
    public ResponseEntity<List<StudentResponse>> findAllStudent(){
        List<StudentResponse> studentResponse = this.studentService.findAllStudent();
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Integer id){
        StudentResponse studentResponse = this.studentService.findById(id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<Boolean> studentExist(@PathVariable Integer id){
        boolean studentExist = this.studentService.studentExist(id);
        return new ResponseEntity<>(studentExist, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody @Valid StudentRequest studentRequest){
        StudentResponse studentResponse = this.studentService.createStudent(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody @Valid StudentRequest studentRequest,
                                                         @PathVariable Integer id){
        StudentResponse studentResponse = this.studentService.updateStudent(studentRequest, id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id){
        this.studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }






}
