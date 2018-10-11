package com.imooc.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: cmy
 * @Date: 2018/10/10 14:14
 * @Description:
 */
public class EnumCheckValidator implements ConstraintValidator<EnumCheck,Object> {

    private EnumCheck enumCheck;


    @Override
    public void initialize(EnumCheck constraintAnnotation) {
            this.enumCheck=enumCheck;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value==null){
            return this.enumCheck.required()?false:true;
        }

        Boolean result = Boolean.FALSE;

        Class<?> valueClass = value.getClass();

        try {
            Method method = this.enumCheck.enumClass().getMethod(this.enumCheck.enumMethod(), valueClass);
            result=(Boolean) method.invoke(null, value);
            result=result==null?false:result;
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            return result;
        }

    }
}
