package com.quiz.sample.controller;

import com.quiz.sample.repository.QuestionsRepository;
import com.quiz.sample.service.Drawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/quiz")
@Controller
public class DrawingListController {

@Autowired
QuestionsRepository questionsRepository;

@Autowired
Drawing drawing;

    @GetMapping("")
    public String list(Model model) {

        model.addAttribute("questions",drawing.drawnquestions());
        return  "view/form/questionsList";
    }

    @PostMapping("")
    @ResponseBody
     public String list1 (@RequestParam(value="myParam") List<String> answers) {


        return answers.toString();
    }
}
