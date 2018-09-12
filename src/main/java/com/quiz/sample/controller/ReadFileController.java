package com.quiz.sample.controller;


import com.quiz.sample.entity.Questions;
import com.quiz.sample.repository.QuestionsRepository;
import com.quiz.sample.service.ExcelReader;
import com.quiz.sample.service.ExcelSave;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/readfile")
public class ReadFileController {

    Questions questions = new Questions();

    @Autowired
    QuestionsRepository questionsRepository;


    @Autowired
    ExcelReader excelReader;

    @Autowired
    ExcelSave excelSave;



    @GetMapping("")
    public String form() {
        return "excelFileReader";
    }

    @PostMapping("")
    @ResponseBody
    public String readExcelFile(@RequestParam String fileName) throws IOException, InvalidFormatException{


        try {


            List<String> list=  excelReader.readExcel(fileName);

            excelSave.saveExcel(list);

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
