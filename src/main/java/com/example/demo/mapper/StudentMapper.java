package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yu.pengjun <yu.pengjun@chinaott.net> on 2018/6/19
 */
@Repository
public interface StudentMapper {

    @Select("select * from Student")
    List<Student> findStudentList();

    @Select("select name from Student where age = #{age}")
    String findByAge(int age);
}
