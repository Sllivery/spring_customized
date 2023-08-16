package com.luxness.facotry;

import com.luxness.bean.BeanDefinition;
import com.luxness.bean.PropertyValue;
import com.luxness.bean.RuntimeBeanRerference;
import com.luxness.bean.TypeStringValue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Fill up the details
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    public Object createBean(BeanDefinition beanDefinition) {
        //1.Intialize the target bean
        Object bean = createBeanInstance(beanDefinition);
        //2.inject required dependency
        setBean(bean, beanDefinition);
        //TODO 3.create and return bean;
        initializeBean(bean, beanDefinition);
        return null;
    }

    private void initializeBean(Object bean, BeanDefinition beanDefinition) {
        //TODO invoke initializingBean's afterPropertiesSet
        //invoke method that corresponds to init-method property
        String initMethod = beanDefinition.getInitMethod();
        if (initMethod == null || initMethod.equals("")) {
            return;
        }
        try {
            Class<?> classType = beanDefinition.getClassType();
            Method declaredMethod = classType.getDeclaredMethod(initMethod);
            declaredMethod.invoke(bean);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private Object createBeanInstance(BeanDefinition beanDefinition) {
        //TODO create by static factory
        //TODO create by instance factory
        //create by constructor
        Object o = null;
        try {
            String className = beanDefinition.getClassName();
            Constructor<?> constructor = Class.forName(className).getConstructor();
            o = constructor.newInstance();
        } catch (NoSuchMethodException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        return o;
    }

    private void setBean(Object bean, BeanDefinition beanDefinition) {
        List<PropertyValue> propertyValueList = beanDefinition.getPropertyList();
        Class<?> beanClass = bean.getClass();
        for (PropertyValue propertyValue : propertyValueList) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            Object valueToUse = null;
            valueToUse = resolveValue(value);

            //fill up the target bean
            setValue(bean, name, valueToUse);
            Class<?> propertyClass = propertyValue.getClass();
        }
    }

    private Object resolveValue(Object value) {
        if (value instanceof RuntimeBeanRerference) {
            RuntimeBeanRerference runtimeBeanRerference = (RuntimeBeanRerference) value;
            String ref = runtimeBeanRerference.getRef();
            //TODO Circular dependency problem
            return getBean(ref);
        } else if (value instanceof TypeStringValue) {
            TypeStringValue typeStringValue = (TypeStringValue) value;
            String stringValue = typeStringValue.getValue();
            Class<?> aClass = typeStringValue.getTargetType();
            if (aClass != null) {
                if (aClass == Integer.class) {
                    return Integer.parseInt(stringValue);
                } else if (aClass == Double.class) {
                    return Double.parseDouble(stringValue);
                } else if (aClass == String.class) {
                    return stringValue;
                }
            } else {
                return stringValue;
            }
        }
        return null;
    }

    private void setValue(Object bean, String name, Object valueToUse) {
        try {
            Class<?> beanClass = bean.getClass();
            Field field = beanClass.getField(name);
            field.setAccessible(true);
            field.set(bean, valueToUse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
