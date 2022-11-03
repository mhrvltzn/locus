package com.locus.sh.locusMap.service;

import com.locus.sh.locusMap.LocusApplication;
import com.locus.sh.locusMap.model.GglDirectionApiResponse;
import com.locus.sh.locusMap.model.Legs;
import com.locus.sh.locusMap.model.Location;
import com.locus.sh.locusMap.model.Steps;
import com.locus.sh.locusMap.utils.DistanceUtils;
import com.locus.sh.locusMap.utils.PolylineDecoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquidistantPointsService {

    DirectionApiInputService inputService = new DirectionApiInputService();

    public void findPoints(Location startPoint,
                           Location endPoint,
                           Integer targetDistBetween2Points,
                           GglDirectionApiResponse response) {
        // check if response is not null and has valid steps
        if (hasSteps(response)) {
            Legs leg = response.getRoutes().get(0).getLegs().get(0);

            // get all points along the route by decoding polyline from all steps
            ArrayList<Location> allPoints = new ArrayList<>();
            allPoints.add(startPoint);

            for (Steps step : leg.getSteps()) {
                String poly = step.getPolyline().getPoints();
                List<Location> stepPoints = PolylineDecoder.decode(poly);
                allPoints.addAll(stepPoints);
            }

            Integer totalDistance = leg.getDistance().getValue();

            // find list of equidistant points along the route
            ArrayList<Location> resultPoints = findEquidistantPoints(allPoints, targetDistBetween2Points);

            // logic for end point
            // if total route distance - distance covered by equidistant pts is less than targetDistBetween2Points, add end point as it is
            // else calculate further points
            if (totalDistance - (resultPoints.size()-1)*targetDistBetween2Points <= targetDistBetween2Points) {
                resultPoints.add(endPoint);
            } else {
                ArrayList<Location> endPoints = new ArrayList<>(
                        Arrays.asList(allPoints.get(allPoints.size()-1), endPoint));

                resultPoints.addAll(findEquidistantPoints(endPoints, targetDistBetween2Points));
            }

            System.out.println(targetDistBetween2Points + "m distant points are:");
            resultPoints.stream().forEach(System.out::println);
        } else {
            handleNoRoutes();
        }
    }

    public ArrayList<Location> findEquidistantPoints(ArrayList<Location> allPoints, Integer targetDistBetween2Points) {
        ArrayList<Location> resultPoints = new ArrayList<>();
        resultPoints.add(allPoints.get(0));

        float tempDistBetween2Points = 0;

        for (int i = 0; i < allPoints.size()-1; i++) {

            Location p1 = allPoints.get(i);
            Location p2 = allPoints.get(i+1);

            Double tempDist = DistanceUtils.getEuclidDistance(p1, p2);
            tempDistBetween2Points += tempDist; //iterate through points and keep adding distance between them to this var

            // if tempDistBetween2Points crosses targetDistBetween2Points find out the diff by which it crosses ahead
            // and calculate a new point which is diff meter away from second to last point
            if (tempDistBetween2Points > targetDistBetween2Points) {

                Double diff = targetDistBetween2Points - (tempDistBetween2Points-tempDist);

                Location g = DistanceUtils.
                        locatePointBetweenTwoPointsAtDistanceFromFirstPoint(p1, p2, diff);

                resultPoints.add(new Location(g.getLatitude(), g.getLongitude()));

                allPoints.set(i, new Location(g.getLatitude(), g.getLongitude()));

                tempDistBetween2Points = 0;
                i--;
            }
        }

        return resultPoints;
    }

    private boolean hasSteps(GglDirectionApiResponse response) {
        return response != null &&
                response.getRoutes() != null && response.getRoutes().size() > 0 &&
                response.getRoutes().get(0) != null &&
                response.getRoutes().get(0).getLegs() != null && response.getRoutes().get(0).getLegs().size() > 0 &&
                response.getRoutes().get(0).getLegs().get(0).getSteps() != null && response.getRoutes().get(0).getLegs().get(0).getSteps().size() > 0;
    }

    private void handleNoRoutes() {
        if ("yes".equalsIgnoreCase(inputService.tryAgain())) {
            LocusApplication.main(null);
        } else {
            System.exit(0);
        }
    }

}
