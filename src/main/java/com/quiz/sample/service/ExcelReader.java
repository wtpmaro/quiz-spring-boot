package com.quiz.sample.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.quiz.sample.entity.Questions;
import com.quiz.sample.repository.QuestionsRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.poi.ss.usermodel.WorkbookFactory.*;


@Service
public class ExcelReader {


@Autowired
QuestionsRepository questionsRepository;

    public Workbook workbook (String fileName) throws IOException, InvalidFormatException {
        Workbook workbook = create (new File(fileName));
        return workbook;
    }

    public Sheet sheet (String filename) throws IOException, InvalidFormatException {
        Sheet sheet = workbook(filename).getSheetAt(0);
        return sheet;
    }

    public List<String>  questionsAndAnswers(DataFormatter dataFormatter,Iterator<Row> rowIterator ) {

        int count = 0;

        List<String> list = new ArrayList<String>();
        Questions question = new Questions();


        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            count += 1;

            int countColumn = 0;

            Iterator<Cell> cellIterator = row.cellIterator();

            String kkd = "";

            while (cellIterator.hasNext()) {


                Cell cell = cellIterator.next();

                String cellValue = dataFormatter.formatCellValue(cell);

                kkd+=cellValue+";";

                if (countColumn ==1) {
                    list.add(kkd);
                }
                countColumn += 1;


            }
        }

return list;
    }



    public List<String> readExcel(String fileName) throws IOException, InvalidFormatException {


        Sheet sheet = sheet(fileName);

        Iterator<Row> rowIterator = sheet.rowIterator();

        DataFormatter dataFormatter = new DataFormatter();

        int count = 0;

        return questionsAndAnswers(dataFormatter, rowIterator);

    }

}


