package ua.lviv.iot.regex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWordsMatcher {
    public static List<String> getDuplicateWords(String text, Integer countOfDuplicates) {
        Pattern pattern = Pattern.compile(
                String.format("(?s)(\\b\\w+\\b)(?=(.*\\b\\1\\b.*){%d,})", countOfDuplicates - 1),
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        Set<String> duplicateWords = new HashSet<>();
        while (matcher.find()) {
            duplicateWords.add(matcher.group().toLowerCase());
        }
        return new ArrayList<String>(duplicateWords);
    }
}
