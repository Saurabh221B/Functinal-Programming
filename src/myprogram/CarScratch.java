package myprogram;


import java.util.*;

class PassengerCountOrder implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPassengers().size()-o2.getPassengers().size();
    }
}
//class GasLevelOrderComparator implements Comparator<Car>{
//
//    @Override
//    public int compare(Car o1, Car o2) {
//        return o1.getGasLevel()- o2.getGasLevel();
//
//        }
//    }


/*passing behavior as an argument to make our filtering mechanism more generalize
Now it is possible for the caller to pass specific filtering mechanism impl to our selection method.
 */

interface CarCriteria {
  boolean test(Car c);
}
//class RedCarCriteria implements Criteria{
//
//    @Override
//    public boolean test(Car c) {
//        return c.getColor().equals("Red");
//    }
//}
//class GasLevelCarCriteria implements Criteria{
//    private int  threshold;
//
//    public GasLevelCarCriteria(int threshold) {
//        this.threshold = threshold;
//    }
//
//    @Override
//    public boolean test(Car c) {
//        return c.getGasLevel()>=threshold;
//    }
//}


public class CarScratch {
    public static void showAll(List<Car> ls){
        for(Car c : ls){
            System.out.println(c);
        }
        System.out.println("-------------------------------------");
    }
    public static List<Car> getCarsByCriteria(Iterable<Car>in, CarCriteria cr){
        List<Car>output=new ArrayList<>();
        for(Car c : in){
            //Here decison making is based on object(wrapping the behaviour needed to take desicion) criteria which is pass by caller as argument
            if(cr.test(c)){
                output.add(c);
            }
        }
        return output;
    }

//    public static List<Car> getColoredCars(Iterable<Car>in, String color){
//        List<Car>output=new ArrayList<>();
//        for(Car c : in){
//            if(c.getColor().equals(color)){
//                output.add(c);
//            }
//        }
//        return output;
//    }
//    public static List<Car> getCarsByGasLevel(Iterable<Car>in, int gasLevel){
//        List<Car>output=new ArrayList<>();
//        for(Car c : in){
//            if(c.getGasLevel()>=gasLevel){
//                output.add(c);
//            }
//        }
//        return output;
//    }
    public static void main(String[] args) {
        List<Car> cars= Arrays.asList(
                Car.withGasColorPassenger(6,"Red","Saurabh","csp","adi"),
                Car.withGasColorPassenger(4,"Black","Saurabh","csp"),
                Car.withGasColorPassenger(3,"Red","Saurabh","bhim","adi"),
                Car.withGasColorPassenger(9,"Orange","Sanket","csp","adi","bhim","Saurabh"),
                Car.withGasColorPassenger(6,"white","Saurabh")
                );



	// write your code here

        showAll(cars);
        showAll(getCarsByCriteria(cars,Car.getRedCarCriteria()));
        showAll(getCarsByCriteria(cars,Car.getGasLevelCarCriteria(4)));
        cars.sort( Car.getGasLevelOrderComparator());
        showAll(cars);
        showAll(getCarsByCriteria(cars,Car.getFourPassengerCarCriteria()));
    }
}
