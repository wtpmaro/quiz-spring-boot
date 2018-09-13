package com.quiz.sample.service;

import com.quiz.sample.dto.QuestionListDto;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;

@Service
public class Result {

    public int finalResult(QuestionListDto questionListDto) {

        int listSize = questionListDto.getQuestionAndAnswers().size();
        int finalResult =0;
        for (int i=0; i < listSize; i++) {

            //Correct answer converted to lowerCase (to avoid influnce case sensitive for result)
            String correctAnswer = questionListDto.getQuestionAndAnswers().get(i).getSolution().toLowerCase().trim();

            //Answer made by user
            String userAnswer = questionListDto.getQuestionAndAnswers().get(i).getUserAnswer().toLowerCase().trim();

            if (correctAnswer.equals(userAnswer)){
                finalResult+=1;
            }
        }

        return finalResult;
    }
}
