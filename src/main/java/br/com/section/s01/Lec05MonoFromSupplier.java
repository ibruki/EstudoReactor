package br.com.section.s01;

import br.com.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {
        //apenas usar se você já possui o dado, não funciona quando o retorno é new
        //Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = Lec05MonoFromSupplier::getName;

        Callable<String> stringCallable = Lec05MonoFromSupplier::getName;
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );

        //usar supplier, quando retorno for um novo objeto
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );
    }

    private static String getName(){
        System.out.println("Gerando nome...");
        return Util.faker().name().fullName();
    }
}
