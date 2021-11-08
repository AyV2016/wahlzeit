package org.wahlzeit.model;

import org.junit.Test;

//test fuer die Klasse Location
public class LocationTest {

    //konstruktor Test
    @Test
    public void conTest()throws Exception{
        try{
            Coordinate c = new Coordinate(5, 4, 5);
            Location loc = new Location(c);
        }
        catch (Exception e){
            throw new Exception("instantianting Location didnt work!");
        }
    }
}
