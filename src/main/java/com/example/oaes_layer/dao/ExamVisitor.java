package com.example.oaes_layer.dao;

import com.example.oaes_layer.bean.Exam;

import java.util.List;

public interface ExamVisitor {
    public List<Exam> viewALLExams();
    public List<Exam> viewALLExamsOrderByDateDESC();
    public List<Exam> viewALLExamsOrderByDateASC();
    public List<Exam> viewExamByDate(String sd1 , String sd2);


}
