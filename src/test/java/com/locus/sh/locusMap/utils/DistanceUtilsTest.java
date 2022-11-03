package com.locus.sh.locusMap.utils;


import com.locus.sh.locusMap.model.Location;
import com.locus.sh.locusMap.service.EquidistantPointsService;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import org.junit.jupiter.api.Test;

/**
 *  this test class was only used only for development purpose
 */
public class DistanceUtilsTest {

    @Test
    public void test1() {
        Location p1 = new Location(12.93175, 77.62872);
        Location p2 = new Location(12.93166, 77.62852);
        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
    }

    @Test
    public void test2() {
        Location p1 = new Location(12.93175, 77.62872);
        Location p2 = new Location(12.931712308133232, 77.628636240237);
        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
    }

    @Test
    public void testStartPoint() {
        Location p1 = new Location(12.93175, 77.62872);
        Location p2 = new Location(12.931453, 77.62862);
        Location p3 = new Location(12.931043,77.62881);
        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
        System.out.println(DistanceUtils.getEuclidDistance(p2, p3));
    }
//12.93175,77.62872,red,square
//12.931453,77.62862,red,square
    @Test
    public void test3() {
        GeodesicData g1 = Geodesic.WGS84.Inverse(12.93175, 77.62872, 12.93166, 77.62852);
        GeodesicData g2 = Geodesic.WGS84.Direct(g1.lat1, g1.lon1, g1.azi1, 10.0d);
        System.out.println(g2.lat2 + ", " + g2.lon2);
    }

    @Test
    public void testEquidistant() {
        Location p1 = new Location(12.93166, 77.62852);
        Location p2 = new Location(12.931250708470449, 77.6287086811952);
        Location p3 = new Location(12.930836424794924, 77.62888766371196);

        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
        System.out.println(DistanceUtils.getEuclidDistance(p2, p3));
        System.out.println(DistanceUtils.getEuclidDistance(p2, p3));
    }

    @Test
    public void testBetweenlastPolyPointAndB() {
        Location p1 = new Location(12.926368434058908, 77.63711768677047);
        Location p2 = new Location(12.92662, 77.63696);
        System.out.println(DistanceUtils.getEuclidDistance(p1, p2));
    }

    @Test
    public void testdist5and4() {
        Location p5 = new Location(12.92789887915492,77.63715929516606);
        Location p4 = new Location(12.927547836667712,77.63750328285852);
        //System.out.println(DistanceUtils.getEuclidDistance(p5, p4));
        System.out.println(DistanceUtils.getEuclidDistance(p5, p4));
    }

    @Test
    public void testdist4and3() {
        Location p4 = new Location(12.927547836667712,77.63750328285852);
        Location p3 = new Location(12.927194447886752,77.63718340695016);
        //System.out.println(DistanceUtils.getEuclidDistance(p5, p4));
        System.out.println(DistanceUtils.getEuclidDistance(p4, p3));
    }

    @Test
    public void testdist3and2() {
        Location p3 = new Location(12.927194447886752,77.63718340695016);
        Location p2 = new Location(12.926699240049366,77.63717834462217);
        //System.out.println(DistanceUtils.getEuclidDistance(p5, p4));
        System.out.println(DistanceUtils.getEuclidDistance(p3, p2));
    }


}

