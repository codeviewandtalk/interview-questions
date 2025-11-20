package dsa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCode {
    public static void main(String[] args) {

        String str = "hi piyush how are you";


        String res = IntStream.range(0, str.length())
                .mapToObj(i -> i % 2 == 1 ? Character.toUpperCase(str.charAt(i)) : str.charAt(i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        String results = IntStream.range(0, str.length())
                .mapToObj(i -> i == 1 ? Character.toUpperCase(str.charAt(i)) : str.charAt(i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        String result = Arrays.stream(str.split(" "))
                .map(word -> {
                    // If the word has more than one character, change the second character to uppercase
                    if (word.length() > 1) {
                        return word.substring(0, 1) + word.substring(1, 2).toUpperCase() + word.substring(2);
                    }
                    return word; // For single character words, return them as is
                })
                .collect(Collectors.joining(" "));

        System.out.println(result);

        Arrays.stream(str.split(" "))
                .map(word -> {
                    if (word.length() > 1) {
                        return word.substring(0, 1) + word.substring(1, 2).toUpperCase() + word.substring(2);
                    }
                    return word;
                })
                .collect(Collectors.joining(","));

    }
}
