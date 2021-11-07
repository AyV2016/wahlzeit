package org.wahlzeit.model;

import sun.font.CoreMetrics;

public class Coordinate {

    /**
     * kartesische Koordinaten werden hier gesetzt
     */

    private final double x;
    private final double y;
    private final double z;


    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double getX(){
        return x;
    }

    double getY(){
        return y;
    }

    double getZ(){
        return z;
    }

    double getDistance(Coordinate coordinate){
        return Math.sqrt(Math.pow(coordinate.getX() - this.x, 2) + Math.pow(coordinate.getY() - this.y, 2) + Math.pow(coordinate.getZ() - this.z, 2));
    }

    boolean isEqual(Coordinate coordinate){
        System.out.println("isEquals wurde aufgerufen");
        if(coordinate.getX() == this.x && coordinate.getY() == this.y && coordinate.getZ() == this.z)
            return true;
        else
            return false;
    }

    boolean equals(Coordinate coordinate){
        return isEqual(coordinate);
    }


}
