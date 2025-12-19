public class Circle extends Ellipse{

    Circle (float radius){
        super(radius, radius) ;
    }

    @Override
    public void printInfo() {
        System.out.println("Circle, radius " + this.getsemiMajorAxis() + ".");
    }

    public float getRadius() {
        return this.getsemiMajorAxis() ;
    }
}
