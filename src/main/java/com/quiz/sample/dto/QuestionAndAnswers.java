package com.quiz.sample.dto;

public class QuestionAndAnswers {

    private String question;

    private String solution;

    private String userAnswer;

    public QuestionAndAnswers() {

    }

    public QuestionAndAnswers(String question, String solution, String userAnswer) {
        this.question = question;
        this.solution = solution;
        this.userAnswer = userAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
