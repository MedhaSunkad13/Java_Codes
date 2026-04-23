public class Car extends Vehicle {
    public int noOfDoors;
    public String transmissionType;

    Car(String name, String model, int noOfTyres, int noOfDoors, String transmissionType) {
        super(name, model, noOfTyres);

        this.noOfDoors = noOfDoors;
        this.transmissionType = transmissionType;

        super.startEngine();
        super.stopEngine();
    }

    public void startAC() {
        System.out.println(name +"'s AC started.");
    }
}
