package com.luxness.DAO;

import com.luxness.entity.TestEntity;

public class TestDao {
    public TestEntity simulateQuery() {
        TestEntity entity = new TestEntity(1, "david", "male");
        return entity;
    }
}
