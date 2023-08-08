package com.luxness.facotry;

import com.luxness.bean.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private ConcurrentHashMap<String, Object> singletons;
    @Override
    public void registerSingleton(BeanDefinition beanDefinition) {

    }

    @Override
    public Object getSingleton(String name) {
        return this.singletons.get(name);
    }
}
