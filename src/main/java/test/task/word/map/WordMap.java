package test.task.word.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordMap {

    private TreeMap<String, Set<String>> wordMap = new TreeMap<>();

    public void addSingleWord(String word) {
        String firstLetter = word.substring(0, 1).toLowerCase();

        Set<String> wordSet = wordMap.get(firstLetter);
        if (wordSet != null) { // there are already words starting with the first letter
            wordSet.add(word);
            return;
        } // no words starting with that first letter exist
        Set<String> newSet = new TreeSet<>(new WordComparator());
        newSet.add(word);
        wordMap.put(firstLetter, newSet);
    }

    // printing multiple words groups from the map
    public void printMultiGroups() {
        for (String letter : wordMap.keySet()) {
            Set<String> wordsSet = wordMap.get(letter);
            if (wordsSet.size() > 1) { // to print groups with more than one word
                System.out.println(wordsSet);
            }
        }
    }

    public List<String> getGroup(String letter) {
        return new ArrayList<>(wordMap.get(letter));
    }

    boolean isEmpty() {
        return wordMap.isEmpty();
    }

    public static class WordComparator implements Comparator<String> {

        @Override
        public int compare(String wordOne, String wordTwo) {
            int difference = wordTwo.length() - wordOne.length();
            if (difference != 0) {
                return difference;
            }
            return wordOne.compareTo(wordTwo);
        }

    }

}
