package com.company;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        String sentence = new Scanner(System.in).nextLine();
        char[] content = sentence.toCharArray();

        HashMap<Character, Integer> mapa = new HashMap<Character, Integer>();

        for (char ch : content) {
            if (mapa.containsKey(ch)) {
                mapa.put(ch, mapa.get(ch) + 1);
            } else {
                mapa.put(ch, 1);
            }
        }

        for (HashMap.Entry<Character, Integer> val : mapa.entrySet()) {
            System.out.println("Character: " + val.getKey() + "  Number of occurrences: " + val.getValue().toString());
        }

    }
}
