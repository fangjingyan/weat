package ca.uwaterloo.ece651.controllers;

import ca.uwaterloo.ece651.enums.Day;
import ca.uwaterloo.ece651.enums.Meal;
import ca.uwaterloo.ece651.models.Record;
import ca.uwaterloo.ece651.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

@Controller
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @RequestMapping("/new_record")
    public int uploadRecord(@RequestParam(value = "Uid", defaultValue = "") String uid,
                            @RequestParam(value = "Date", defaultValue = "") String date,
                            @RequestParam(value = "Day", defaultValue = "") String day,
                            @RequestParam(value = "Meal", defaultValue = "") String meal,
                            @RequestParam(value = "Content", defaultValue = "") String content) throws ParseException{

        Record record = new Record();

        if ("".equals(uid)) {
            return 0;
        }
        else {
            record.setUid(Long.valueOf(uid));
        }

        if ("".equals(date)) {
            return 0;
        }
        else {
            Date inputDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            record.setDate(inputDate);
        }

        if ("".equals(day)) {
            return 0;
        }
        else {
            if ("Monday".equals(day)) {
                record.setDay(Day.MONDAY);
            }
            else if ("Tuesday".equals(day)) {
                record.setDay(Day.TUESDAY);
            }
            else if ("Wednesday".equals(day)) {
                record.setDay(Day.WEDNESDAY);
            }
            else if ("Thursday".equals(day)) {
                record.setDay(Day.THURSDAY);
            }
            else if ("Friday".equals(day)) {
                record.setDay(Day.FRIDAY);
            }
            else if ("Saturday".equals(day)) {
                record.setDay(Day.SATURDAY);
            }
            else if ("Sunday".equals(day)) {
                record.setDay(Day.SUNDAY);
            }
            else {
                return 0;
            }
        }

        if ("".equals(meal)) {
            return 0;
        }
        else {
            if ("Breakfast".equals(meal)) {
                record.setMeal(Meal.BREAKFAST);
            }
            else if ("Lunch".equals(meal)) {
                record.setMeal(Meal.LUNCH);
            }
            else if ("Dinner".equals(meal)) {
                record.setMeal(Meal.DINNER);
            }
            else {
                return 0;
            }
        }

        record.setContent(content);

        recordRepository.save(record);

        return 1;
    }

    @RequestMapping("/get_records")
    public List<Record> getRecord(@RequestParam(value = "Uid", defaultValue = "") String uid) {
        if ("".equals(uid)) {
            return null;
        }
        return recordRepository.findByUid(Long.valueOf(uid));
    }
}
