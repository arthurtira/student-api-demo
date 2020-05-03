package com.arthurtira.studentapidemo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.arthurtira.studentapidemo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class StudentRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public StudentRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void createStudent(Student student) {
        dynamoDBMapper.save(student);
    }

    public Student getStudentById(String studentId) {
        return dynamoDBMapper.load(Student.class, studentId);
    }

    public List<Student> getStudents() {
        return dynamoDBMapper.scan(Student.class, new DynamoDBScanExpression());
    }

    public Student updateStudent(Student student) {
        try {
            log.debug("Updating student {} " + student);
            this.dynamoDBMapper.save(student, buildSaveExpression(student));
        }catch (ConditionalCheckFailedException e){
            log.debug("ERROR: Could bot update record");
        }
        return student;
    }

    private DynamoDBSaveExpression buildSaveExpression(Student student) {
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expected = new HashMap<>();
        expected.put("student_id", new ExpectedAttributeValue(new AttributeValue(student.getStudentId()))
                .withComparisonOperator(ComparisonOperator.EQ));

        saveExpression.setExpected(expected);

        return saveExpression;

    }



}
