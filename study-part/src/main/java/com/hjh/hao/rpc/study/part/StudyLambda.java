package com.hjh.hao.rpc.study.part;

import java.util.Arrays;
import java.util.List;

/**
 * @author haojiahong created on 2019/12/11
 */
public class StudyLambda {

    public static void main(String[] args) {
        //下面这两种方式是一样的
        Car car1 = Car.create(Car::new);
        Car car = Car.create(() -> new Car());

        //下面这两种方式是一样的
        List<Car> cars = Arrays.asList(car);
        cars.forEach((Car::repair));
        cars.forEach((car2 -> car2.repair()));
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    static class Car {
        //Supplier是jdk1.8的接口，这里和lamda一起使用了
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }
}
