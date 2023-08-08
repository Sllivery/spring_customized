package com.luxness.facotry;

import com.luxness.bean.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        //if it exists, return it directly
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        //if not
        BeanDefinition bd = getBeanDefinition(name);
        if (bd == null) {
            return null;
        }
        //if it's a singlton, delegate the job to singletonBeanRegistry
        if ("singleton".equals(bd.getScope())) { //singleton
            bean = createBean(bd);
        } else if ("prototype".equals(bd.getScope())) { //prototype
            bean = createBean(bd);
        }

        return bean;
    }

    public abstract BeanDefinition getBeanDefinition(String name);

    public abstract Object createBean(BeanDefinition beanDefinition);
}
