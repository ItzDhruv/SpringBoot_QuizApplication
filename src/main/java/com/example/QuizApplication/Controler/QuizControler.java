package com.example.QuizApplication.Controler;

import com.example.QuizApplication.model.QuetionWrapper;
import com.example.QuizApplication.model.Response;
import com.example.QuizApplication.service.QuizServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizControler {

    @Autowired
    QuizServise quizServise;

    @PostMapping("create")      // create Quiz
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
    {
        return quizServise.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")     // for getting quiz to user
    public ResponseEntity<List<QuetionWrapper>> getQuizQuestion(@PathVariable Integer id)
    {
        return quizServise.getQuestion(id);
    }

    @PostMapping("submit/{id}")         // submit Quiz
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
      return quizServise.calculateResult(id,responses);
    }

}
