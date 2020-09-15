package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        char[] content = sentence.toCharArray();

        HashMap<Character, Integer> mapa = new HashMap<Character, Integer>();

        for (char ch : content) {
            if (mapa.containsKey(ch)) {
                mapa.put(ch, mapa.get(ch) + 1);
            } else {
                mapa.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> val : mapa.entrySet()) {
            System.out.println(val.getKey() + " " + val.getValue().toString());
        }
    }
}
