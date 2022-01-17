package org.wahlzeit.model;

import java.util.ArrayList;

public class GameManager {

    protected ArrayList<GameType> gameTypes;

    public GameManager(){

    }

    public void addType(GameType gt){
        gameTypes.add(gt);
    }
}
