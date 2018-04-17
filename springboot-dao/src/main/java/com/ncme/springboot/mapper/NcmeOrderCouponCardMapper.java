package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeOrderCouponCard;

public interface NcmeOrderCouponCardMapper {
    int insert(NcmeOrderCouponCard record);

    int insertSelective(NcmeOrderCouponCard record);
}