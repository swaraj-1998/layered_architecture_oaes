package com.example.oaes_layer.dao;

import com.example.oaes_layer.bean.Exam;
import java.util.List;

public interface ExamAPI {
    public boolean addExam(Exam dto);
    public boolean updateExam(Exam exam,int exam_id);
    public List<Exam> viewExam(String exam_code);
}
