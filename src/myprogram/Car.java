package myprogram;

import java.util.*;

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
     public static Criteria getRedCarCriteria(){
         return  RED_CAR_CRITERIA;
     }
     private static final Criteria<Car> RED_CAR_CRITERIA= (Car c)->  c.color.equals("Red");
     public static Criteria<Car> getFourPassengerCarCriteria(){
         return c -> c.getPassengers().size()==4;
     }
     public static Criteria<Car> getColorCriteria(String...color){
         HashSet<String>colorSet=new HashSet<>(Arrays.asList(color));
         return  c -> colorSet.contains(c.color);
     }
     //trying to derive new behavior by passing existing one as an argument to method parameter
    public static <E>Criteria<E> negate(Criteria<E> cri){
        return  c ->!cri.test(c);
    }
    public static <E>Criteria<E> and(Criteria<E> first, Criteria<E> second){

        return  c -> first.test(c) && second.test(c);
    }
    public static <E>Criteria<E> or(Criteria<E> first, Criteria<E> second){

        return  c -> first.test(c) || second.test(c);
    }



//     private static final CarCriteria RED_CAR_CRITERIA=new CarCriteria(){
//         // private static class RedCarCarCriteria implements CarCriteria {
//
//         @Override
//         public boolean test(Car c) {
//             return c.color.equals("Red");
//         }
//     };
//     private static final RedCarCarCriteria RED_CAR_CRITERIA=new RedCarCarCriteria();
//     private static class RedCarCarCriteria implements CarCriteria {
//
//         @Override
//         public boolean test(Car c) {
//             return c.color.equals("Red");
//         }
//     }

//         return new GasLevelCarCriteria(threshold);
//     }
//     private static class GasLevelCarCriteria implements Criteria<Car> {
//         private int  threshold;
//
//         public GasLevelCarCriteria(int threshold) {
//             this.threshold = threshold;
//         }
//
//         @Override
//         public boolean test(Car c) {
//             return c.gasLevel>=threshold;
//         }
//
//     }
public static Criteria<Car> getGasLevelCarCriteria(int threshold) {
    return (c) -> c.gasLevel >= threshold;
    //variable used in lamda expression for example int threshhld in this case shoud be final..
        }


     public static Comparator<Car> getGasLevelOrderComparator(){
         return GAS_LEVEL_ORDER_COMPARATOR;
     }
     private  static final Comparator<Car> GAS_LEVEL_ORDER_COMPARATOR=(o1,o2)->  o1.getGasLevel() - o2.getGasLevel();

     //private static final  Comparator<Car> GAS_LEVEL_ORDER_COMPARATOR=new Comparator<Car>() {

//         //private static class  GasLevelOrderComparator implements Comparator<Car> {
//         @Override
//         public int compare(Car o1, Car o2) {
//             return o1.getGasLevel() - o2.getGasLevel();
//         }
//     };
}
