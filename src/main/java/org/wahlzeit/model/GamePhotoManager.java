package org.wahlzeit.model;

import java.util.*;

public class GamePhotoManager extends PhotoManager{

    protected static final GamePhotoManager gpm = null;

    // photos, can be empty or filled
    protected Map<PhotoId, GamePhoto> photoCache = new HashMap<>();

    //all methods stay the same because GamePhoto extends Photo so for all Photo instances GamePhoto can be used instead -> no need to change that

}
