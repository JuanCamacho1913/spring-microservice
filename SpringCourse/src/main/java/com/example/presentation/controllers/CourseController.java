package com.example.presentation.controllers;

import com.example.domain.services.interfaces.ICourseService;
import com.example.presentation.dtos.CourseRequest;
import com.example.presentation.dtos.CourseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @GetMapping("/findAll")
    public ResponseEntity<List<CourseResponse>> findAllCourse(){
        return new ResponseEntity<>(this.courseService.findAllCourse(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CourseResponse> findById(@PathVariable Integer id){
        return new ResponseEntity<>(this.courseService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<Boolean> courseExist(@PathVariable Integer id){
        return new ResponseEntity<>(this.courseService.courseExist(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponse> createCourse(@RequestBody @Valid CourseRequest courseRequest){
        return new ResponseEntity<>(this.courseService.createCourse(courseRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponse> updateCourse(@RequestBody @Valid CourseRequest courseRequest, @PathVariable Integer id){
        return new ResponseEntity<>(this.courseService.updateCourse(courseRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Integer id){
        this.courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }








}
