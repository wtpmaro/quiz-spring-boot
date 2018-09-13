package com.quiz.sample.repository;

import com.quiz.sample.entity.Questions;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {

    Questions findFirstByQuestions(String question);
}
