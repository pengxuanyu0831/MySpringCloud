package com.peng.xlogserver.controller;

import com.peng.xlogserver.aspect.xlogserver;
import com.peng.xlogserver.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/02/09 15:20
 */
@RestController
public class StudentController {

    @RequestMapping
    @xlogserver(description = "学生信息")
    public String info(){
        return "welcome to our school";
    }

    @GetMapping("/getStudent/{id}")
    @xlogserver(description = "获取学生id")
    public StudentServiceImpl getStudent(@PathVariable("id") int id){
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentid(22);
        studentService.setStudentname("张三");
        studentService.setStudentsex("男");
        return studentService;
    }
}
