package org.wahlzeit.model;

import org.wahlzeit.services.SysLog;

public class GamePhotoFactory extends PhotoFactory{

    //here we need to change the inits because we want to get GamePhotos which are a special type of Photo, and therefore we need to explicitly instantiate GamePhotosaa
    private static GamePhotoFactory instance;

    public static synchronized GamePhotoFactory getInstance() {
        if (instance == null) {
            SysLog.logSysInfo("setting generic PhotoFactory");
            setInstance(new PhotoFactory());
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
        getInstance();
    }

    protected GamePhotoFactory() {
        // do nothing
    }

    public GamePhoto newGamePhoto(){
        return new GamePhoto();
    }

    public GamePhoto newGamePhoto(Location loc){
        return new GamePhoto(loc);
    }

    public GamePhoto newGamePhoto(PhotoId pid){
        return new GamePhoto(pid);
    }
}
