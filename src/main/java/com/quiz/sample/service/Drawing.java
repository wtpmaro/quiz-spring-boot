package com.quiz.sample.service;


import com.quiz.sample.dto.QuestionAndAnswers;
import com.quiz.sample.dto.QuestionListDto;
import com.quiz.sample.entity.Questions;
import com.quiz.sample.repository.QuestionsRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class Drawing {

    @Autowired
    QuestionsRepository questionsRepository;

    public List<Questions> drawnquestions() {

        List<Questions> listAll = questionsRepository.findAll();
        List<Questions> drawn = new ArrayList<>();
        for (int i =0; i < 10; i++) {
            Random random = new Random();
            int drawnNumber = random.nextInt(listAll.size());

            drawn.add(listAll.get(drawnNumber));
            listAll.remove(drawnNumber);
        }
        return drawn;
    }

    public List<QuestionAndAnswers> dtoListCreation() {

        List<Questions> drawnquestions = drawnquestions();

        List<QuestionAndAnswers> list = new ArrayList<>();
        for (int i =0; i < drawnquestions.size(); i++) {
            list.add(new QuestionAndAnswers(drawnquestions.get(i).getQuestions(), drawnquestions.get(i).getAnswer(), ""));
        }

        return list;
    }
}
