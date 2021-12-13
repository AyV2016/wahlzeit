package org.wahlzeit.model;

import org.wahlzeit.services.SysLog;

public class GamePhotoFactory extends PhotoFactory{

    //here we need to change the inits because we want to get GamePhotos which are a special type of Photo, and therefore we need to explicitly instantiate GamePhotosaa
    private static PhotoFactory instance;


    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            SysLog.logSysInfo("setting generic PhotoFactory");
            PhotoFactory.setInstance(new GamePhotoFactory());
        }
        return instance;
    }
    protected static synchronized void setInstance(GamePhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize PhotoFactory twice");
        }
        instance = photoFactory;
    }
    public static void initialize() {
        //no errors possible, methods are built well
        getInstance();
    }

    protected GamePhotoFactory() {
        // do nothing
    }

    public GamePhoto newGamePhoto(){
        return new GamePhoto();
    }

    public GamePhoto newGamePhoto(Location loc){
        // no need to check for exceptions, GamePhoto-class handles that
        return new GamePhoto(loc);
    }

    public GamePhoto newGamePhoto(PhotoId pid){
        // no need to check for exceptions, GamePhoto-class handles that
        return new GamePhoto(pid);
    }
}
