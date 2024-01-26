package com.example.QuizApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data                   // for getter setter method
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    private List<Qutions> qutions;

}
