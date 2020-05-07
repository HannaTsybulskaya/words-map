package test.task.word.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class WordMapUtil {

    private static final Pattern DEFAULT_SEPARATOR = Pattern.compile(" ");

    public static WordMap createMapFromFile(String filename) {
        WordMap wordMap = new WordMap();
        try {
            List<String> input = Files.readAllLines(Paths.get(filename));
            for (String line : input) {
                for (String word : DEFAULT_SEPARATOR.split(line)) {
                    wordMap.addSingleWord(word);
                }
            }
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
        return wordMap;
    }

}
