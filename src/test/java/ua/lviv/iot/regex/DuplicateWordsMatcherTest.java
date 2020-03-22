package ua.lviv.iot.regex;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class DuplicateWordsMatcherTest {

    @Test
    void twoDuplicatesTest() {
        String inputText = "In my younger and more vulnerable years my father gave me some advice that I've been turning over in my mind ever since.";
        int inputCount = 2;
        String input = inputText + "\n" + inputCount;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int countOfDupliates = scanner.nextInt();

        List<String> actualWords = DuplicateWordsMatcher.getDuplicateWords(text, countOfDupliates);
        assertEquals("in", actualWords.get(0));
        assertEquals("my", actualWords.get(1));
        assertEquals(2, actualWords.size());
    }

}
