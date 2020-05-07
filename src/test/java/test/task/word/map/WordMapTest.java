package test.task.word.map;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordMapTest {

    private static final String LETTER_L = "l";
    private static final String WORD_ONE = "Last";
    private static final String WORD_TWO = "Lambda";
    private static final String WORD_THREE = "Letter";
    private static final String LETTER_J = "j";
    private static final String WORD_FOUR = "Java";

    private WordMap map = new WordMap();

    @Before
    public void init() {
        map.addSingleWord(WORD_ONE);
        map.addSingleWord(WORD_TWO);
        map.addSingleWord(WORD_THREE);
        map.addSingleWord(WORD_FOUR);
    }

    @Test
    public void testAddSingleWord() {
        List<String> groupL = map.getGroup(LETTER_L);
        Assert.assertEquals(3, groupL.size());
        Assert.assertEquals(groupL.get(0), WORD_TWO);
        Assert.assertEquals(groupL.get(1), WORD_THREE);
        Assert.assertEquals(groupL.get(2), WORD_ONE);

        List<String> groupJ = map.getGroup(LETTER_J);
        Assert.assertEquals(1, groupJ.size());
        Assert.assertEquals(groupJ.get(0), WORD_FOUR);
    }

}
