package com.example.random;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        random(0,10);
    }

    private static int random(int min, int max) {
        if (min > max || max == 0) {
            return 0;
        }
        int diff = max-min+1;
        Random random = new Random();
        int value = random.nextInt(diff)+min;
        return value;
    }
}
