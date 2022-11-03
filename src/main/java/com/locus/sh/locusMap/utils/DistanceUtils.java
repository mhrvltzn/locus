package com.locus.sh.locusMap.utils;

import com.locus.sh.locusMap.model.Location;

public class DistanceUtils {

    public static Double getEuclidDistance(Location p1, Location p2) {
        Double dist = Math.sqrt(
                        Math.pow(Math.abs(p1.getLatitude() - p2.getLatitude()), 2) +
                        Math.pow(Math.abs(p1.getLongitude() - p2.getLongitude()), 2)
        );
        return (dist * Math.pow(10, 5));
    }

    public static Location locatePointBetweenTwoPointsAtDistanceFromFirstPoint
            (Location p1, Location p2, double distance) {
        Double distBetweenTwoPts = getEuclidDistance(p1, p2);
        Location p3 = new Location();

        p3.setLatitude(p1.getLatitude() +
                (distance/distBetweenTwoPts) * (p2.getLatitude() - p1.getLatitude()));

        p3.setLongitude(p1.getLongitude() +
                (distance/distBetweenTwoPts) * (p2.getLongitude() - p1.getLongitude()));

        return p3;
    }

}
