package com.student.presentation.dtos;

public record StudentResponse(
        Integer id,
        String name,
        String lastName,
        String email,
        Byte age){
}
