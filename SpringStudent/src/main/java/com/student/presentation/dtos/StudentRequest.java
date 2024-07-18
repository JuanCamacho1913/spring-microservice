package com.student.presentation.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record StudentRequest(

        @NotNull(message = "Student Name is mandatory")
        String name,
        @NotNull(message = "Student LastName is mandatory")
        String lastName,

        @Email(message = "Student Email is not valid")
        @NotNull(message = "Student Email is mandatory")
        String email,

        Byte age){
}
