package com.imooc.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Auther: cmy
 * @Date: 2018/10/10 14:08
 * @Description:
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EnumCheckValidator.class})
public @interface EnumCheck {

    /**
     * * 是否必填 默认是必填的
     * * @return */
    boolean required() default true;
    /**
     *  * 验证失败的消息 *
     *  @return */
    String message() default "枚举的验证失败";
    /**
     * * 分组的内容
     * * @return
     * */
    Class<?>[] groups() default {};
    /** *
     *  错误验证的级别 *
     *  @return
     *  */
    Class<? extends Payload>[] payload() default {};
    /** * 枚举的Class *
     * @return
     * */
    Class<? extends Enum<?>> enumClass();
    /** *
     *  枚举中的验证方法 *
     *  @return
     *  */
    String enumMethod() default "validation";

}
