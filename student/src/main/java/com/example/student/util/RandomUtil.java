package com.example.student.util;

import java.util.Random;

public class RandomUtil {
    public static int random(int min, int max) {
        if (min > max || max == 0) {
            return 0;
        }
        if (min == max) {
            return min;
        }
        int diff = max - min + 1;
        Random random = new Random();
        int value = random.nextInt(diff) + min;
        return value;
    }
}
