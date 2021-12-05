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

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public CartesianCoordinate asCartesianCoordinate() throws Exception{
        assertClassInvariants();
        return this;
    }

    public double getCartesianDistance(Coordinate c) throws Exception {
        assertClassInvariants();

        // pre-condition: c mustnt be null
        coordinateNotNull(c);

        CartesianCoordinate tmp = c.asCartesianCoordinate();
        double dx = Math.sqrt(Math.pow(tmp.getX()-this.x, 2));
        assert dx != Double.NaN;
        double dy = Math.sqrt(Math.pow(tmp.getY()-this.y, 2));
        assert dy != Double.NaN;
        double dz = Math.sqrt(Math.pow(tmp.getZ()-this.z, 2));
        assert dz != Double.NaN;
        assertClassInvariants();
        return Math.sqrt(dx+dy+dz);
    }

    public SphericCoordinate asSphericCoordinate() throws Exception {
        assertClassInvariants();
        try {
            double radius = Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
            assertSolutionValid(radius);
            double theta = Math.atan(this.y / this.x);
            assertSolutionValid(theta);
            double phi = Math.atan(Math.sqrt(this.x * this.x + this.y * this.y) / this.z);
            assertSolutionValid(phi);
            assertClassInvariants();
            return new SphericCoordinate(phi, theta, radius);
        }catch (Exception exception){
            throw new ArithmeticException("durch 0 geteilt");
        }

    }

    public double getCentralAngle(Coordinate c) throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        SphericCoordinate thisSpheric = this.asSphericCoordinate();
        assertClassInvariants();
        return thisSpheric.getCentralAngle(cSpheric);
    }

    public boolean isEqual(Coordinate c) throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        return this.equals(c);
    }

    public boolean equals(Coordinate c) throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        CartesianCoordinate cCartesian = c.asCartesianCoordinate();
        if(this.hashCode() == cCartesian.hashCode()){
            assertClassInvariants();
            return true;
        }
        else{
            assertClassInvariants();
            return false;
        }
    }

    private void assertSolutionValid(double sol) throws Exception{
        if((this.x != 0 || this.y != 0 || this.z != 0 ) && sol == 0) throw new Exception("illegal Argument");
    }

    public void assertClassInvariants() throws Exception{
        if(this == null) throw new NullPointerException("this is null!");
        if(this.x == Double.NaN || this.y == Double.NaN || this.z == Double.NaN) throw new IllegalStateException("one of the attributes is not a double anymore!");

    }

    private void coordinateNotNull(Coordinate c) throws NullPointerException{
        if(c == null) throw new NullPointerException("c is null!");
    }
}
