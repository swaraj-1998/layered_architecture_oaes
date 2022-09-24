package com.example.oaes_layer.service;

import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.dao.ExamVisitor;

import java.util.List;

public interface ExamServiceInterface {
    public List<Exam> getExams(ExamVisitor ev);
    public List<Exam> getExamsAsc(ExamVisitor ev);
    public List<Exam> getExamsDesc(ExamVisitor ev);
    public List<Exam> viewExamByDate(String start,String end,ExamVisitor ev);
}
