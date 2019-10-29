package com.bjq.demo;

import com.bjq.demo.dao.AreaDao;
import com.bjq.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> list= areaDao.queryArea();
        assertEquals(2,list.size());
    }

    @Test
    public void queryAreaById() {
    }

    @Test
    public void insertArea() {
    }

    @Test
    public void updateArea() {
    }

    @Test
    public void deleteArea() {
    }
}
