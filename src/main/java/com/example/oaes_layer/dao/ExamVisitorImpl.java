package com.example.oaes_layer.dao;

import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.util.DbData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamVisitorImpl implements ExamVisitor{
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public List<Exam> viewALLExams() {
        List<Exam> ans = new ArrayList<Exam>();
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from exam";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Exam dto = null;
                dto = new Exam();
                dto.setExam_code(rs.getString("exam_code"));
                dto.setExam_name(rs.getString("exam_name"));
                dto.setExam_date(rs.getDate("exam_date"));
                dto.setStart_time(rs.getString("start_time"));
                dto.setEnd_time(rs.getString("end_time"));
                dto.setExam_description(rs.getString("exam_description"));
                ans.add(dto);
            }
            return ans;
        } catch (Exception e) {
            System.out.println("Exception in viewUser : "+e);
        } finally {
            rs=null;
            ps = null;
            con = null;
            return ans;
        }
    }

    public List<Exam> viewALLExamsOrderByDateDESC() {
        List<Exam> ans = new ArrayList<Exam>();
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from exam order by exam_date DESC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Exam dto = null;
                dto = new Exam();
                dto.setExam_code(rs.getString("exam_code"));
                dto.setExam_name(rs.getString("exam_name"));
                dto.setExam_date(rs.getDate("exam_date"));
                dto.setStart_time(rs.getString("start_time"));
                dto.setEnd_time(rs.getString("end_time"));
                dto.setExam_description(rs.getString("exam_description"));
                ans.add(dto);
            }
            return ans;
        } catch (Exception e) {
            System.out.println("Exception in viewUser : "+e);
        } finally {
            rs=null;
            ps = null;
            con = null;
            return ans;
        }
    }

    public List<Exam> viewALLExamsOrderByDateASC() {
        List<Exam> ans = new ArrayList<Exam>();
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from exam order by exam_date ASC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Exam dto = null;
                dto = new Exam();
                dto.setExam_code(rs.getString("exam_code"));
                dto.setExam_name(rs.getString("exam_name"));
                dto.setExam_date(rs.getDate("exam_date"));
                dto.setStart_time(rs.getString("start_time"));
                dto.setEnd_time(rs.getString("end_time"));
                dto.setExam_description(rs.getString("exam_description"));
                ans.add(dto);
            }
            return ans;
        } catch (Exception e) {
            System.out.println("Exception in viewUser : "+e);
        } finally {
            rs=null;
            ps = null;
            con = null;
            return ans;
        }
    }

    public List<Exam> viewExamByDate(String sd1 , String sd2) {
        Date d1= null , d2 = null;
        try {
            d1 = new SimpleDateFormat("dd/MM/yyyy").parse(sd1);
            d2 = new SimpleDateFormat("dd/MM/yyyy").parse(sd2);
        }
        catch(Exception ex){}
        List<Exam> ans = new ArrayList<Exam>();
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from exam where exam_date between ? and ?";
            ps = con.prepareStatement(query);
            ps.setDate(1,new java.sql.Date(d1.getTime()));
            ps.setDate(2,new java.sql.Date(d2.getTime()));
            rs = ps.executeQuery();
            while(rs.next()) {
                Exam dto = null;
                dto = new Exam();
                dto.setExam_code(rs.getString("exam_code"));
                dto.setExam_name(rs.getString("exam_name"));
                dto.setExam_date(rs.getDate("exam_date"));
                dto.setStart_time(rs.getString("start_time"));
                dto.setEnd_time(rs.getString("end_time"));
                dto.setExam_description(rs.getString("exam_description"));
                ans.add(dto);
            }
            return ans;
        } catch (Exception e) {
            System.out.println("Exception in viewUser : "+e);
        } finally {
            rs=null;
            ps = null;
            con = null;
            return ans;
        }
    }
}
