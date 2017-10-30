package com.zzsong.study.orange.user.mapper;

import com.zzsong.study.orange.common.pojo.table.Area;
import com.zzsong.study.orange.common.pojo.table.City;
import com.zzsong.study.orange.common.pojo.table.Province;

import java.util.List;

/**
 * Created by zzsong on 2017/10/30.
 */
public interface AreaMapper {

    /**
     * 批量插入省信息
     *
     * @param provinces 省信息集合
     * @return 插入的条数
     */
    int addProvince(List<Province> provinces);

    /**
     * 批量插入市信息
     *
     * @param cities 市信息集合
     * @return 插入的条数
     */
    int addCity(List<City> cities);

    /**
     * 批量插入区信息
     *
     * @param areas 区信息集合
     * @return 插入的条数
     */
    int addArea(List<Area> areas);
}
