package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{

    private double x, y, z;

    public CartesianCoordinate(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    public double getCartesianDistance(Coordinate c) {
        CartesianCoordinate tmp = c.asCartesianCoordinate();
        double dx = Math.sqrt(Math.pow(tmp.getX()-this.x, 2));
        double dy = Math.sqrt(Math.pow(tmp.getY()-this.y, 2));
        double dz = Math.sqrt(Math.pow(tmp.getZ()-this.z, 2));
        return Math.sqrt(dx+dy+dz);
    }

    public SphericCoordinate asSphericCoordinate() {
        double phi = Math.sqrt((this.x*this.x)+(this.y*this.y)+(this.z*this.z));
        double theta = Math.atan(y/x);
        double radius = Math.atan(Math.sqrt(this.x * this.x + this.y * this.y) / this.z);  //Math.acos(z/(Math.sqrt(this.x*this.x+this.y*this.y+this.z+this.z)));
        return new SphericCoordinate(phi, theta, radius);
    }

    public double getCentralAngle(Coordinate c) {
        SphericCoordinate tmp = c.asSphericCoordinate();
        SphericCoordinate tmp_2 = this.asSphericCoordinate();
        return tmp_2.getCentralAngle(c);
    }

    public boolean isEqual(Coordinate c) {
        return this.equals(c);
    }

    public boolean equals(Coordinate c) {
        CartesianCoordinate tmp = c.asCartesianCoordinate();
        if(this.x == tmp.getX() && this.y == tmp.getY() && this.z == tmp.getZ()){
            return true;
        }
        else{
            return false;
        }
    }
}
