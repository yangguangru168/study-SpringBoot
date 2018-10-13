package com.hand.girl.controller;

import com.hand.girl.entity.Msg;
import com.hand.girl.repository.GirlRepository;
import com.hand.girl.service.GirlService;
import com.hand.girl.entity.Gril;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlService girlService;
    @Autowired
    private GirlRepository girlRepository;
    @GetMapping("/findll")
    public Msg<Gril> findAll(){
        logger.info("啦啦啦");
        return new Msg(girlRepository.findAll());
    }
    @PostMapping("/add")
    public Msg<Gril> addGirl(@Valid Gril gril, BindingResult result){
        if (result.hasErrors()) {
            return new Msg(0,result.getFieldError().getDefaultMessage());
        }else {
            gril.setCupSize(gril.getCupSize());
            gril.setAge(gril.getAge());
            return new Msg(girlRepository.save(gril));
        }

    }
    @GetMapping(value = "/find/{id}")
    public Gril selectId(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }
    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Integer id){
             girlRepository.delete(id);
    }
    @PutMapping(value = "update/{id}")
    public Gril update(@PathVariable("id") Integer id,
                       @RequestParam("cupSize") String cupSize,
                       @RequestParam("age") Integer age){
        Gril gril = new Gril();
        gril.setId(id);
        gril.setCupSize(cupSize);
        gril.setAge(age);
        return girlRepository.save(gril);
    }
    @PostMapping(value = "addtwo")
    public void addtwo(){
        girlService.add();
    }

    @PostMapping(value = "insert")
    public void insert(Gril gril) throws Exception {
        girlService.insertVarild(gril);
    }
}
