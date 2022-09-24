package com.example.oaes_layer.dao;

import com.example.oaes_layer.bean.Exam;

import java.util.ArrayList;
import java.util.List;

public class Exam_Dao_Proxy implements ExamAPI {
    public Exam_dao ex = new Exam_dao();
    public boolean addExam(Exam dto){
        if(dto == null){
            return false;
        }
        return ex.addExam(dto);
    }
    public boolean updateExam(Exam exam,int exam_id){
        if(exam == null || exam_id < 0){
            return false;
        }
        return ex.updateExam(exam,exam_id);
    }
    public List<Exam> viewExam(String exam_code){
        if(exam_code == null){
            return new ArrayList<>();
        }
        return ex.viewExam(exam_code);
    }
}

