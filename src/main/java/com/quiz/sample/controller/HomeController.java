package com.quiz.sample.controller;


import com.quiz.sample.entity.Questions;
import com.quiz.sample.repository.QuestionsRepository;
import com.quiz.sample.service.ExcelReader;
import com.quiz.sample.service.ExcelSave;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    Questions questions = new Questions();

    @Autowired
    QuestionsRepository questionsRepository;


    @Autowired
    ExcelReader excelReader;

    @Autowired
    ExcelSave excelSave;


    @GetMapping
    @ResponseBody
    public String questionForm() throws IOException, InvalidFormatException{


        try {


            List<String> list=  excelReader.readExcel();

            excelSave.saveExcel(list);

/*            String [] compared = list.get(1).split(";");

            questions.setQuestions(compared[0]);
            questions.setAnswer(compared[1]);

            questionsRepository.save(questions);*/

            return "Zapisanie zakończone sukcesem";

        } catch (IOException e) {
            e.printStackTrace();

            throw new IOException (e);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new InvalidFormatException("To nie jest orawudłowy firna");
        }



    }
}
