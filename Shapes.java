import java.util.Scanner ;
public class Shapes {
    
    private static GeometricShape2D [] twoDShapes = new GeometricShape2D [0] ;
    private static GeometricShape2D [] threeDShapes = new GeometricShape2D [0] ;
    private static Scanner sc = new Scanner(System.in) ;

    public static void main(String[] args) {
        
        int choice ;
        do {
            System.out.print("\n  Welcome to the Menu!\n\n1- Create a shape\n2- Add an Existing Shape to a Multi-Shape\n3- List All Shapes\n4- Merge Multi-Shapes\n5- Edit a Shape\n6- Quit\n\nEnter Your Choice: ");
            choice = sc.nextInt() ;
            sc.nextLine() ;
            System.out.println();
            switch (choice) {
                case 1:
                createShape() ;
                System.out.println("Successfully Created.");
                    break ;
                case 2:
                int count = 0 ;
                for (GeometricShape2D shape : twoDShapes){
                    if (shape instanceof MultiShape2D){
                        count++ ;
                    }
                }
                if (twoDShapes.length > 1 && count > 0){
                    addToMultiShape();
                }
                else{
                    System.out.println("Not enough 2D Shapes or Multi-Shapes.");
                }
                    break ;
                case 3:
                    listAllShapes() ;
                    break ;
                case 4:
                    mergeMultiShapes() ;
                    break ;
                case 5:
                    editShape() ;
                    break ;
                case 6:
                    System.out.println("  Goodbye!");
                    break;
            }
        }
        while (choice != 6) ;
    }

    public static void createShape() {
        int choice ;
        System.out.print("\nChoose a shape to create.\n\n" + twoDshapeList() + "6- MultiShape2D\n7- Cuboid\n8- Sphere\n9- Cylinder\n10- Cube\n11- Pyramid\nEnter Your Choice: ");
        choice = sc.nextInt() ;
        sc.nextLine() ;
        System.out.println();
        switch (choice) {
            case 1:
                twoDShapes = addToArray(twoDShapes, createRectangle()) ;
                break ;
            case 2:
                twoDShapes = addToArray(twoDShapes, createCircle()) ;
                break ;
            case 3:
                twoDShapes = addToArray(twoDShapes, createSquare()) ;
                break ;
            case 4:
                twoDShapes = addToArray(twoDShapes, createEllipse()) ;
                break ;
            case 5:
                twoDShapes = addToArray(twoDShapes, createEquilateralTriangle()) ;
                break ;
            case 6:
                twoDShapes = addToArray(twoDShapes, createMultiShape2D()) ;
                break;
            case 7:
                threeDShapes = addToArray(threeDShapes, createCuboid()) ;
                break ;
            case 8:
                threeDShapes = addToArray(threeDShapes, createSphere()) ;
                break ;
            case 9:
                threeDShapes = addToArray(threeDShapes, createCylinder()) ;
                break ;
            case 10:
                threeDShapes = addToArray(threeDShapes, createCube()) ;
                break ;
            case 11:
                threeDShapes = addToArray(threeDShapes, createPyramid()) ;
                break ;
        }
    }

    public static void addToMultiShape(){
        System.out.println("Choose a Multi-Shape to add shapes:");
        GeometricShape2D[] multis = new MultiShape2D[0] ;
        for (GeometricShape2D shape : twoDShapes){
            if (shape instanceof MultiShape2D){
                multis = addToArray(multis, shape) ;
                System.out.print(multis.length + "- ");
                shape.printInfo();
            }
        }
        System.out.print("Enter your choice: ");
        int i = sc.nextInt();
        int m ;
        do{
            System.out.println("\nChoose a Shape to add to Multi-Shape:");
            for (int k = 0; k < twoDShapes.length; k++){
                if (!twoDShapes[k].equals(multis[i-1])){
                    System.out.print(k + 1 + "- ");
                    twoDShapes[k].printInfo();
                }
            }
            System.out.print("Enter shape index or -1 to return to the menu: ");
            m = sc.nextInt();
            if (m != -1){
                ((MultiShape2D) multis[i-1]).addShape(twoDShapes[m-1]);
                twoDShapes = removeFromArray(twoDShapes, m-1);
                System.out.println("Successfully Added!");
            }
        } while(m != -1) ;
    }

