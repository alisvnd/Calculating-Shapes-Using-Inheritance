public class Cuboid extends GeometricShape3D{

    private float width ;
    private float length ;
    private float height ;

    Cuboid (float width, float length, float height){
        this.length = length ;
        this.width = width ;
        this.height = height ;
    }

    @Override
    public float calculateArea() {
        return 2*(this.height*this.length + this.height*this.width + this.length*this.width) ;
    }
    
    @Override
    public float calculateVolume(){
        return this.height*this.length*this.width ;
    }

    @Override
    public void printInfo (){
        System.out.println("Cuboid, " + this.width + " by " + this.length + " by " + this.height + ".");
    }

    public float getHeight() {
        return height;
    }
    public float getLength() {
        return length;
    }
    public float getWidth() {
        return width;
    }
}
