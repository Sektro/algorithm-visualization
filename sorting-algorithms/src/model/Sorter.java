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
                bubbleSort();
            }
            case IMPROVED_BUBBLE -> {
                improvedBubbleSort();
            }
            case INSERTION -> {
                insertionSort();
            }
            case MAX -> {
                maxSort();
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
    private void printData() {
        for (int i = 0; i < data.length; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //Sorts
    private void bubbleSort() {
            shuffle(20);
            printData();
            for (int i = data.length; i > 0; --i) {
                for (int j = 0; j < i-1; ++j) {
                    if (data[j] > data[j+1]) {
                        swap(j,j+1);
                    }
                }
            }
            printData();
    }
    private void improvedBubbleSort() {
        shuffle(20);
        printData();
        int i = data.length-1;
        while (i >= 1) {
            int u = -1;
            for (int j = 0; j <= i-1; ++j) {
                if (data[j] > data[j+1]) {
                    swap(j,j+1);
                    u = j;
                }
            }
            i = u;
        }
        printData();
    }
    private void insertionSort() {
        shuffle(20);
        printData();
        for (int i = 1; i < data.length; ++i) {
            if (data[i-1] > data[i]) {
                int x = data[i];
                data[i] = data[i-1];
                int j = i - 2;
                while (j>=0 && data[j] > x) {
                    data[j+1] = data[j];
                    --j;
                }
                data[j+1] = x;
            }
        }
        printData();
    }
    private void maxSort() {
        shuffle(20);
        printData();
        for (int i = data.length-1; i > 0; --i) {
            int ind = 0;
            for (int j = 1; j <= i; ++j) {
                if (data[j] > data[ind]) {
                    ind = j;
                }
            }
            swap(ind,i);
        }
        printData();
    }
}