    public static void listAllShapes(){
        int choice ;
        do{
            System.out.println("\n2D Shapes:\n");
            for (int i = 0; i < twoDShapes.length; i++){
                System.out.print(i + 1 + "- ");
                twoDShapes[i].printInfo();
            }
            System.out.println("\n3D Shapes:\n");
            for (int i = 0; i < threeDShapes.length; i++){
                System.out.print(i + twoDShapes.length + 1 + "- ");
                threeDShapes[i].printInfo();
            }
            System.out.print("\nDo you want details for a specific shape? Enter shape index or -1 to return: ");
            choice = sc.nextInt() ;
            System.out.println();
            if (choice != -1){
                if (choice <= twoDShapes.length){
                    if (twoDShapes[choice-1] instanceof MultiShape2D){
                        ((MultiShape2D) twoDShapes[choice-1]).printDetail();
                    }
                    else{
                        twoDShapes[choice-1].printInfo();
                        System.out.println("Area: " + twoDShapes[choice-1].calculateArea() + ".");
                    }
                }
                else{
                    GeometricShape3D shape = (GeometricShape3D) (threeDShapes[choice -1 -twoDShapes.length]) ;
                    shape.printInfo();
                    System.out.println("Area: " + shape.calculateArea() + " and Volume: " + shape.calculateVolume());
                }
            }
        } while (choice != -1) ;
    }

    public static void mergeMultiShapes(){
        for (GeometricShape2D shape : twoDShapes){
            if (shape instanceof MultiShape2D){
                ((MultiShape2D)shape).mergeShapes();
            }
        }
        System.out.println("All Multi-Shapes are Merged Successfully.");
    }

    public static void editShape(){
        System.out.println("Choose a shape to edit.\n");
        int i ;
        for (i = 0; i < twoDShapes.length; i++){
            if (!(twoDShapes[i] instanceof MultiShape2D)){
                System.out.print(i + 1 + "- ");
                twoDShapes[i].printInfo();
            }
        }
        for (GeometricShape2D shape : threeDShapes){
                System.out.print(i+1 + "- ");
                shape.printInfo();
                i++ ;
        }
        System.out.print("Your choice: ");
        int choice = sc.nextInt() ;
        System.out.println("\nEnter the new lengths for the shape.");
        if (choice <= twoDShapes.length){
            if(twoDShapes[choice-1] instanceof Square){
                twoDShapes[choice-1] = createSquare() ;
            }
            else if(twoDShapes[choice-1] instanceof Rectangle){
                twoDShapes[choice-1] = createRectangle() ;
            }
            else if(twoDShapes[choice-1] instanceof Circle){
                twoDShapes[choice-1] = createCircle() ;
            }
            else if(twoDShapes[choice-1] instanceof Ellipse){
                twoDShapes[choice-1] = createEllipse() ;
            }
            else if(twoDShapes[choice-1] instanceof EquilateralTriangle){
                twoDShapes[choice-1] = createEquilateralTriangle() ;
            }
        }
        else{
            if(threeDShapes[choice-twoDShapes.length-1] instanceof Cube){
                threeDShapes[choice-twoDShapes.length-1] = createCube() ;
            }
            else if(threeDShapes[choice-twoDShapes.length-1] instanceof Cuboid){
                threeDShapes[choice-twoDShapes.length-1] = createCuboid() ;
            }
            else if(threeDShapes[choice-twoDShapes.length-1] instanceof Cylinder){
                threeDShapes[choice-twoDShapes.length-1] = createCylinder() ;
            }
            else if(threeDShapes[choice-twoDShapes.length-1] instanceof Sphere){
                threeDShapes[choice-twoDShapes.length-1] = createSphere() ;
            }
            else if(threeDShapes[choice-twoDShapes.length-1] instanceof Pyramid){
                threeDShapes[choice-twoDShapes.length-1] = createPyramid() ;
            }
        }
        System.out.println("Successfully Edited.");
    }

    /** Returns the list 2D shape types without Multi-Shape */
    public static String twoDshapeList(){
        return "1- Rectangle\n2- Circle\n3- Square\n4- Ellipse\n5- Equilateral Triangle\n" ;
    }
    
