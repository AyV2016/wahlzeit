package org.wahlzeit.model;

import java.util.*;

public class GamePhotoManager extends PhotoManager{

    protected static final PhotoManager instance = new GamePhotoManager();

    // photos, can be empty or filled
    protected Map<PhotoId, GamePhoto> photoCache = new HashMap<>();

    protected PhotoTagCollector photoTagCollector = null;

    public GamePhotoManager() {
        photoTagCollector = PhotoFactory.getInstance().createPhotoTagCollector();
    }
    public static PhotoManager initialize(){
        return getInstance();
    }

    public static PhotoManager getInstance() {
        return instance;
    }

    public static boolean hasPhoto(String id) {
        //here may occur a nullpointer exception, that may lead to undefined behavior
        if(id == null) throw new NullPointerException("id must not be null, try again");
        return hasPhoto(PhotoId.getIdFromString(id));
    }

    //all methods stay the same because GamePhoto extends Photo so for all Photo instances GamePhoto can be used instead -> no need to change that

}
