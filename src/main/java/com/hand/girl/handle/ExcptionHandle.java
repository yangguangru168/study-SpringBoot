package com.hand.girl.handle;

import com.hand.girl.entity.Msg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExcptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Msg handle(Exception e){
        if (e instanceof GirlExcption) {
            GirlExcption girlExcption = (GirlExcption) e;
            return new Msg(girlExcption.getCode(),e.getMessage());
        }else {
            return new Msg(-1,"系统异常");
        }
    }
}
