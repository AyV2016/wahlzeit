package org.wahlzeit.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GamePhotoFactoryTest {

    static Location loc;
    static PhotoId pid;
    static GamePhotoFactory gpf;

    @BeforeClass
    public static void init(){
        loc = new Location(new Coordinate(23, 4, 5));
        pid = new PhotoId(5);
        gpf = new GamePhotoFactory();
    }

    @Test
    public void facTest() throws Exception{
        try {
            gpf.newGamePhoto();
        }catch (Exception e){
            throw new Exception("failed without anything");
        }
    }

    @Test
    public void locFacTest() throws Exception{
        try {
            gpf.newGamePhoto(loc);
        }catch (Exception e){
            throw new Exception("failed without anything");
        }
    }

    
    @Test
    public void pidFacTest() throws Exception{
        try {
            gpf.newGamePhoto(pid);
        }catch (Exception e){
            throw new Exception("failed without anything");
        }
    }




}
