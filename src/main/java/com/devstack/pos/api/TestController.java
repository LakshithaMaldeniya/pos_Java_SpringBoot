package com.devstack.pos.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pos/test")
public class TestController {

    @GetMapping
    public String testApplication(){
        String port="8001";
        String name="my-pos";

        return name+" running in port number "+port;

    }
}
