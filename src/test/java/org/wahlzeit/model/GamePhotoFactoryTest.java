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
        gpf.newGamePhoto();
    }

    @Test
    public void locFacTest() throws Exception{
            gpf.newGamePhoto(loc);

    }
    @Test
    public void pidFacTest() throws Exception{
        gpf.newGamePhoto(pid);
    }



}
