package com.bjq.demo.controller;

import com.bjq.demo.entity.Area;
import com.bjq.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping("/listarea")
    public Map<String,Object> listArea(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        map.put("areaList",list);
        return map;
    }

    @GetMapping("/getareabyid")
    public Map<String,Object> getareabyid(Integer areaId){
        Map<String,Object> map = new HashMap<String, Object>();
        Area area = areaService.getAreaById(areaId);
        map.put("area",area);
        return map;
    }

    @PostMapping("/addarea")
    public Map<String,Object> addarea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",areaService.addArea(area));
        return map;
    }
    @PostMapping("/modifyarea")
    public Map<String,Object> modifyarea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",areaService.modifyArea(area));
        return map;
    }

    @GetMapping("/deleteArea")
    public Map<String,Object> deleteArea (Integer areaId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",areaService.deleteArea(areaId));
        return map;
    }
}
