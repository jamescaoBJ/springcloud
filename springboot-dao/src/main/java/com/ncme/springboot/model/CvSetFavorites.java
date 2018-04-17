package com.ncme.springboot.model;

import java.util.Date;

public class CvSetFavorites extends CvSetFavoritesKey {
    private Date favoriteDate;

    public Date getFavoriteDate() {
        return favoriteDate;
    }

    public void setFavoriteDate(Date favoriteDate) {
        this.favoriteDate = favoriteDate;
    }
}