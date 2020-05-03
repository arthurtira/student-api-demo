package com.arthurtira.studentapidemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomResponse {
    private int size;
    private List<StudentDto> students;
}
