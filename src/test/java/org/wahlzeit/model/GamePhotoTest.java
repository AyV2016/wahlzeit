package org.wahlzeit.model;

import org.junit.Test;

public class GamePhotoTest {

    @Test
    public void conTest() throws Exception{
        try{
            Photo p = new GamePhoto();
            GamePhoto p1 = new GamePhoto();
            GamePhoto p2 = new GamePhoto(new PhotoId(5));
            GamePhoto p3 = new GamePhoto(new Location(new Coordinate(3, 3, 3)));
        }catch (Exception e){
            throw new Exception("failed test");
        }
    }

    public static void main(String[] argv){
    }
}
