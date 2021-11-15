package org.wahlzeit.model;


import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

// Test fuer die Klasse Coordinate
public class CoordinateTest {

    static Coordinate c;
    static Coordinate c2;
    static Coordinate c3;

    //3 haupt coordinates die zum testen genutzt werden, werden hier ein mal gesetzt
    @BeforeClass
    static public void initCoordinates(){
        c = new Coordinate(5, 13 ,67);
        c2 = new Coordinate(450, 1403, 4178.54);
        c3 = new Coordinate(-41, -0.413478, 414);
    }

    //getter test
    @Test
    public void getTest() throws Exception{
        try{
            double x = c.getX();
            double y = c.getY();
            double z = c.getZ();
            assertEquals(5,x, 0.1);
            assertEquals(13, y, 0.1);
            assertEquals(67, z, 0.1);
        }catch (Exception e){
            throw new Exception("Hat nicht geklappt! Get Methoden können nicht aufgerufen werden!");
        }
    }

    //getDistance test
    @Test
    public void getDistanceTest() throws Exception{
        try{
            double d = c.getDistance(c2);
            assertEquals(4362.89882665184, d, 0.1);
            d = c2.getDistance(c);
            assertEquals(4362.89882665184, d, 0.1);
            d = c3.getDistance(c);
            assertEquals(350.2926225201674, d, 0.1);
        }catch (Exception e){
            throw new Exception("isCoordinate failed!");
        }
    }

    //isEqual Test
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

    //testen ob das forwarding richtig funktioniert
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
