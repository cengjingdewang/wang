package com.service1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceFile {
    @Resource
    private RestTemplate restTemplate;
    private static final String URL ="http://localhost:9003";
    public List hello(){
        return restTemplate.getForObject(URL+"/service1/hello",List.class);
    }
}
