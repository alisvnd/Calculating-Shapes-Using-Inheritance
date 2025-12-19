public class Pyramid extends GeometricShape3D{
    private float height ;
    private float baseEdge;

    Pyramid(float height, float baseEdge){
        this.height = height ;
        this.baseEdge = baseEdge ;
    }

    @Override 
    public float calculateArea() {
        return (float) ((2*Math.sqrt(Math.pow(baseEdge/2, 2) + Math.pow(height, 2)) + baseEdge) * baseEdge) ;
    } 

    @Override
    public float calculateVolume() {
        return (float) (Math.pow(baseEdge, 2)*this.height/3) ;
    }

    @Override
    public void printInfo() {
        System.out.println("Pyramid, baseEdge: " + this.baseEdge + " height: " + this.height + ".");
    }

    public float getBaseEdge() {
        return baseEdge;
    }
    public float getHeight() {
        return height;
    }
}
