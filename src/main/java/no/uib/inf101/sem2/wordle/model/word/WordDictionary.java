package no.uib.inf101.sem2.wordle.model.word;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WordDictionary implements WordDictionaryInterface {
    ArrayList<String> validWords;

    public WordDictionary(String fileName, int wordLength) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(
            new FileReader(file, StandardCharsets.UTF_8)
        );
        List<String> lines = reader.lines().toList();
        reader.close();

        validWords = new ArrayList<String>();
        for (String line : lines) {
            if (line.length() == wordLength){
                validWords.add(line);
            }
        }
    }

    public String getRandomWord(){
        Random random = new Random();
        String randomWord = validWords.get(random.nextInt(validWords.size()));
        return randomWord;
    }

    public Boolean isValidWord() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidWord'");
    }
}