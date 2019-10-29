package com.bjq.demo.dao;

import com.bjq.demo.entity.Area;

import java.util.List;

public interface AreaDao {

    List<Area> queryArea();

    Area queryAreaById(int id);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int areaId);
}
