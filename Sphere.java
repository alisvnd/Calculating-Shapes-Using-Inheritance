public class Sphere extends GeometricShape3D{
    private float radius ;

    Sphere (float radius){
        this.radius = radius ;
    }

    @Override
    public float calculateArea() {
        return (float) (4*Math.PI*Math.pow(radius, 2)) ;
    }

    @Override
    public float calculateVolume() {
        return (float) (4/3*Math.PI*Math.pow(radius, 3)) ;
    }

    @Override
    public void printInfo() {
        System.out.println("Sphere, radius " + this.radius + ".");
    }

    public float getRadius() {
        return radius;
    }
}
