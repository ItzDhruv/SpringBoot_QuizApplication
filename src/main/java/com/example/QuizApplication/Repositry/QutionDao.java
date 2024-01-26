package com.example.QuizApplication.Repositry;

import com.example.QuizApplication.model.Qutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QutionDao extends JpaRepository<Qutions,Integer> {

    List<Qutions> findByCategory(String catagory);

    @Query("SELECT q FROM Qutions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ")
    List<Qutions> findRandomQuestionByCategory(String category, int numQ);

}
