package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{

    private double phi, theta, radius;

    public SphericCoordinate(double p, double t, double r){
            this.phi = Math.abs(p );
            this.theta = Math.abs(t);
            this.radius = Math.abs(r);
    }

    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.phi * Math.sin(this.radius) * Math.cos(this.theta);
        double y = this.phi * Math.sin(this.radius) * Math.sin(this.theta);
        double z = this.phi * Math.cos(this.radius);
        return new CartesianCoordinate(x, y, z);
    }

    public double getX(){
        return phi;
    }
    public double getY(){
        return theta;
    }
    public double getZ(){
        return radius;
    }


    public double getCartesianDistance(Coordinate c) {
        return asCartesianCoordinate().getCartesianDistance(c);
    }

    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    public double getCentralAngle(Coordinate c) {
        SphericCoordinate tmp = c.asSphericCoordinate();
        return Math.acos((Math.sin(this.phi) * Math.sin(tmp.getX())) + (Math.cos(this.phi)*Math.cos(tmp.getX())*Math.cos(Math.abs(this.theta-tmp.getY())))) * radius;
    }

    public boolean isEqual(Coordinate c) {
        return this.equals(c);
    }

    public boolean equals(Coordinate c){
        SphericCoordinate tmp = c.asSphericCoordinate();
        if(this.phi == tmp.getX() && this.theta == tmp.getY() && this.radius == tmp.getZ()){
            return true;
        }
        else{
            return false;
        }
    }

}
