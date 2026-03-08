package model;

import java.util.Random;

public class Sorter {
    private final int[] data = new int[Constants.DATA_LENGTH];
    public int[] getData() {
        return data;
    }

    public Sorter() {
        for (int i = 0; i < Constants.DATA_LENGTH; data[i] = ++i) {}
    }

    public void callAlgorithm(Algorithms algorithm) {
        
        switch (algorithm) {
            case BUBBLE -> {

            }
        }
    }
    private void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    private void shuffle(int shuffles) {
        Random rnd = new Random();
        for (int i = 0; i < shuffles; ++i) {
            int a = rnd.nextInt(0,Constants.DATA_LENGTH);
            int b = rnd.nextInt(0,Constants.DATA_LENGTH);
            swap(a,b);
        }
    }

    //Sorts
    private void bubblesort() {
        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data.length-i; ++j) {
                if (data[j] > data[j+1]) {
                    swap(j,j+1);
                }
            }
        }
    }
}
