package org.wahlzeit.model;

public class GameType {

    String type;

    GameType(String type){
        this.type = type;
    }

    public boolean isSubtype(GameType other){
         return other instanceof GameType;
    }
}
