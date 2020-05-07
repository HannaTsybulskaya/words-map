package test.task;

import test.task.word.map.WordMap;
import test.task.word.map.WordMapUtil;

public class Application {

    public static void main(String[] args) {

        String fileName = "files\\source.txt";
        WordMap map = WordMapUtil.createMapFromFile(fileName);
        map.printMultiGroups();

    }

}
