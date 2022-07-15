package br.com.section.s01;

import br.com.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {

        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        getName();

        System.out.println(name);

        Util.sleepSeconds(4);
    }


    private static Mono<String> getName(){
        System.out.println("Entrou no método getName");
        return Mono.fromSupplier(() -> {
            System.out.println("Gerando nome...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
