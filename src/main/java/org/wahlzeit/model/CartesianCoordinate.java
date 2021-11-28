package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

    //attributes are inherited from uperclass, so is the hashCode method

    public CartesianCoordinate(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
            // if x or z are 0, then we have to set them to 1, so we can call asSphericCoordinate without any problem
            if(x == 0) this.x = 1;
            if(z == 0) this.z = 1;
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

    public SphericCoordinate asSphericCoordinate() throws ArithmeticException{
        try {
            double radius = Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
            double theta = Math.atan(this.y / this.x);
            double phi = Math.atan(Math.sqrt(this.x * this.x + this.y * this.y) / this.z);
            return new SphericCoordinate(phi, theta, radius);
        }catch (Exception exception){
            throw new ArithmeticException("durch 0 geteilt");
        }

    }

    public double getCentralAngle(Coordinate c) {
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        SphericCoordinate thisSpheric = this.asSphericCoordinate();
        return thisSpheric.getCentralAngle(cSpheric);
    }

    public boolean isEqual(Coordinate c) {
        return this.equals(c);
    }

    public boolean equals(Coordinate c) {
        CartesianCoordinate cCartesian = c.asCartesianCoordinate();
        if(this.hashCode() == cCartesian.hashCode()){
            return true;
        }
        else{
            return false;
        }
    }
}
