public class Cylinder extends GeometricShape3D{
    private float radius ;
    private float height ;

    Cylinder (float radius, float height) {
        this.height = height ;
        this.radius = radius ;
    }

    @Override
    public float calculateArea(){
        return (float) (2*Math.PI*this.radius*(this.radius + this.height)) ;
    }

    @Override
    public float calculateVolume() {
        return (float) (Math.PI*this.height*Math.pow(radius, 2)) ;
    }

    @Override
    public void printInfo() {
        System.out.println("Cylinder, height: " + this.height + " base radius: " + this.radius + ".");
    }
    
    public float getHeight() {
        return height;
    }
    public float getRadius() {
        return radius;
    }
}
