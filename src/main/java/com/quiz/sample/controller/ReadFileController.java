package com.quiz.sample.controller;

import com.quiz.sample.entity.Questions;
import com.quiz.sample.repository.QuestionsRepository;
import com.quiz.sample.service.ExcelReader;
import com.quiz.sample.service.ExcelSave;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
        return "view/form/excelFileReader";
    }

    @PostMapping("")
    public String readExcelFile(@RequestParam String fileName) throws IOException, InvalidFormatException{


        try {
            List<String> list=  excelReader.readExcel(fileName);
            excelSave.saveExcel(list);
            return "view/form/excelFileSuccess";

        } catch (IOException e) {
            e.printStackTrace();
            return "view/form/excelFileException";

        } catch (InvalidFormatException e) {
            e.printStackTrace();
            return "view/form/excelFileException";
        }
    }
}
