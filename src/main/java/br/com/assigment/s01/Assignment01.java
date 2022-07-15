package br.com.assigment.s01;

import br.com.util.Util;
import reactor.core.publisher.Mono;

import java.io.*;

public class Assignment01 {

    public static void main(String[] args) throws IOException {


    }


    private static String writeFile(){
        File file = new File(Util.faker().ancient().titan() + ".txt");
        try (FileWriter fileWriter = new FileWriter(file.getName())) {
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            return "Arquivo criado com sucesso.";
        } catch (IOException e) {
            return "Falha ao criar o arquivo.";
        }
    }

    private static String deleteFile(String name){
        try {
            FileReader fileReader = new FileReader()
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
