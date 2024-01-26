package com.example.QuizApplication.service;

import com.example.QuizApplication.Repositry.QuizDao;
import com.example.QuizApplication.Repositry.QutionDao;
import com.example.QuizApplication.model.QuetionWrapper;
import com.example.QuizApplication.model.Quiz;
import com.example.QuizApplication.model.Qutions;
import com.example.QuizApplication.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServise {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QutionDao qutionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Qutions> qutions = qutionDao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQutions(qutions);
        quizDao.save(quiz);
        return new  ResponseEntity<String>("sucess", HttpStatus.OK);
    }

    public ResponseEntity<List<QuetionWrapper>> getQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Qutions> qutionsFromDB = quiz.get().getQutions();
        List<QuetionWrapper> questionforUser = new ArrayList<>();
        for(Qutions q : qutionsFromDB)
        {
            QuetionWrapper qw = new QuetionWrapper(q.getId(),q.getQutionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionforUser.add(qw);
        }

        return new  ResponseEntity<>(questionforUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Qutions> qutions = quiz.getQutions();
        int i =0;
        int rightanswer=0;
        for (Response response :responses)
        {
            if(response.getResponse().equals(qutions.get(i).getRightAnswer()))
            {
                rightanswer++;

            }
            i++;
        }
        return new ResponseEntity<>(rightanswer,HttpStatus.OK);
    }
}
