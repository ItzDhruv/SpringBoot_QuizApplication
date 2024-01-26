package com.example.QuizApplication.service;

import com.example.QuizApplication.Repositry.QutionDao;
import com.example.QuizApplication.model.Qutions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuettionService {
    @Autowired
     QutionDao qutionDao;

    public  ResponseEntity<List<Qutions>> getbyQutionCategory(String category) {
        try {
            return new ResponseEntity<>(qutionDao.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Qutions>> getAllQution() {
        try {
            return new ResponseEntity<>(qutionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String>  addQuestion(Qutions qutions) {
        try {
            qutionDao.save(qutions);
            return new ResponseEntity<>("sucess", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Bad req", HttpStatus.BAD_REQUEST);
    }
}
