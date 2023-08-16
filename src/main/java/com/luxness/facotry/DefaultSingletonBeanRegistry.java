package com.luxness.facotry;

import com.luxness.bean.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private ConcurrentHashMap<String, Object> singletons;

    /**
     * Scan the bean definitions and put those singletons Bean into map
     * The map should be concurrent safe
     * Because we can view Beanfactory as a container, there wouldn't be only one thread that calls getBean method
     * @param beanDefinition
     */
    @Override
    public void registerSingleton(BeanDefinition beanDefinition) {

    }

    @Override
    public Object getSingleton(String name) {
        return this.singletons.get(name);
    }
}
