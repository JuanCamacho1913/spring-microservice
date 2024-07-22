package com.example.domain.services.interfaces;

import com.example.presentation.dtos.CourseRequest;
import com.example.presentation.dtos.CourseResponse;

import java.util.List;

public interface ICourseService {

    List<CourseResponse> findAllCourse();
    CourseResponse findById(Integer id);
    boolean courseExist(Integer id);
    CourseResponse createCourse(CourseRequest courseRequest);
    CourseResponse updateCourse(CourseRequest courseRequest, Integer id);
    void deleteCourseById(Integer id);
}
