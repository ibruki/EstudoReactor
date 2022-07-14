package br.com.section.s01;

import br.com.util.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                        .map(String::length)
                                .map(l -> l / 1);

       // mono.subscribe();

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
