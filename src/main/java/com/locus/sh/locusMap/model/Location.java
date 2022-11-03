package com.locus.sh.locusMap.model;

public class Location {

    Double latitude;
    Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return latitude + "," +longitude + ",red,square";
    }
}
