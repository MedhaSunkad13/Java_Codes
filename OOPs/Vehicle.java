public class Vehicle {
    public String name;
    public String model;
    public int noOfTyres;

    Vehicle() {
        this.name = " ";
        this.model = " ";
        this.noOfTyres = -1;
    }
    
    Vehicle(String _name, String _model, int _noOfTyres) {
        this.name = _name;
        this.model = _model;
        this.noOfTyres = _noOfTyres;
    }

    void startEngine() {
        System.out.printf("Engine is starting of %s : %s\n", name, model);
    }

    void stopEngine() {
        System.out.printf("Engine is stopping of %s : %s\n", name, model);
    }
}


