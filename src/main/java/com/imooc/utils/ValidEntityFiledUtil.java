package com.imooc.utils;

import com.imooc.exception.SellException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * @Auther: cmy
 * @Date: 2018/9/28 08:48
 * @Description:
 */
public class ValidEntityFiledUtil {
    public static void valid(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuffer sb=new StringBuffer();
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                sb.append(((FieldError)objectError).getField()+" : ").append(objectError.getDefaultMessage());
            }
            throw new SellException(500,sb.toString());
        }
    }


}
