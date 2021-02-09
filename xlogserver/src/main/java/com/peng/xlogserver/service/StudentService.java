package com.peng.xlogserver.service;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/02/09 15:18
 */
public class StudentService {
    String studentname;
    String studentsex;
    int studentid;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentsex() {
        return studentsex;
    }

    public void setStudentsex(String studentsex) {
        this.studentsex = studentsex;
    }
}
