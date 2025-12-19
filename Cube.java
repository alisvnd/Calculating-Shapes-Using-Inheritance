public class Cube extends Cuboid{
    
    Cube(float edge){
        super(edge, edge, edge) ;
    }

    @Override
    public void printInfo (){
        System.out.println("Cube, edge length " + this.getEdge() + ".");
    }

    public float getEdge(){
        return this.getHeight()  ;
    }
}