package com.zzsong.study.orange.user.service;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.Area;
import com.zzsong.study.orange.common.pojo.table.City;
import com.zzsong.study.orange.common.pojo.table.Province;

import java.util.List;

/**
 * Created by zzsong on 2017/10/30.
 */
public interface AreaService {

    /**
     * 批量插入省信息
     *
     * @param provinces 省信息集合
     * @return Result<String>
     */
    Result<String> addProvince(List<Province> provinces);

    /**
     * 批量插入市信息
     *
     * @param cities 市信息集合
     * @return Result<String>
     */
    Result<String> addCity(List<City> cities);

    /**
     * 批量插入区信息
     *
     * @param areas 区信息集合
     * @return Result<String>
     */
    Result<String> addArea(List<Area> areas);
}
