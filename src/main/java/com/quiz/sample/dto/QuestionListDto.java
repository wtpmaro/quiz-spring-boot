package com.quiz.sample.dto;

import java.util.List;

public class QuestionListDto {


    List<QuestionAndAnswers> questionAndAnswers;

    public QuestionListDto() {}

    public QuestionListDto(List<QuestionAndAnswers> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
    }

    public List<QuestionAndAnswers> getQuestionAndAnswers() {
        return questionAndAnswers;
    }

    public void setQuestionAndAnswers(List<QuestionAndAnswers> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
    }
}
