package ru.gb.springbootlesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootLesson8Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootLesson8Application.class, args);

        MyService myService = context.getBean(MyService.class);
        myService.method1();
        myService.method2();
    }
}
