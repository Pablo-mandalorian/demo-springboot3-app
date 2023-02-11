package com.example.demospringbootapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class Dog {
    

    @Id
    @GeneratedValue
    private Long id;
    private String race;
    private String name;
    private Integer age;
}
