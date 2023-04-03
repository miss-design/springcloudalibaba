package com.soft.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/instances")
    public List<ServiceInstance> instances(){
        List<ServiceInstance> provider = this.discoveryClient.getInstances("provider");
        return provider;
    }

//    @GetMapping("/index")
//    public String index(){
//        List<ServiceInstance> list = this.discoveryClient.getInstances("provider");
//        int index = ThreadLocalRandom.current().nextInt(list.size());
//        ServiceInstance serviceInstance = list.get(index);
//        String uri = serviceInstance.getUri() + "/index";
//        log.info("调用了端口是...{}",serviceInstance.getPort());
//        return "调用了端口为:"+serviceInstance.getPort()+"的服务，返回结果是："+this.restTemplate.getForObject(uri,String.class);
//    }

    @GetMapping("/index")
    public String index(){
        return this.restTemplate.getForObject("http://provider/index",String.class);
    }
}
