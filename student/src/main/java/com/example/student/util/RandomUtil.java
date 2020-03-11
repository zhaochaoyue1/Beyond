package com.example.student.util;

import java.util.Random;

public class RandomUtil {
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
