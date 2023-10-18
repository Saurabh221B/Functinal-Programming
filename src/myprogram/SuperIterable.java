package myprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
    Iterable<E> self;

    public SuperIterable(Iterable<E> self) {
        this.self = self;
    }
    public SuperIterable<E> filter(Predicate<E>predicate) {
        List<E> result = new ArrayList<>();
        self.forEach(e -> {
            if (predicate.test(e)){
                result.add(e);
            }
        });
//        for (E e : self) {
//            if (predicate.test(e)) {
//                result.add(e);
//            }
//
//        }
        return new SuperIterable<>(result);
    }
    public <F> SuperIterable<F> map(Function<E,F> fn){
        List<F> result=new ArrayList<>();
        self.forEach(e -> result.add(fn.apply(e)));
        return new SuperIterable<>(result);
    }

//    public void forEvery(Consumer<E>cons){
//        for (E e: self){
//            cons.accept(e);
//        }
//
//    }

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }

    public static void main(String[] args) {
        SuperIterable<String> strings =new SuperIterable<>(Arrays.asList("Saurabh","wagh","Patil"));
//        for(String s:strings){
//            System.out.println(s);
//        }
        strings.forEach(s -> System.out.println(s));
        System.out.println("----------------------------------------------------");
        //SuperIterable<String> strings2 = strings.filter(s ->Character.isUpperCase(s.charAt(0)));
//        for(String s:strings2){
//            System.out.println(s);
//        }
        //strings2.forEach(s -> System.out.println(s));
        strings.filter(x->x.charAt(0)=='S')
                .map(x->x.toUpperCase())
                .forEach(x-> System.out.println(x));
    }

}
