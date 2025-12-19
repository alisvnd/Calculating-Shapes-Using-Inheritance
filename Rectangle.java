public class Rectangle extends GeometricShape2D {

    private float width ;
    private float height ;

    Rectangle (float width, float height){
        this.height = height ;
        this.width = width ;
    }


    @Override
    public float calculateArea() {
        return width*height ;
    }

    @Override
    public void printInfo() {
       System.out.println("Rectangle, " + width + " by " + height + ".");
    }
    
    public float getHeight() {
        return height;
    }
    
    public float getWidth() {
        return width;
    }
    
}
