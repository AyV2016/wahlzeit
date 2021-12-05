package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

    // phi and theta are given in degrees, if they were stored as radians then the modulo operation changes
    public SphericCoordinate(double p, double t, double r){
        this.x = Math.abs(r);
        this.y = Math.abs(t) % 360; //2*Math.PI;
        this.z = Math.abs(p) % 360; //2*Math.PI;
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
        double x = this.x * Math.sin(this.z) * Math.cos(this.y);
        assertSolutionValid(x);
        double y = this.x * Math.sin(this.z) * Math.sin(this.y);
        assertSolutionValid(y);
        double z = this.x * Math.cos(this.z);
        assertSolutionValid(z);
        assertClassInvariants();
        return new CartesianCoordinate(x, y, z);
    }

    public double getCartesianDistance(Coordinate c) throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        return asCartesianCoordinate().getCartesianDistance(c);
    }

    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    public double getCentralAngle(Coordinate c) throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        double lsg = Math.acos((Math.sin(this.z) * Math.sin(cSpheric.getZ())) + (Math.cos(this.z) * Math.cos(cSpheric.getZ()) * Math.cos(Math.abs(this.y - cSpheric.getY())))) * this.x;
        assertSolutionValid(lsg);
        return lsg;
    }

    public boolean isEqual(Coordinate c)throws Exception {
        assertClassInvariants();
        coordinateNotNull(c);
        return this.equals(c);
    }

    public boolean equals(Coordinate c)throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        if(this.hashCode() == cSpheric.hashCode()){
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
