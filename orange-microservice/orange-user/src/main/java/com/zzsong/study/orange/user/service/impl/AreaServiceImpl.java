package com.zzsong.study.orange.user.service.impl;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.Area;
import com.zzsong.study.orange.common.pojo.table.City;
import com.zzsong.study.orange.common.pojo.table.Province;
import com.zzsong.study.orange.user.mapper.AreaMapper;
import com.zzsong.study.orange.user.service.AreaService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zzsong on 2017/10/30.
 */
@Transactional
public class AreaServiceImpl implements AreaService {

    private final AreaMapper areaMapper;

    public AreaServiceImpl(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    @Override
    public Result<String> addProvince(List<Province> provinces) {
        int i = areaMapper.addProvince(provinces);
        if (i > 0) {
            return Result.ok(String.valueOf(i));
        }
        return Result.err("插入0条!");
    }

    @Override
    public Result<String> addCity(List<City> cities) {
        int i = areaMapper.addCity(cities);
        if (i > 0) {
            return Result.ok(String.valueOf(i));
        }
        return Result.err("插入0条!");
    }

    @Override
    public Result<String> addArea(List<Area> areas) {
        int i = areaMapper.addArea(areas);
        if (i > 0) {
            return Result.ok(String.valueOf(i));
        }
        return Result.err("插入0条!");
    }
}
