package com.example.algorithm.dfa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: DFA
 * @date: 2023/4/9 下午3:58
 * @author: zcy
 * @version: 1.0
 */
public class DFA {

    private final int[][] transitionTable;
    private final boolean[] acceptStates;

    public DFA(int[][] transitionTable, boolean[] acceptStates) {
        this.transitionTable = transitionTable;
        this.acceptStates = acceptStates;
    }

    public boolean match(String input) {
        int state =0;
        for (int i =0; i < input.length(); i++) {
            char c = input.charAt(i);
            state = transitionTable[state][c - 'a'];
            if (state == -1) {
                return false;
            }
        }
        return acceptStates[state];
    }

    public static DFA build(List<String> words) {
        int maxState =0;
        for (String word : words) {
            maxState += word.length();
        }

        int[][] transitionTable = new int[maxState +1][26];
        boolean[] acceptStates = new boolean[maxState +1];

        int state =1;
        for (String word : words) {
            int currState =0;
            for (int i =0; i < word.length(); i++) {
                char c = word.charAt(i);
                int nextState = transitionTable[currState][c - 'a'];
                if (nextState ==0) {
                    nextState = state++;
                    transitionTable[currState][c - 'a'] = nextState;
                }
                currState = nextState;
            }
            acceptStates[currState] = true;
        }

        for (int i =0; i <26; i++) {
            if (transitionTable[0][i] ==0) {
                transitionTable[0][i] =1;
            }
        }

        for (int i =0; i <= maxState; i++) {
            for (int j =0; j <26; j++) {
                if (transitionTable[i][j] ==0) {
                    transitionTable[i][j] = -1;
                }
            }
        }

        return new DFA(transitionTable, acceptStates);
    }

    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line);
        }
        reader.close();

        DFA dfa = DFA.build(words);

        System.out.println(dfa.match("apple"));
        System.out.println(dfa.match("banana"));
        System.out.println(dfa.match("orange"));
    }
}
