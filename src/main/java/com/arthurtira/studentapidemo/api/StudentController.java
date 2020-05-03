package com.arthurtira.studentapidemo.api;

import com.arthurtira.studentapidemo.dto.CustomResponse;
import com.arthurtira.studentapidemo.dto.StudentDto;
import com.arthurtira.studentapidemo.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ApiOperation(httpMethod = "GET", value = "Get list of all students")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "Successfully retrived all students")
    })

    public ResponseEntity<CustomResponse> getAllStudents() {
        return new ResponseEntity<> (studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable  String studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.updateStudent(studentDto), HttpStatus.OK);
    }



}
