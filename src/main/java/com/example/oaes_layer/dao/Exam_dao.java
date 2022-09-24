package com.example.oaes_layer.dao;

import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.util.DbData;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Exam_dao implements ExamAPI{
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public boolean addExam(Exam dto) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "Insert into exam(exam_code,exam_name,exam_date,start_time,end_time,exam_description) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, dto.getExam_code());
            ps.setString(2, dto.getExam_name());
            ps.setDate(3, new java.sql.Date(dto.getExam_date().getTime()));
            ps.setString(4, dto.getStart_time());
            ps.setString(5, dto.getEnd_time());
            ps.setString(6, dto.getExam_description());
            if(ps.executeUpdate()>0) {
                flag=true;
            }
        } catch (Exception e) {
            System.out.println("Exception in addUser : e");
        } finally {
            ps = null;
            con = null;
            return flag;
        }
    }

    public boolean updateExam(Exam exam,int exam_id) {
        boolean flag = false;
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "update exam set exam_code=?,exam_name=?,exam_date=?,start_time=?,end_time=?,exam_description=? where exam_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, exam.getExam_code() );
            ps.setString(2, exam.getExam_name());
            ps.setDate(3, new java.sql.Date(exam.getExam_date().getTime()));
            ps.setString(4, exam.getStart_time());
            ps.setString(5, exam.getEnd_time());
            ps.setString(6, exam.getExam_description());
            ps.setInt(7, exam_id);
            if(ps.executeUpdate()>0) {
                flag=true;
            }
        } catch (Exception e) {
            System.out.println("Exception in updateUser : "+e);
        } finally {
            rs=null;
            ps = null;
            con = null;
            return flag;
        }
    }

    public List<Exam> viewExam(String exam_code) {
        List<Exam> ans = new ArrayList<Exam>();
        try {
            if(con == null) {
                con = DbData.getConnection();
            }
            String query = "select * from exam where exam_code = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, exam_code);
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
