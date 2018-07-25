package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yu.pengjun <yu.pengjun@chinaott.net> on 2018/6/19
 */
@Data
public class Student implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private Integer sex;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;
}
