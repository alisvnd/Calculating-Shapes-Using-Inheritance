public class Ellipse extends GeometricShape2D{

    private float semiMajorAxis ;
    private float semiMinorAxis ;

    Ellipse (float semiMajorAxis, float semiMinorAxis){
        this.semiMajorAxis = Math.max(semiMajorAxis, semiMinorAxis);
        this.semiMinorAxis = Math.min(semiMajorAxis, semiMinorAxis) ;
    }

    @Override
    public float calculateArea() {
        return  (float) (Math.PI*this.semiMajorAxis*this.semiMinorAxis) ;
    }

    @Override 
    public void printInfo() {
        System.out.println("Ellipse, semi-major axis: " + semiMajorAxis + ", semi-minor axis: " + semiMinorAxis + ".");
    }

    public float getsemiMajorAxis() {
        return semiMajorAxis;
    }
    public float getsemiMinorAxis() {
        return semiMinorAxis;
    }
}
