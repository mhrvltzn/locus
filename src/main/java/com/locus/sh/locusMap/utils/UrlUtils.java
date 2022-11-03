package com.locus.sh.locusMap.utils;


import com.locus.sh.locusMap.model.Location;

public class UrlUtils {

    private static final String DIRECTION_API_URL = "https://maps.googleapis.com/maps/api/directions/json?";
    private static final String API_KEY = "AIzaSyAEQvKUVouPDENLkQlCF6AAap1Ze-6zMos";


    public static String createGgleDirectionApiRequestUrl(Location start, Location end) {
        StringBuilder apiUrl = new StringBuilder();

        apiUrl.append(DIRECTION_API_URL);
        apiUrl.append("origin=").append(start.getLatitude()).append(",").append(start.getLongitude());
        apiUrl.append("&destination=").append(end.getLatitude()).append(",").append(end.getLongitude());
        apiUrl.append("&key=AIzaSyAEQvKUVouPDENLkQlCF6AAap1Ze-6zMos");
        apiUrl.append("&key=").append(API_KEY).append("\"");

        return apiUrl.toString();
    }

}
