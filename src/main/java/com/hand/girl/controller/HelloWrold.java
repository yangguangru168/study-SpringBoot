package com.hand.girl.controller;

import com.hand.girl.entity.Girlproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWrold {
    @Autowired
    private Girlproperties girlproperties;
    @GetMapping(value = "/hello")
    public String sayHello(@RequestParam("id") Integer id ){
        return "id"+id;
        //return "hello 你好!"+girlproperties.getCupSize()+" >>>"+girlproperties.getAge();
    }
}
