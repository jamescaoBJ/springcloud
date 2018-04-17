package com.ncme.springboot.mapper;

import com.ncme.springboot.model.XiangyiProvince;

public interface XiangyiProvinceMapper {
    int deleteByPrimaryKey(Integer provinceId);

    int insert(XiangyiProvince record);

    int insertSelective(XiangyiProvince record);

    XiangyiProvince selectByPrimaryKey(Integer provinceId);

    int updateByPrimaryKeySelective(XiangyiProvince record);

    int updateByPrimaryKey(XiangyiProvince record);
}