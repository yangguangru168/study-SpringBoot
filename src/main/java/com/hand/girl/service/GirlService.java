package com.hand.girl.service;


import com.hand.girl.girlenum.ResultEnum;
import com.hand.girl.handle.GirlExcption;
import com.hand.girl.repository.GirlRepository;
import com.hand.girl.entity.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void add(){
        Gril gril = new Gril();
        gril.setCupSize("P");
        gril.setAge(43);
        girlRepository.save(gril);

        Gril gril1 = new Gril();
        gril1.setCupSize("RTTT");
        gril1.setAge(34);
        girlRepository.save(gril1);
    }

    public void insertVarild(Gril gril) throws Exception {
        int age = gril.getAge();
        if (age <12) {
            throw  new GirlExcption(ResultEnum.M_SCHOOL);
        }else if (age>12 && age<18){
            throw new GirlExcption(ResultEnum.H_SCHOOL);
        }else {
            girlRepository.save(gril);
        }
    }
}
