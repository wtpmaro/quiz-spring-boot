package com.quiz.sample.service;

import com.quiz.sample.entity.Questions;
import com.quiz.sample.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelSave {



    @Autowired
    QuestionsRepository questionsRepository;

    public void saveExcel(List<String> excelList) {

        for (int i =1; i < excelList.size(); i++) {

            Questions questions = new Questions();
            String[] rowsBinded = excelList.get(i).split(";");

            questions.setQuestions(rowsBinded[0]);
            questions.setAnswer(rowsBinded[1]);


            if(questionsRepository.findFirstByQuestions(rowsBinded[0]) == null) {
            questionsRepository.save(questions); }


        }



    }


}
