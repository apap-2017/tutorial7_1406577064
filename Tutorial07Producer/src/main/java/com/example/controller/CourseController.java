package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.service.CourseService;

@Controller
public class CourseController
{
    @Autowired
    CourseService courseDAO;
    
    //Latihan Tutorial 5 nomor 2. Menampilkan data course.
    @RequestMapping("/course/view/{id_course}")
    public String viewCourse (Model model, @PathVariable(value = "id_course") String id)
    {
        CourseModel course = courseDAO.selectCourse(id);

        if (course != null) {
            model.addAttribute ("course", course);
            return "view-course";
        } else {
            model.addAttribute ("id", id);
            return "not-found-course";
        }
    }
}
