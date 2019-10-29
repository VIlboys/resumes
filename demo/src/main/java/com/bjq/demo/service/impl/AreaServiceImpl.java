package com.bjq.demo.service.impl;

import com.bjq.demo.dao.AreaDao;
import com.bjq.demo.entity.Area;
import com.bjq.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
       if(area.getAreaName()!=null && !"" .equals(area.getAreaName())){
           area.setLastEditTime(new Date());
           area.setCreateTime(new Date());
           try {
               int effectdNum = areaDao.insertArea(area);
               if(effectdNum>0)
               {
                   return  true;
               }
               else {
                   throw  new RuntimeException("插入信息错误");
               }
           }catch (Exception e)
           {
               throw  new RuntimeException("插入信息错误"+e.getMessage());
           }
       }else {
            throw  new RuntimeException("内容不能为空");
       }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId()!=null && !"" .equals(area.getAreaName())){
            area.setLastEditTime(new Date());
            try {
                int effectdNum = areaDao.updateArea(area);
                if(effectdNum>0)
                {
                    return  true;
                }
                else {
                    throw  new RuntimeException("更新插入信息错误");
                }
            }catch (Exception e)
            {
                throw  new RuntimeException("更新信息错误"+e.getMessage());
            }
        }else {
            throw  new RuntimeException("更新内容不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areId) {
        if(areId>0){
            try {
                int effectedNum = areaDao.deleteArea(areId);
                if (effectedNum>0){
                    return true;
                }
                else {
                    throw new RuntimeException("删除信息失败");
                }
            }catch (Exception e)
            {
                throw new RuntimeException("删除信息失败"+e.getMessage());
            }
        }
        else {
            throw  new RuntimeException("区域Id不能为空");
        }
    }
}
