package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

    // phi and theta are given in degrees, if they were stored as radians then the modulo operation changes
    public SphericCoordinate(double p, double t, double r){
        this.x = Math.abs(r);
        this.y = Math.abs(t) % 360; //2*Math.PI;
        this.z = Math.abs(p) % 360; //2*Math.PI;
    }

    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.x * Math.sin(this.z) * Math.cos(this.y);
        double y = this.x * Math.sin(this.z) * Math.sin(this.y);
        double z = this.x * Math.cos(this.z);
        return new CartesianCoordinate(x, y, z);
    }

    public double getCartesianDistance(Coordinate c) {
        return asCartesianCoordinate().getCartesianDistance(c);
    }

    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    public double getCentralAngle(Coordinate c) {
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        return Math.acos((Math.sin(this.z) * Math.sin(cSpheric.getZ())) + (Math.cos(this.z) * Math.cos(cSpheric.getZ()) * Math.cos(Math.abs(this.y - cSpheric.getY())))) * this.x;
    }

    public boolean isEqual(Coordinate c) {
        return this.equals(c);
    }

    public boolean equals(Coordinate c){
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        if(this.hashCode() == cSpheric.hashCode()){
            return true;
        }
        else{
            return false;
        }
    }

}
