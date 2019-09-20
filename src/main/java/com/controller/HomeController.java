package com.controller;


import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @author Administrator
 * 提示这是一个控制器类
 */
@Controller
public class HomeController {
    @Autowired
    StudentService studentService;

    /**
     * 首页的controller
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> student = studentService.fourth();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    /**
     * 推荐关于页面的controller
     *
     * @return
     */
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public ModelAndView recommend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recommend");
        return modelAndView;
    }

}
