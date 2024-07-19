package com.apiExamples.payload;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class RegistrationDto {


    private Long id;


    private String name;


    private String email;


    private String mobile_no;
    private String message;

}