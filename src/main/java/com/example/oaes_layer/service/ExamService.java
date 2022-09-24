package com.example.oaes_layer.service;

import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.dao.ExamVisitor;
import com.example.oaes_layer.dao.ExamVisitorImpl;
import com.example.oaes_layer.dao.Exam_Dao_Proxy;
import com.example.oaes_layer.dao.Exam_dao;

import java.util.List;

public class ExamService implements ExamServiceInterface {
    Exam_Dao_Proxy ed = new Exam_Dao_Proxy();
    public boolean addExam(Exam exam){ //called from controller
        return ed.addExam(exam); //calls the DAO method
    }
    public boolean editExam(Exam exam){ //called from controller
        return ed.updateExam(exam,exam.getExam_id()); //calls the DAO method
    }

    public List<Exam> getExams(ExamVisitor ev){ //called from controller
        return ev.viewALLExams(); //calls the DAO method
    }
    public List<Exam> getExamsAsc(ExamVisitor ev){ //called from controller
        return ev.viewALLExamsOrderByDateASC(); //calls the DAO method
    }
    public List<Exam> getExamsDesc(ExamVisitor ev){ //called from controller
        return ev.viewALLExamsOrderByDateDESC(); //calls the DAO method
    }
    public List<Exam> viewExamByCode(Exam ex){ //called from controller
        return ed.viewExam(ex.getExam_code()); //calls the DAO method
    }
    public List<Exam> viewExamByDate(String start,String end,ExamVisitor ev){ //called from controller
        return ev.viewExamByDate(start,end); //calls the DAO method
    }
}
