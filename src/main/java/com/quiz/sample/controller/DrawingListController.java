package com.quiz.sample.controller;

import com.quiz.sample.dto.QuestionListDto;
import com.quiz.sample.entity.Questions;
import com.quiz.sample.repository.QuestionsRepository;
import com.quiz.sample.service.Drawing;
import com.quiz.sample.service.Result;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/quiz")
@Controller
public class DrawingListController {

    @Autowired
    QuestionsRepository questionsRepository;

    @Autowired
    Drawing drawing;

    @Autowired
    Result result;

    @GetMapping("")
    public String list(Model model) {

        QuestionListDto questionListDto = new QuestionListDto(drawing.dtoListCreation());

        model.addAttribute("questions", questionListDto);
        return "view/form/questionsList";
    }

    @PostMapping("")
    public String list1(@ModelAttribute QuestionListDto questionListDto, Model model) {

        int userResult = result.finalResult(questionListDto);

        model.addAttribute("result",userResult);
        model.addAttribute("question",questionListDto);

        return "view/form/questionsAndAnswers";
    }


    }


