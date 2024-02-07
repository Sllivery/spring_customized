package services;

import com.luxness.DAO.TestDao;
import com.luxness.entity.TestEntity;

public class TestService {
    private TestDao testDao;

    public TestService(TestDao testDao) {
        this.testDao = testDao;
    }

    public TestEntity queryTestEntity() {
        return testDao.simulateQuery();
    }
}
