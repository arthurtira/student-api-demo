package com.arthurtira.studentapidemo.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@Data
@DynamoDBDocument
public class Address {
    @DynamoDBAttribute(attributeName = "address_line_1")
    private String addressLine1;

    @DynamoDBAttribute
    private String surburb;

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String province;

    @DynamoDBAttribute(attributeName = "postal_code")
    private String postalCode;

    @DynamoDBAttribute
    private String country;
}
