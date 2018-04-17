package com.ncme.springboot.mapper;

import com.ncme.springboot.model.NcmeOrderCoupon;

public interface NcmeOrderCouponMapper {
    int insert(NcmeOrderCoupon record);

    int insertSelective(NcmeOrderCoupon record);
}