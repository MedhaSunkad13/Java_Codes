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
    }
}
