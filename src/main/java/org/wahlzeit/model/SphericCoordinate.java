package org.wahlzeit.model;


public final class SphericCoordinate extends AbstractCoordinate {

    // phi and theta are given in degrees, if they were stored as radians then the modulo operation changes

    private final double x, y, z;

    public SphericCoordinate(double p, double t, double r){
        if(p == Double.NaN || t == Double.NaN || r == Double.NaN) throw new IllegalArgumentException("p, t and r must be a valid double");
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
        //easier to check instantly for Double.NaN, since that is the only thing that has to be checked
        assert x != Double.NaN;
        double y = this.x * Math.sin(this.z) * Math.sin(this.y);
        assert y != Double.NaN;
        double z = this.x * Math.cos(this.z);
        assert z != Double.NaN;
        assertClassInvariants();
        return new CartesianCoordinate(x, y, z);
    }

    public double getCartesianDistance(Coordinate c) throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        //copy of itself
        SphericCoordinate thisCopy = new SphericCoordinate(this.z, this.y, this.x);
        CartesianCoordinate thisCartesian = thisCopy.asCartesianCoordinate();
        return thisCartesian.getCartesianDistance(c);
    }

    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();
        SphericCoordinate thisCopy = new SphericCoordinate(this.z, this.y, this.x);
        return thisCopy;
    }

    public double getCentralAngle(Coordinate c) throws Exception{
        assertClassInvariants();
        coordinateNotNull(c);
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        //no need to copy, there is no new object, just a simple value
        double lsg = Math.acos((Math.sin(this.z) * Math.sin(cSpheric.getZ())) + (Math.cos(this.z) * Math.cos(cSpheric.getZ()) * Math.cos(Math.abs(this.y - cSpheric.getY())))) * this.x;
        assert lsg != Double.NaN;
        return lsg;
    }

    public boolean isEqual(Coordinate c)throws Exception {
        assertClassInvariants();
        coordinateNotNull(c);
        //forward to equals-method
        return this.equals(c);
    }

    public boolean equals(Coordinate c)throws Exception{
        //check for ClassInvariants at the beginning
        assertClassInvariants();
        //checking that c ist not null and has valid doubles
        coordinateNotNull(c);
        SphericCoordinate cSpheric = c.asSphericCoordinate();
        if(this.hashCode() == cSpheric.hashCode() || (this.x == cSpheric.getX() && this.y == cSpheric.getY() && this.z == cSpheric.getZ())){
            //check for ClassInvariants at the end
            assertClassInvariants();
            return true;
        }
        else{
            //check for ClassInvariants at the end
            assertClassInvariants();
            return false;
        }
    }

    //should be correct for the most objects, only in special cases not good enough
    public int hashCode(){
        return (int) (x * 100000 + y * 1000 + z * 10);
    }

//    private void assertSolutionValid(double sol) throws Exception{
//        if((this.x != 0 || this.y != 0 || this.z != 0 ) && sol == 0) throw new Exception("illegal Argument");
//    }
    //classic ClassInvariants
    public void assertClassInvariants(){
        if(this == null) throw new NullPointerException("this is null!");
        if(this.x == Double.NaN || this.y == Double.NaN || this.z == Double.NaN) throw new IllegalStateException("one of the attributes is not a double anymore!");
    }

        //exception handling for invalid input
    private void coordinateNotNull(Coordinate c) {
        if(c == null || c.getX() == Double.NaN || c.getY() == Double.NaN || c.getZ() == Double.NaN) throw new NullPointerException("c is null!");
    }



}
