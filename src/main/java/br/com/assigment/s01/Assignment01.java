package br.com.assigment.s01;

import br.com.util.Util;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment01 {

    public static void main(String[] args) throws IOException {

        String fileName = writeFile();
        readFile(fileName);
        deleteFile(fileName);
    }


    private static String writeFile(){
        File file = new File(Util.faker().ancient().titan() + ".txt");
        try (FileWriter fileWriter = new FileWriter(file.getName())) {
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            fileWriter.write(Util.faker().lorem().sentence(5).concat("\n"));
            return file.getName();
        } catch (IOException e) {
            return "Falha ao criar o arquivo.";
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

    private static void readFile(String fileName){
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = bufferedReader.readLine();
            while(linha != null){
                System.out.printf("%s\n", linha);

                linha = bufferedReader.readLine();
            }
            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