    public static Rectangle createRectangle () {
        System.out.print("Rectangle's Width: ");
        float width = sc.nextFloat() ;
        System.out.print("Rectangle's Height: ");
        float height = sc.nextFloat() ;
        return new Rectangle(width, height) ;
    }

    public static Square createSquare () {
        System.out.print("Square's Edge Length: ");
        float edge = sc.nextFloat() ;
        return new Square(edge) ;
    }

    public static Circle createCircle () {
        System.out.print("Circle's Radius: ");
        float radius = sc.nextFloat() ;
        return new Circle(radius) ;
    }

    public static Ellipse createEllipse () {
        System.out.print("Ellipse's Semi-Major axis Length: ");
        float major = sc.nextFloat() ;
        System.out.print("Ellipse's Semi-Minor axis Length: ");
        float minor = sc.nextFloat() ;
        return new Ellipse(major, minor);
    }

    public static EquilateralTriangle createEquilateralTriangle () {
        System.out.print("Equilateral Triangle's Height: ");
        float height = sc.nextFloat() ;
        System.out.print("Equilateral Triangle's Base Length: ");
        float base = sc.nextFloat() ;
        return new EquilateralTriangle(height, base) ;
    }

    public static Cube createCube () {
        System.out.print("Cube's Edge Length: ");
        float edge = sc.nextFloat() ;
        return new Cube(edge) ;
    }

    public static Cuboid createCuboid () {
        System.out.print("Cuboid's Width: ");
        float width = sc.nextFloat() ;
        System.out.print("Cuboid's Length: ");
        float length = sc.nextFloat() ;
        System.out.print("Cuboid's Height: ");
        float height = sc.nextFloat() ;
        return new Cuboid(width, length, height) ;
    }

    public static Cylinder createCylinder () {
        System.out.print("Cylinder's Height: ");
        float height = sc.nextFloat() ;
        System.out.print("Cylinder's Base Radius: ");
        float radius = sc.nextFloat() ;
        return new Cylinder(radius, height) ;
    }

    public static Pyramid createPyramid () {
        System.out.print("Pyramid's Height: ");
        float height = sc.nextFloat() ;
        System.out.print("Pyramid's Base Edge Length: ");
        float baseEdge = sc.nextFloat() ;
        return new Pyramid(height, baseEdge) ;
    }

    public static Sphere createSphere () {
        System.out.print("Sphere's Radius Length: ");
        float radius = sc.nextFloat() ;
        return new Sphere(radius) ;
    }

    public static MultiShape2D createMultiShape2D() {
        MultiShape2D newMultiShape = new MultiShape2D() ;
        System.out.println("Multi-Shape is created, you can create new shapes inside this Multi-Shape.\n");
        int choice ;
        do{
            System.out.print("1- Create shapes inside the new multi-shape\n2- Return to the menu\n\nEnter your choice: ");
            choice = sc.nextInt() ;
            if (choice == 1){
                System.out.print("Choose a 2D shape to create in the multi-shape:\n" + twoDshapeList() + "Enter your choice: ");
                int i = sc.nextInt();
                switch (i) {
                    case 1:
                        newMultiShape.addShape(createRectangle()); 
                        break ;
                    case 2:
                        newMultiShape.addShape(createCircle());
                        break ;
                    case 3:
                        newMultiShape.addShape(createSquare());
                        break ;
                    case 4:
                        newMultiShape.addShape(createEllipse());
                        break ;
                    case 5:
                        newMultiShape.addShape(createEquilateralTriangle());
                        break ;
                }
                System.out.println("Created in the multi-shape.\n");
            }
        } while (choice == 1) ;

        return newMultiShape ;
    }

    public static GeometricShape2D[] addToArray (GeometricShape2D [] arr, GeometricShape2D obj){
        GeometricShape2D [] newArr = new GeometricShape2D[arr.length + 1] ;
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i] ;
        }
        newArr[newArr.length-1] = obj ;
        return newArr ;
    }

    public static GeometricShape2D[] removeFromArray (GeometricShape2D [] arr, int index){
        GeometricShape2D [] newArr = new GeometricShape2D[arr.length - 1] ;
        for (int i = 0; i < newArr.length; i++){
            if (i >= index){
                newArr[i] = arr[i+1] ;
            }
            else{
                newArr[i] = arr[i] ;
            }
        }
        return newArr ;
    }
}
