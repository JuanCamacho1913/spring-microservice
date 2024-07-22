package com.example.util.mapper;

import com.example.persistence.entities.CourseEntity;
import com.example.presentation.dtos.CourseRequest;
import com.example.presentation.dtos.CourseResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseMapper {

    public CourseResponse getCourseResponse(CourseEntity courseEntity){
        return new CourseResponse(
                courseEntity.getId(),
                courseEntity.getName(),
                courseEntity.getSchool(),
                courseEntity.getCity()
        );
    }

    public List<CourseResponse> getCourseResponseList(List<CourseEntity> courseEntityList){
        return courseEntityList.stream()
                .map(course -> new CourseResponse(
                        course.getId(),
                        course.getName(),
                        course.getSchool(),
                        course.getCity()
                )).toList();
    }

    public CourseEntity getCourse(CourseRequest courseRequest){
        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setName(courseRequest.name());
        courseEntity.setSchool(courseRequest.school());
        courseEntity.setCity(courseRequest.city());

        return courseEntity;
    }

    public CourseEntity getUpdateCourse(CourseRequest courseRequest, CourseEntity course){

        if (StringUtils.isNotEmpty(courseRequest.name())){
            course.setName(courseRequest.name());
        }

        if (StringUtils.isNotEmpty(courseRequest.school())){
            course.setSchool(courseRequest.school());
        }

        if (StringUtils.isNotEmpty(courseRequest.city())){
            course.setCity(courseRequest.city());
        }

        return course;
    }
}
