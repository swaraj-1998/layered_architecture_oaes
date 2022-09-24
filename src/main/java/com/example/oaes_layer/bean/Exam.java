package com.example.oaes_layer.bean;

import java.util.Date;

public class Exam {
    private int exam_id;
    private String exam_code;
    private String exam_name;
    private Date exam_date;
    private String start_time;

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    private String end_time;
    private String exam_description;
    public Exam(){}

    public Exam(int exam_id, String exam_code, String exam_name, Date exam_date, String start_time, String end_time, String exam_description) {
        this.exam_id = exam_id;
        this.exam_code = exam_code;
        this.exam_name = exam_name;
        this.exam_date = exam_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.exam_description = exam_description;
    }

    public Exam(String exam_code, String exam_name, Date exam_date, String start_time, String end_time, String exam_description) {
        this.exam_code = exam_code;
        this.exam_name = exam_name;
        this.exam_date = exam_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.exam_description = exam_description;
    }

    public String getExam_code() {
        return exam_code;
    }

    public void setExam_code(String exam_code) {
        this.exam_code = exam_code;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public Date getExam_date() {
        return exam_date;
    }

    public void setExam_date(Date exam_date) {
        this.exam_date = exam_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getExam_description() {
        return exam_description;
    }

    public void setExam_description(String exam_description) {
        this.exam_description = exam_description;
    }
}


