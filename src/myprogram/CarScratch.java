package myprogram;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarScratch {
    public static void showAll(List<Car> ls){
        for(Car c : ls){
            System.out.println(c);
        }
        System.out.println("-------------------------------------");
    }
    public static List<Car> getRedCars(List<Car>in){
        List<Car>output=new ArrayList<>();
        for(Car c : in){
            if(c.getColor().equals("Red")){
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
        showAll(getRedCars(cars));
    }
}
