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
    /*
    we have moved criterion method in Car class since they are related to Car object. We have declared this classes as static since criteria is related as a concept to a class Car amd not to particular car instance
     */
     public static CarCriteria getRedCarCriteria(){
         return  RED_CAR_CRITERIA;
     }
     private static final CarCriteria RED_CAR_CRITERIA=new CarCriteria(){
    // private static class RedCarCarCriteria implements CarCriteria {

         @Override
         public boolean test(Car c) {
             return c.color.equals("Red");
         }
     };
//     private static final RedCarCarCriteria RED_CAR_CRITERIA=new RedCarCarCriteria();
//     private static class RedCarCarCriteria implements CarCriteria {
//
//         @Override
//         public boolean test(Car c) {
//             return c.color.equals("Red");
//         }
//     }
     public static CarCriteria getGasLevelCarCriteria(int threshold){
         return new GasLevelCarCarCriteria(threshold);
     }
     private static class GasLevelCarCarCriteria implements CarCriteria {
         private int  threshold;

         public GasLevelCarCarCriteria(int threshold) {
             this.threshold = threshold;
         }

         @Override
         public boolean test(Car c) {
             return c.gasLevel>=threshold;
         }
     }
}
