package org.wahlzeit.model;


import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

// Test fuer die Klasse Coordinate
public class CoordinateTest {

    static Coordinate c;
    static Coordinate c2;
    static Coordinate c3;
    static Coordinate c4;

    //2 haupt coordinates die zum testen genutzt werden, werden hier ein mal gesetzt
    @BeforeClass
    static public void initCoordinates(){
        c = new SphericCoordinate(5, 13 ,67);
        //x = radius, y = theta, z = phi
        c2 = new CartesianCoordinate(450, 1403, 4178.54);
        c3 = new CartesianCoordinate(13, 13, 13);
        c4 = new SphericCoordinate(1, 15, 45);
    }

    //getter test
    @Test
    public void getTest() {
            double x = c2.getX();
            double y = c2.getY();
            double z = c2.getZ();
            assertEquals(5,x, 0.1);
            assertEquals(13, y, 0.1);
            assertEquals(67, z, 0.1);
            x = c.getX();
            y = c.getY();
            z = c.getZ();
            assertEquals(450,x, 0.1);
            assertEquals(1403, y, 0.1);
            assertEquals(4178.54, z, 0.1);
    }

    //isEqual Test
    @Test
    public void isEqualTest() {
            boolean p = c.isEqual(c2);
            assertEquals(p, false);
            p = c.isEqual(c);
            assertEquals(p, true);
    }

    //testen ob das forwarding richtig funktioniert
    @Test
    public void equalsTest(){
            boolean p = c.equals(c2);
            assertEquals(p, false);
            p = c.equals(c);
            assertEquals(p, true);
     }

     @Test
    public void conversionTest(){
        SphericCoordinate sc = c.asSphericCoordinate();
        assertEquals(sc, c);
        SphericCoordinate sc2 = new SphericCoordinate(4430.7, 1.26, 0.34);
        assertEquals(c2.asSphericCoordinate().getX(), sc2.getX(), 0.1);
        assertEquals(c2.asSphericCoordinate().getY(), sc2.getY(), 0.1);
        assertEquals(c2.asSphericCoordinate().getZ(), sc2.getZ(), 0.1);

        CartesianCoordinate cc = c2.asCartesianCoordinate();
        assertEquals(cc, c2);

        cc = c.asCartesianCoordinate();
        CartesianCoordinate c_test = new CartesianCoordinate(-3.83, -1.79, -2.58);
        assertEquals(c_test.getX(), cc.getX(), 0.1);
         System.out.println("hier");
        assertEquals(c_test.getY(), cc.getY(), 0.1);
        assertEquals(c_test.getZ(), cc.getZ(), 0.1);
     }

     @Test
    public void getCentralAngleTest(){
        double lsg = 0;
        assertEquals(lsg, c.getCentralAngle(c), 0.1);
        lsg = c.getCentralAngle(c4);
        assertEquals(lsg, c.getCentralAngle(c4), 0.1);
        lsg = c.getCentralAngle(c2.asSphericCoordinate());
        assertEquals(lsg, c.getCentralAngle(c2.asSphericCoordinate()), 0.1);

    }

    @Test
    public void getCartesianDistanceTest(){
        double lsg = 0;
        assertEquals(lsg, c2.getCartesianDistance(c2), 0.1);
        lsg = c2.getCartesianDistance(c4);
        assertEquals(lsg, c2.getCartesianDistance(c4), 0.1);
        lsg = c2.getCartesianDistance(c3.asCartesianCoordinate());
        assertEquals(lsg, c2.getCartesianDistance(c3.asCartesianCoordinate()), 0.1);
    }

}
