package com.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ribbon")
public class Ribbon {
    private static final String URL ="http://SERVICE1";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/go")
    public List helloList(){
        return restTemplate.getForObject(URL+"/service1/helloList",List.class);
    }
    @GetMapping("/test")
    public List hello(){
        return restTemplate.getForObject(URL+"/service1/tset",List.class);
    }



}
