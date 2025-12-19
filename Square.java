public class Square extends Rectangle{

    Square(float edge){
        super(edge, edge) ;
    }

    @Override
    public void printInfo(){
        System.out.println("Square, edge length " + this.getHeight() + ".");
    }

    public float getEdge(){
        return this.getHeight() ;
    }
}
