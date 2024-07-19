package com.apiExamples.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "registration1")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 25)
    private String email;

    @Column(name = "mobile_no", unique = true, length = 25)
    private String mobile_no;

}