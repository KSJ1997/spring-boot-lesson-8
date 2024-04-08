package ru.gb.springbootlesson8;

import org.springframework.stereotype.Component;

@Timer
@Component
public class MyService {

    @Timer
    public void method1() {
        // Реализация метода
        System.out.println("Работа метода 1");
    }

    @Timer
    public void method2() {
        // Реализация метода
        System.out.println("Работа метода 2");
    }
}
