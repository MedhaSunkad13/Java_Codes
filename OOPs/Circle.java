public class Circle extends Shape {
    
    //Not mandatory to write this @Override, it is jzt for understanding
    //Draw function is polymorphic, it has many forms which all the subclasses are overriding
    @Override
    public void draw() {
        System.out.println("Circle is drawn");
    }
}
