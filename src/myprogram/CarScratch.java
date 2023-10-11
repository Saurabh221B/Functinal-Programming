package myprogram;


import java.util.*;

class PassengerCountOrder implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPassengers().size()-o2.getPassengers().size();
    }
}

public class CarScratch {
    public static void showAll(List<Car> ls){
        for(Car c : ls){
            System.out.println(c);
        }
        System.out.println("-------------------------------------");
    }
    public static List<Car> getColoredCars(Iterable<Car>in, String color){
        List<Car>output=new ArrayList<>();
        for(Car c : in){
            if(c.getColor().equals(color)){
                output.add(c);
            }
        }
        return output;
    }
    public static List<Car> getCarsByGasLevel(Iterable<Car>in, int gasLevel){
        List<Car>output=new ArrayList<>();
        for(Car c : in){
            if(c.getGasLevel()>=gasLevel){
                output.add(c);
            }
        }
        return output;
    }
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
        showAll(getColoredCars(cars,"Red"));
        cars.sort(new PassengerCountOrder());
        showAll(cars);
    }
}
