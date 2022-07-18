package br.com.assigment.s01;

import br.com.util.Util;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Assignment01 {
    public static void main(String[] args) throws IOException {

        Mono<String> fileName = createFile();
            fileName.subscribe(
                    () -> writeFile(),
                    Util.onError());

        readFile(fileName);
        deleteFile(fileName);
    }


    private static Mono<String> createFile(){
        return Mono.fromSupplier(
                () -> {
                    Util.sleepSeconds(3);
                    return new File(Util.faker().ancient().titan() + ".txt").getName();
                });
    }

    private static void writeFile(String fileName){
        try {
            Files.writeString(Paths.get(fileName), Util.faker().lorem().sentence(5).concat("\n"));
            Files.writeString(Paths.get(fileName), Util.faker().lorem().sentence(5).concat("\n"));
            Files.writeString(Paths.get(fileName), Util.faker().lorem().sentence(5).concat("\n"));
            Files.writeString(Paths.get(fileName), Util.faker().lorem().sentence(5).concat("\n"));
            Files.writeString(Paths.get(fileName), Util.faker().lorem().sentence(5).concat("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Boolean deleteFile(String fileName) {
        try {
            return Files.deleteIfExists(Paths.get("C:\\Users\\vito\\git\\EstudoReactor\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String readFile(String fileName){
        try {
            return Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
