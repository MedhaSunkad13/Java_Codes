
// abstract class Bird{

//     abstract void fly();

//     abstract void eat();

//     public void sleep() {
//         System.out.println("Bird is sleeping!");
//     }
// }

// class Sparrow extends Bird{

//     @Override
//     void fly() {
//         System.out.println("Sparrow is flying!");
//     }

//     @Override
//     void eat() {
//         System.out.println("Sparrow is eating!");
//     }
// }

// class Crow extends Bird{

//     @Override
//     void fly() {
//         System.out.println("Crow is flying!");
//     }

//     @Override
//     void eat() {
//         System.out.println("Crow is eating!");
//     }
// }

// public class Main {
    // public static void main(String[] args) {
        // Car c = new Car("Maruti", "800", 4, 5, "Auto");

        // c.startEngine();
        // c.startAC();
        // c.stopEngine();

//         Motorcycle m = new Motorcycle("Royal Enfield", "Classic 350", 2, "Wide", "Twin Shock Absorbers");

//         m.startEngine();
//         m.wheelie();
//         m.stopEngine();

//         //Compile time polymorphism
//         //Function Overloading
//         Calculator c = new Calculator();

//         System.out.println(c.add(10, 15));
//         System.out.println(c.add(25, 10, 40));

//         Circle cl = new Circle();
//         Shape s = new Shape();

//         //Upcasting
//         doDrawingStuff(cl);
//         doDrawingStuff(s);

//         //Downcasting
//         Circle c1 = new Circle();
//         doDrawingStuff(c1);

//     Bird b = new Sparrow();
//         b.fly();
//         b.eat();

//         b = new Crow();
//         b.fly();
//         b.eat();

//         doBirdStuff(new Sparrow());
//         doBirdStuff(new Crow());
//     }

//     public static void doBirdStuff(Bird b) {
//         b.fly();
//         b.eat();
//     }

//     public static void doDrawingStuff(Shape s) {
//     s.draw();

//         if (s instanceof Circle) {
//             Circle c = (Circle) s;
//             c.draw();
//         } else {
//             System.out.println("Not a Circle, skipping downcast");
//         }
//     }

// }

//Interface

interface Bird {
    void fly();

    void eat();

    default void sleep() {
        System.out.println("Bird sleep!");
    }
}

abstract class Bird1 {

    abstract void fly();

    abstract void eat();

    public void sleep() {
        System.out.println("Bird is sleeping!");
    }
}

class Sparrow implements Bird {

    @Override
    public void fly() {
        System.out.println("Sparrow is flying2!");
        System.out.println("Sparrow is flying3!");
        System.out.println("Sparrow is flying4!");
        System.out.println("Sparrow is flying5!");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow is eating!");
    }
}

class Crow implements Bird {

    @Override
    public void fly() {
        System.out.println("Crow is flying!");
    }

    @Override
    public void eat() {
        System.out.println("Crow is eating!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Car c = new Car("Maruti", "800", 4, 5, "Auto");

        // c.startEngine();
        // c.startAC();
        // c.stopEngine();

        Motorcycle m = new Motorcycle("Royal Enfield", "Classic 350", 2, "Wide", "Twin Shock Absorbers");

        m.startEngine();
        m.wheelie();
        m.stopEngine();

        // Compile time polymorphism
        // Function Overloading
        Calculator c = new Calculator();

        System.out.println(c.add(10, 15));
        System.out.println(c.add(25, 10, 40));

        Circle cl = new Circle();
        Shape s = new Shape();

        // Upcasting
        doDrawingStuff(cl);
        doDrawingStuff(s);

        // Downcasting
        Circle c1 = new Circle();
        doDrawingStuff(c1);

        Bird b = new Sparrow();
        b.fly();
        b.eat();

        b = new Crow();
        b.fly();
        b.eat();

        doBirdStuff(new Sparrow());
        doBirdStuff(new Crow());
    }

    public static void doBirdStuff(Bird b) {
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.sleep();
    }

    public static void doDrawingStuff(Shape s) {
        s.draw();

        if (s instanceof Circle) {
            Circle c = (Circle) s;
            c.draw();
        } else {
            System.out.println("Not a Circle, skipping downcast");
        }
    }

}
