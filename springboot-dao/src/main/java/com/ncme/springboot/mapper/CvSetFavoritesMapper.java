package com.ncme.springboot.mapper;

import com.ncme.springboot.model.CvSetFavorites;
import com.ncme.springboot.model.CvSetFavoritesKey;

public interface CvSetFavoritesMapper {
    int deleteByPrimaryKey(CvSetFavoritesKey key);

    int insert(CvSetFavorites record);

    int insertSelective(CvSetFavorites record);

    CvSetFavorites selectByPrimaryKey(CvSetFavoritesKey key);

    int updateByPrimaryKeySelective(CvSetFavorites record);

    int updateByPrimaryKey(CvSetFavorites record);
}