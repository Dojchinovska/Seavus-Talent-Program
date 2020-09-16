package com.company;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String sentence = new Scanner(System.in).nextLine();
        char[] content = sentence.toCharArray();
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();

        for (char c : content) {
            m.put(c, (m.containsKey(c) ? m.get(c) + 1 : 1));
        }
        for (HashMap.Entry<Character, Integer> val : m.entrySet()) {
            System.out.println("Character: " + val.getKey() + "  Number of occurrences: " + val.getValue().toString());
        }
    }
}
