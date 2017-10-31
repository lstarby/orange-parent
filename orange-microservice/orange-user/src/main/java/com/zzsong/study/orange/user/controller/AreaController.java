package com.zzsong.study.orange.user.controller;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.Area;
import com.zzsong.study.orange.common.pojo.table.City;
import com.zzsong.study.orange.common.pojo.table.Province;
import com.zzsong.study.orange.user.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zzsong on 2017/10/30.
 */
@Slf4j
@RestController
public class AreaController {

    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/addProvince")
    public Result<String> addProvince(@RequestBody List<Province> provinces){
        Result<String> result = areaService.addProvince(provinces);
        log.debug("addProvince : result = {}", result.toString());
        return result;
    }

    @PostMapping("/addCity")
    public Result<String> addCity(@RequestBody List<City> cities) {
        Result<String> result = areaService.addCity(cities);
        log.debug("addCity : result = {}", result.toString());
        return result;
    }

    @PostMapping("/addArea")
    public Result<String> addArea(@RequestBody List<Area> areas) {
        Result<String> result = areaService.addArea(areas);
        log.debug("addArea : result = {}", result.toString());
        return result;
    }
}


