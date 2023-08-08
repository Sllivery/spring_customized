package com.luxness.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    //this class is the holder for bean defined in xml
    //what do we have in xml file
    private String beanID;
    private String scope;
    private String className;
    private Class<?> classType;
    private String initMethod;
    private List<PropertyValue> propertyList = new ArrayList<>();

    public BeanDefinition(String beanID, String className) {
        this.beanID = beanID;
        this.className = className;
        this.classType = resovleClassType(className);
    }

    private Class<?> resovleClassType(String className) {
        try {
            Class<?> aClass = Class.forName(className);
            return aClass;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void addPropertyValues(PropertyValue propertyValue) {
        propertyList.add(propertyValue);
    }

    public String getBeanID() {
        return beanID;
    }

    public void setBeanID(String beanID) {
        this.beanID = beanID;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class<?> getClassType() {
        return classType;
    }

    public void setClassType(Class<?> classType) {
        this.classType = classType;
    }

    public String getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(String initMethod) {
        this.initMethod = initMethod;
    }

    public List<PropertyValue> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<PropertyValue> propertyList) {
        this.propertyList = propertyList;
    }
}
