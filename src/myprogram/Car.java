package myprogram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 class Car {
    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;

    private Car(int gasLevel, String color, List<String> passengers, List<String> trunkContents) {
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContents = trunkContents;
    }

    public static Car withGasColorPassenger(int gasLevel, String color, String... passengers){
        List<String> p= Collections.unmodifiableList(Arrays.asList(passengers));
        Car self=new Car(gasLevel,color,p,null);
        return self;
    }
    public static Car withGasColorPassengerAndTrunk(int gasLevel, String color, String... passengers){
        List<String> p= Collections.unmodifiableList(Arrays.asList(passengers));
        Car self=new Car(gasLevel,color,p,Arrays.asList("wheel","wrench","Jack"));
        return self;
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public String getColor() {
        return color;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public List<String> getTrunkContents() {
        return trunkContents;
    }
    @Override
    public String toString() {
        return "Car{" +
                "gasLevel=" + gasLevel +
                ", color='" + color + '\'' +
                ", passengers=" + passengers +
                ", trunkContents=" + trunkContents +
                '}';
    }
}
