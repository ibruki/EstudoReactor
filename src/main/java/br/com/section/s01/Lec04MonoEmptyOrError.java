package br.com.section.s01;

import br.com.util.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {

        userRepository(20)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId){

        if(userId == 1){
            return Mono.just(Util.FAKER.name().firstName());
        }else if(userId == 2){
            return Mono.empty();
        }else
            return Mono.error(new RuntimeException("Não encontrado"));
    }
}
