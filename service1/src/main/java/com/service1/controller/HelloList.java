package com.service1.controller;

import com.service1.service.ServiceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service1")
public class HelloList {

    @Autowired
    private ServiceFile serviceFile;

    @GetMapping("/helloList")
    public List helloList(){
        List list =new ArrayList();
        list.add("你的名字");
        return list;
    }
    @GetMapping("/tset")
    public List test(){
        List<Integer> list =new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(3);
        }
        list.addAll(serviceFile.hello());
        return list;
    }
}
