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
    static Coordinate c5;

    //2 haupt coordinates die zum testen genutzt werden, werden hier ein mal gesetzt
    @BeforeClass
    static public void initCoordinates(){
        c = new SphericCoordinate(5, 13 ,67);
        //x = radius, y = theta, z = phi
        c2 = new CartesianCoordinate(450, 1403, 4178.54);
        c3 = new CartesianCoordinate(13, 13, 13);
        c4 = new SphericCoordinate(1, 15, 45);
        c5 = new CartesianCoordinate(0, 0, 0);
    }

    //getter test
    @Test
    public void getTest() {
            double x = c.getX();
            double y = c.getY();
            double z = c.getZ();
            assertEquals(67,x, 0.1);
            assertEquals(13, y, 0.1);
            assertEquals(5, z, 0.1);
            x = c2.getX();
            y = c2.getY();
            z = c2.getZ();
            assertEquals(450,x, 0.1);
            assertEquals(1403, y, 0.1);
            assertEquals(4178.54, z, 0.1);
    }

    //isEqual Test
    @Test
    public void isEqualTest() throws Exception{
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

     //also testing if division by 0 is possible or not
    @Test
    public void conversionTest()throws Exception{
        SphericCoordinate sc = c.asSphericCoordinate();
        assertEquals(sc, c);
        SphericCoordinate sc2 = new SphericCoordinate(0.34, 1.26, 4430.7);
        assertEquals(c2.asSphericCoordinate().getX(), sc2.getX(), 0.1);
        assertEquals(c2.asSphericCoordinate().getY(), sc2.getY(), 0.1);
        assertEquals(c2.asSphericCoordinate().getZ(), sc2.getZ(), 0.1);

        CartesianCoordinate cc = c2.asCartesianCoordinate();
        assertEquals(cc, c2);

        //SphericCoordinate sphericTest = c5.asSphericCoordinate();

        cc = c.asCartesianCoordinate();
        CartesianCoordinate c_test = new CartesianCoordinate(-58.3, -26.9, 19);
        assertEquals(c_test.getX(), cc.getX(), 0.1);
         //System.out.println("hier");
        assertEquals(c_test.getY(), cc.getY(), 0.1);
        assertEquals(c_test.getZ(), cc.getZ(), 0.1);
     }

    @Test
    public void getCentralAngleTest()throws Exception{
        double lsg = 0;
        assertEquals(lsg, c.getCentralAngle(c), 0.1);
        lsg = c.getCentralAngle(c4);
        assertEquals(lsg, c.getCentralAngle(c4), 0.1);
        lsg = c.getCentralAngle(c2.asSphericCoordinate());
        assertEquals(lsg, c.getCentralAngle(c2.asSphericCoordinate()), 0.1);

    }

    @Test
    public void getCartesianDistanceTest()throws Exception{
        double lsg = 0;
        assertEquals(lsg, c2.getCartesianDistance(c2), 0.1);
        lsg = c2.getCartesianDistance(c4);
        assertEquals(lsg, c2.getCartesianDistance(c4), 0.1);
        lsg = c2.getCartesianDistance(c3.asCartesianCoordinate());
        assertEquals(lsg, c2.getCartesianDistance(c3.asCartesianCoordinate()), 0.1);
    }

}
