package test.task.word.map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

public class WordMapUtilTest {

    private static final String FILENAME = "files\\source.txt";
    private static final String LETTER_A = "a";
    private static final String LETTER_L = "l";

    @Test
    public void testCreateMapFromFile() {

        WordMap map = WordMapUtil.createMapFromFile(FILENAME);
        Assert.assertThat(map.isEmpty(), is(FALSE));
        Assert.assertThat(map.getGroup(LETTER_A).size(), is(3));
        Assert.assertThat(map.getGroup(LETTER_L).size(), is(3));
    }

    @Test
    public void testCreateMapFromFileException() {
        WordMap map = WordMapUtil.createMapFromFile(LETTER_A);
        Assert.assertThat(map.isEmpty(), is(TRUE));
    }

}
