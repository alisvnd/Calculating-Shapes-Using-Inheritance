public class EquilateralTriangle extends GeometricShape2D {

    private float height ;
    private float base ;

    EquilateralTriangle(float height, float base) {
        this.height = height ;
        this.base = base ;
    }

    @Override
    public float calculateArea() {
        return this.base*this.height/2 ;
    }

    @Override
    public void printInfo() {
        System.out.println("Triangle, base: " + this.base + ", height: " + this.height + ".") ;
    }

    public float getBase() {
        return base;
    } 
    public float getHeight() {
        return height;
    }
}
