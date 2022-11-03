package com.locus.sh.locusMap.model;

public class Steps {

    Distance distance;
    Duration duration;
    String end_address = "";
    String start_address = "";
    Location start_location;
    Location end_location;
    Polyline polyline;
    String travel_mode;
    String maneuver;

    public Distance getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getEnd_address() {
        return end_address;
    }

    public String getStart_address() {
        return start_address;
    }

    public Location getStart_location() {
        return start_location;
    }

    public Location getEnd_location() {
        return end_location;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public String getTravel_mode() {
        return travel_mode;
    }

    public String getManeuver() {
        return maneuver;
    }

}
