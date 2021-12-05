package org.wahlzeit.model;

public interface Coordinate {

    public CartesianCoordinate asCartesianCoordinate()throws Exception;

    public double getCartesianDistance(Coordinate c) throws Exception;

    public SphericCoordinate asSphericCoordinate() throws Exception;

    public double getCentralAngle(Coordinate c)throws Exception;

    public boolean isEqual(Coordinate c)throws Exception;

    public double getX();

    public double getY();

    public double getZ();

}
