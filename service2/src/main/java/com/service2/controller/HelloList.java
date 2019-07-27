package com.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service1")
public class HelloList {
    @GetMapping("/helloList")
    public List helloList(){

        List list =new ArrayList();
        list.add("我的名字");
        return list;
    }
    @GetMapping("/hello")
    public List hello(){
        List<Integer> list =new ArrayList();
        list.add(88888);
        return list;
    }
    @GetMapping("/tset")
    public List tset(){
        List<Integer> list =new ArrayList();
        list.add(88888);
        return list;
    }
}
