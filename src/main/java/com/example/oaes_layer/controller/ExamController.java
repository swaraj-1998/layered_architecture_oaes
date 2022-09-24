package com.example.oaes_layer.controller;


import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.dao.ExamVisitor;
import com.example.oaes_layer.dao.ExamVisitorImpl;
import com.example.oaes_layer.service.ExamService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;
@Path("exam")
public class ExamController {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response addExam(Exam exam) throws URISyntaxException {
        boolean val = new ExamService().addExam(exam); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
    @POST
    @Path("/edit")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response editExam(Exam exam) throws URISyntaxException {
        boolean val = new ExamService().editExam(exam); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }

    @POST
    @Path("/viewExamByCode")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response viewExamByCode(Exam exam) throws URISyntaxException {
        List<Exam> exams  = new ExamService().viewExamByCode(exam); //in service
        return Response.ok().entity(exams).build();
    }
    @POST
    @Path("/viewExamByDate")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response viewExamByDate(Exam exam) throws URISyntaxException {
        ExamVisitor ev = new ExamVisitorImpl();
        List<Exam> exams  = new ExamService().viewExamByDate(exam.getStart_time(),exam.getEnd_time(),ev); //in service
        return Response.ok().entity(exams).build();
    }

    @GET
    @Path("/viewAll")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response getExams() throws URISyntaxException {
        ExamVisitor ev = new ExamVisitorImpl();
        List<Exam> exams = new ExamService().getExams(ev); //in service
        return Response.ok().entity(exams).build();
    }

    @GET
    @Path("/viewAllAsc")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response getExamsAsc() throws URISyntaxException {
        ExamVisitor ev = new ExamVisitorImpl();
        List<Exam> exams = new ExamService().getExamsAsc(ev); //in service
        return Response.ok().entity(exams).build();
    }

    @GET
    @Path("/viewAllDesc")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response getExamsDesc() throws URISyntaxException {
        ExamVisitor ev = new ExamVisitorImpl();
        List<Exam> exams = new ExamService().getExamsDesc(ev); //in service
        return Response.ok().entity(exams).build();
    }

}
