package com.locus.sh.locusMap;

import com.locus.sh.locusMap.model.GglDirectionApiResponse;
import com.locus.sh.locusMap.model.Location;
import com.locus.sh.locusMap.service.DirectionApiInputService;
import com.locus.sh.locusMap.service.EquidistantPointsService;
import com.locus.sh.locusMap.service.GglDirectionApiService;

public class LocusApplication {

    public static void main(String[] args) {
        // Get input from user
        DirectionApiInputService inputService = new DirectionApiInputService();
        Location[] startEnd = inputService.getStartAndEnd();
        Location startPoint = startEnd[0];
        Location endPoint = startEnd[1];
        Integer targetDistBetween2Points = inputService.getTargetDistanceBetweenTwoPoints();

        // Call google api
        GglDirectionApiResponse response = GglDirectionApiService.getDirection(startPoint, endPoint);

        //find equidistant points along the route
        EquidistantPointsService equidistantPointsService = new EquidistantPointsService();
        equidistantPointsService.findPoints(startPoint, endPoint, targetDistBetween2Points, response);
    }


}