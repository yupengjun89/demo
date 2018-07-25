package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yu.pengjun <yu.pengjun@chinaott.net> on 2018/6/19
 */
@Service
@Log4j
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findStudentList() {
        List<Student> list = studentMapper.findStudentList();
        return list;
    }
}
