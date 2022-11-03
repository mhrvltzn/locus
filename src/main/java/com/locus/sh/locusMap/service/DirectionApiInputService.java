package com.locus.sh.locusMap.service;


import com.locus.sh.locusMap.model.Location;

import java.util.Scanner;

public class DirectionApiInputService {

    Scanner sc = new Scanner(System.in);

    public Location[] getStartAndEnd() {
        System.out.print("Enter Lat for starting point:");
        Double aLat = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Long for starting point:");
        Double aLong = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Lat for ending point:");
        Double bLat = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Long for ending point:");
        Double bLong = Double.parseDouble(sc.nextLine());

        Location start = new Location(aLat, aLong);
        Location end = new Location(bLat, bLong);

        return new Location[]{start, end};
    }

    public Integer getTargetDistanceBetweenTwoPoints() {
        System.out.print("Enter the distance you want between two equidistant points:");
        return Integer.parseInt(sc.nextLine());
    }

    public String tryAgain() {
        System.out.println("Google direction api did not return any routes. You can try with different points");
        System.out.print("Do you want to try again? Yes or No: ");
        return sc.nextLine();
    }
}
