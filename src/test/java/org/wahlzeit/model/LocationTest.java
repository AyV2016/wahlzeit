package org.wahlzeit.model;

import org.junit.Test;

public class LocationTest {

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
