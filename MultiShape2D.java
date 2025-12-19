public class MultiShape2D extends GeometricShape2D {

    private GeometricShape2D[] shapes ;
    private int nests ;

    MultiShape2D() {
        this.shapes = new GeometricShape2D[0] ;
        this.nests = 0;
    }

    @Override
    public float calculateArea() {
        float area = 0;
        for (GeometricShape2D shape: this.shapes){
            area+= shape.calculateArea() ;
        }
        return area ;
    }
    
    @Override
    public void printInfo(){
        System.out.println("Multi-shape, area " + this.calculateArea() + ".");
    }

    public void printDetail(){
        this.printInfo();
        for (GeometricShape2D shape: this.getShapes()){
            System.out.printf("\n%" + (3 + this.nests*6) + "s-  ", "");
            if (shape instanceof MultiShape2D){
                ((MultiShape2D)shape).printDetail();
            }
            else{
                shape.printInfo();
            }
        }
    }

    public void addShape(GeometricShape2D addedShape) {
        GeometricShape2D[] newShapes = new GeometricShape2D[this.shapes.length + 1] ;
        for (int i = 0; i < this.shapes.length; i++){
            newShapes[i] = this.shapes[i] ;
        }
        if (addedShape instanceof MultiShape2D){
            ((MultiShape2D)addedShape).incrementNests();
        }
        newShapes[newShapes.length - 1] = addedShape ;
        this.shapes = newShapes ;
    }

    public void mergeShapes(){
        float edge = Math.round(Math.sqrt(this.calculateArea())) ;
        this.shapes = new GeometricShape2D[1] ;
        shapes[0] = new Square(edge) ;
    }

    public int getNests() {
        return nests;
    }

    public GeometricShape2D[] getShapes() {
        return shapes;
    }

    public void incrementNests(){
        this.nests++ ;
        for (GeometricShape2D shape : this.shapes){
            if (shape instanceof MultiShape2D){
                ((MultiShape2D)shape).incrementNests();
            }
        }
    }
    
}