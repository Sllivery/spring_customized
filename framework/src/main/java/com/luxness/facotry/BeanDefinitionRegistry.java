package com.luxness.facotry;

import com.luxness.bean.BeanDefinition;

/**
 * top interface for add BeanDefition object into collection
 * It's different from SingletonBeanRegistry
 * This for object BeanDefition
 * Another one is for actual created object
 *
 * This class would work with BeanDefinitionReader for create a BeanDefinition
 */
public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanName);
}
