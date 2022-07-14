package br.com.util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Recebido : " + o);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("ERROR : " + e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completado");
    }
}
