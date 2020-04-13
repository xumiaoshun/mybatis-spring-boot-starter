package com.rockcode.mybatis.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class AccountImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(AccountMapperScan.class.getName());
        String[] value = (String[]) annotationAttributes.get("value");
        String packages = value[0];

        AccountClassPathMapperScanner myClassPathBeanDefinitionScanner = new AccountClassPathMapperScanner(beanDefinitionRegistry);
        myClassPathBeanDefinitionScanner.registerFilters();
        myClassPathBeanDefinitionScanner.scan(packages);

//
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(AccountMapperFactoryBean.class);
//        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//        beanDefinition.getPropertyValues().add("mapperInterface", AccountMapper.class);
//        beanDefinitionRegistry.registerBeanDefinition("accountMapperFactoryBean", beanDefinition);
    }

}
