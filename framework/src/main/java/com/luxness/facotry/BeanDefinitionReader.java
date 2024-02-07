package com.luxness.facotry;

import com.luxness.io.Resource;

/**
 * top interface for loading bean definition into system
 * and work with Resource to get InputStream of xml file
 */
public interface BeanDefinitionReader {
    int loadBeanDefinitions(Resource resource);
    int loadBeanDeifnitions(Resource... resources);
}
