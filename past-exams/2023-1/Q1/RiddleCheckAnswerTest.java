package Q1;

import org.junit.Test;
import static org.junit.Assert.*;

public class RiddleCheckAnswerTest {

    @Test
    public void tests() {
        Riddle rt = new Riddle("?", "Apple", Riddle.RiddleType.TEXT_RIDDLE);
        Riddle rn = new Riddle("?", "10", Riddle.RiddleType.NUMERIC_RIDDLE);
        Riddle ra = new Riddle("?", "Apple", Riddle.RiddleType.ANAGRAM_RIDDLE);
        Riddle rnull = new Riddle("?", "Apple", null);

        //Text Riddle, Correct Answer
        assertTrue("test1", rt.checkAnswer("Apple"));
        //Text Riddle, Wrong Answer
        assertFalse("test2", rt.checkAnswer("Apples"));

        //Numeric Riddle, Correct Answer
        assertTrue("test3", rn.checkAnswer("10"));
        assertFalse("Non-numeric input short-circuits parsing", rn.checkAnswer("abc"));

        //Numeric Riddle, Wrong Answer
        assertFalse("test4", rn.checkAnswer("12"));

        //Anagram Riddle, Correct Answer
        assertTrue("test5", ra.checkAnswer("Lappe"));
        //Anagram Riddle, Wrong Answer
        assertFalse("test6", ra.checkAnswer("Lapel"));

        //Null riddle to test failing else if for Anagram
        assertFalse("test7", rnull.checkAnswer("Apple"));

    }

}