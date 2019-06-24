package tal.utils;

import java.util.Random;

public class DataSetGenerator {

    private Random randGen;

    public DataSetGenerator() {
        randGen = new Random();
        randGen.setSeed(System.currentTimeMillis() + 5);
    }

    public int[] generateRandomIntegerArray(int minValue, int maxValue, int length) {
        randGen.setSeed(System.currentTimeMillis() - minValue + maxValue + length - 5);
        int[] randArray = new int[length];

        for(int i = 0; i < length; i++) {
            randArray[i] = minValue + randGen.nextInt((maxValue - minValue) + 1);
        }
        return randArray;
    }
}
