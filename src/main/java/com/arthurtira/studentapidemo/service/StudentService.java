package com.arthurtira.studentapidemo.service;

import com.arthurtira.studentapidemo.dto.CustomResponse;
import com.arthurtira.studentapidemo.dto.StudentDto;

public interface StudentService {
    StudentDto getStudentById(String studentId);
    StudentDto createStudent(StudentDto student);
    CustomResponse getStudents();
    StudentDto updateStudent(StudentDto studentDto);
}
