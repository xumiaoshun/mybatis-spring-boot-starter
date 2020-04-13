package com.rockcode.mybatis.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AccountImportBeanDefinitionRegistrar.class)
public @interface AccountMapperScan {

    String[] value() default {};

    String[] basePackages() default {};

}
