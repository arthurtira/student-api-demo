package com.arthurtira.studentapidemo.service;


import com.arthurtira.studentapidemo.dto.CustomResponse;
import com.arthurtira.studentapidemo.dto.StudentDto;
import com.arthurtira.studentapidemo.mapper.StudentMapper;
import com.arthurtira.studentapidemo.model.Student;
import com.arthurtira.studentapidemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto getStudentById(String studentId) {
        Student student = this.studentRepository.getStudentById(studentId);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentMapper.fromDto(studentDto);
        studentRepository.createStudent(student);

        return studentDto;
    }

    @Override
    public CustomResponse getStudents() {
        List<Student> students = studentRepository.getStudents();

        CustomResponse response = new CustomResponse();
        response.setSize(students.size());
        response.setStudents(studentMapper.toDtoList(students));
        return response;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = studentRepository.getStudentById(studentDto.getStudentId());
        try {
            student.setDob(df.parse(studentDto.getDob()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setAddress(studentDto.getAddress());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        return studentMapper.toDto(studentRepository.updateStudent(student));
    }



}
