package com.arthurtira.studentapidemo.mapper;


import com.arthurtira.studentapidemo.dto.StudentDto;
import com.arthurtira.studentapidemo.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target="dob", source = "studentDto.dob",dateFormat = "yyyy-MM-dd")
    Student fromDto(StudentDto studentDto);

    @Mapping(target="dob", source = "student.dob",dateFormat = "yyyy-MM-dd")
    StudentDto toDto(Student student) ;

    List<StudentDto> toDtoList(List<Student> studentList);
}
