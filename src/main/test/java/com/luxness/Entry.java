package com.luxness;

import com.luxness.DAO.TestDao;
import com.luxness.bean.BeanDefinition;
import com.luxness.entity.TestEntity;
import com.luxness.facotry.BeanFactory;
import com.luxness.services.TestService;
import org.junit.Test;

import java.net.URL;

public class Entry {
    @Test
    public void testGetBean() {
        //original version needs to do some extra job to get wanted service
        TestDao testDao = new TestDao();
        TestService testService = new TestService(testDao);
        TestEntity entity = testService.queryTestEntity();

        System.out.println(entity);
        //test guy only need to perform the code below
        //TestService testService = (TestService) ApplicationContext.getBean("testservice"); this "testservice" needs to correspond to config file's id
    }
}
