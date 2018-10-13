package com.hand.girl.handle;

import com.hand.girl.girlenum.ResultEnum;
import lombok.Data;

@Data
public class GirlExcption extends RuntimeException {
    private Integer code;
    public GirlExcption(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
