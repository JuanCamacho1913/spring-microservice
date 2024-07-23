package com.example.presentation.dtos;

import jakarta.validation.constraints.NotNull;

public record CourseRequest(

        @NotNull(message = "Course name is mandatory")
        String name,
        @NotNull(message = "Course school is mandatory")
        String school,
        @NotNull(message = "Course city is mandatory")
        String city
) {
}
