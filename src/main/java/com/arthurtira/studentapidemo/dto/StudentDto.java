package com.arthurtira.studentapidemo.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class StudentDto {
    private String studentId;
    private String firstName;
    private String lastName;
    private String dob;
    private Address address;
}
