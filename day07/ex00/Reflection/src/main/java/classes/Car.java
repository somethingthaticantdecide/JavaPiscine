package classes;

public class Car {
    private String mark;
    private String model;
    private int gosNumber;

    public Car() {
        this.gosNumber = 0;
        this.mark = "Default mark";
        this.model = "Default model";
    }

    public Car(int gosNumber, String mark, String model) {
        this.gosNumber = gosNumber;
        this.mark = mark;
        this.model = model;
    }

    public int gosNumberInc(){
        return (++gosNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "gosNumber=" + gosNumber +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
