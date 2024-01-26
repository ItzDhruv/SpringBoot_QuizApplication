package com.example.QuizApplication.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class QuetionWrapper {
    private int id;
    private String qutionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuetionWrapper(int id, String qutionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.qutionTitle = qutionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
