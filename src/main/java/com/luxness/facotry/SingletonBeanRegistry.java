package com.luxness.facotry;

import com.luxness.bean.BeanDefinition;

public interface SingletonBeanRegistry {
    //register a singleton bean into map
    void registerSingleton(BeanDefinition beanDefinition);

    //get a singleton bean from map
    Object getSingleton(String name);
}
