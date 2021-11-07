package org.wahlzeit.model;

import org.junit.Test;

public class PhotoTest {

    @Test
    public void conTest() throws Exception {
        try {
            Coordinate c = new Coordinate(2, 2, 3);
            Location loc = new Location(c);
            Photo p = new Photo(loc);
        }catch (Exception e){
            throw new Exception("instantiating a Photo with a Location didnt work!");
        }
    }
}
