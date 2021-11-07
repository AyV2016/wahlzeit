package org.wahlzeit.model;


import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateTest {

    static Coordinate c;
    static Coordinate c2;
    static Coordinate c3;

    @BeforeClass
    static public void initCoordinates(){
        c = new Coordinate(5, 13 ,67);
        c2 = new Coordinate(450, 1403, 4178.54);
        c3 = new Coordinate(-41, -0.413478, 414);
    }

    @Test
    public void getTest() throws Exception{
        try{
            double x = c.getX();
            double y = c.getY();
            double z = c.getZ();
            assertEquals(5,x, 0);
            assertEquals(13, y, 0);
            assertEquals(67, z, 0);
        }catch (Exception e){
            throw new Exception("Hat nicht geklappt! Get Methoden können nicht aufgerufen werden!");
        }
    }

    @Test
    public void getDistanceTest() throws Exception{
        try{
            double d = c.getDistance(c2);
            assertEquals(4362.89882665184, d, 0);
            d = c2.getDistance(c);
            assertEquals(4362.89882665184, d, 0);
            d = c3.getDistance(c);
            assertEquals(350.2926225201674, d, 0);
        }catch (Exception e){
            throw new Exception("isCoordinate failed!");
        }
    }

    @Test
    public void isEqualTest() throws Exception{
        try{
            boolean p = c.isEqual(c2);
            assertEquals(p, false);
            p = c.isEqual(c);
            assertEquals(p, true);
        }
        catch (Exception e){
            throw new Exception("isEqual failed!");
        }
    }

    @Test
    public void equalsTest() throws Exception{
        try{
            boolean p = c.equals(c2);
            assertEquals(p, false);
            p = c.equals(c);
            assertEquals(p, true);
        }catch (Exception e){
            throw new Exception("equals failed!");
        }
    }

    public void main(String[] args) throws Exception {
        getTest();
        getDistanceTest();
        isEqualTest();
        equalsTest();
    }

}
