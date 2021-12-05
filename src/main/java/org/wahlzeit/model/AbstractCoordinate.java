package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    // everything that has to be the same in the subclasses is implemented here
    // but keep in mind that this class is abstract, so you need to instantiate an object from a subclass first
    // everything else is implemented in the subclasses, but already declared in the interface Coordinate
    double x, y, z;

    public abstract double getCartesianDistance(Coordinate c) throws Exception;

    public abstract double getCentralAngle(Coordinate c) throws Exception;

    public abstract boolean equals(Coordinate c) throws Exception;

    public abstract boolean isEqual(Coordinate c) throws Exception;

    //should be correct for the most objects, only in special cases not good enough
    public int hashCode(){
        return (int) (x * 100000 + y * 1000 + z * 10);
    }
}
