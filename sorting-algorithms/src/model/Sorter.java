package model;

import java.util.Random;
import javax.swing.SwingUtilities;

public class Sorter {
    private final int[] data = new int[Constants.DATA_LENGTH];
    private Runnable updateCallback;
    public int[] getData() {
        return data;
    }

    private int activeIndex1 = -1;
    private int activeIndex2 = -1;
    public int getActiveIndex1() { return activeIndex1; }
    public int getActiveIndex2() { return activeIndex2; }

    private void resetActiveIndices() {
        activeIndex1 = -1;
        activeIndex2 = -1;
        updateUI();
    }

    public Sorter() {
        for (int i = 0; i < Constants.DATA_LENGTH; data[i] = ++i) {}
    }

    public void setUpdateCallback(Runnable updateCallback) {
        this.updateCallback = updateCallback;
    }

    // Triggers the UI update and pauses the background thread
    private void updateUI() {
        if (updateCallback != null) {
            SwingUtilities.invokeLater(updateCallback);
            try {
                Thread.sleep(Constants.SORT_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void callAlgorithm(Algorithms algorithm) {

        // Run on a background thread to prevent freezing the UI
        new Thread(() -> {
            switch (algorithm) {
                case BUBBLE -> bubbleSort();
                case IMPROVED_BUBBLE -> improvedBubbleSort();
                case INSERTION -> insertionSort();
                case MAX -> maxSort();
            }
        }).start();
    }
    private void swap(int a, int b) {
        activeIndex1 = a;
        activeIndex2 = b;
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
        updateUI();
    }
    private void unnoticableSwap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    private void shuffle() {
        Random rnd = new Random();
        for (int i = 0; i < Constants.STANDARD_SHUFFLE_NUMBER; ++i) {
            int a = rnd.nextInt(0,Constants.DATA_LENGTH);
            int b = rnd.nextInt(0,Constants.DATA_LENGTH);
            unnoticableSwap(a,b);
        }
    }
    private void shuffle(int shuffles) {
        Random rnd = new Random();
        for (int i = 0; i < shuffles; ++i) {
            int a = rnd.nextInt(0,Constants.DATA_LENGTH);
            int b = rnd.nextInt(0,Constants.DATA_LENGTH);
            unnoticableSwap(a,b);
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
            shuffle();
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
        shuffle();
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
        shuffle();
        printData();
        for (int i = 1; i < data.length; ++i) {
            if (data[i-1] > data[i]) {
                int x = data[i];
                activeIndex1 = i;
                activeIndex2 = i - 1;
                data[i] = data[i-1];
                updateUI(); // Notify UI for the shift
                int j = i - 2;
                while (j>=0 && data[j] > x) {
                    activeIndex1 = j + 1;
                    activeIndex2 = j;
                    data[j+1] = data[j];
                    updateUI(); // Notify UI for the shift
                    --j;
                }
                activeIndex1 = j + 1;
                activeIndex2 = -1;
                data[j+1] = x;
                updateUI(); // Notify UI for the shift
            }
        }
        printData();
        resetActiveIndices();
    }
    private void maxSort() {
        shuffle();
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

