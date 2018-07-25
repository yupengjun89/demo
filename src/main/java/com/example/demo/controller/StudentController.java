package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yu.pengjun <yu.pengjun@chinaott.net> on 2018/6/19
 */
@RestController
@RequestMapping("/stu")
@Log4j
@EnableDiscoveryClient
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/hello")
    public String say() {
        log.info("===<hello>===");
        log.info(discoveryClient.getServices());
        ServiceInstance serviceInstance = loadBalancerClient.choose("owl-mgr");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/cloud/mgr/psChannel/hi";
        log.info(url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping(value = "/hi")
    public String say1() {
        log.info("===<hi>===");
        return restTemplate.getForObject("http://127.0.0.1:8081/stu/list", String.class);
    }

    @GetMapping(value = "/list")
    public List<Student> findStudentList() {
        log.info("===<list>===");
        return studentService.findStudentList();
    }

}
