package airsoftEventRegistrationTool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatter {

    private int day;
    private int month;
    private int year;

    public LocalDateFormatter() {
    }

    public LocalDateFormatter(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static LocalDate formatDate (String input){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate date = LocalDate.parse(input , dateFormat);
        System.out.println(date);
        return date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
