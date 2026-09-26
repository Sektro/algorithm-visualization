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
                case QUICK -> quickSort();
                case MERGE -> mergeSort();
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
        resetActiveIndices();
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
        resetActiveIndices();
    }
    private void insertionSort() {
        shuffle();
        printData();
        for (int i = 1; i < data.length; ++i) {
            if (data[i-1] > data[i]) {
                int x = data[i];
                data[i] = data[i-1];
                updateUI();
                int j = i - 2;
                while (j>=0 && data[j] > x) {
                    activeIndex1 = j + 1;
                    activeIndex2 = j;
                    data[j+1] = data[j];
                    updateUI();
                    --j;
                }
                activeIndex1 = j + 1;
                activeIndex2 = -1;
                data[j+1] = x;
                updateUI();
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
        resetActiveIndices();
    }
    private void quickSort() {
        shuffle();
        printData();
        quickSortRecursion(0,Constants.DATA_LENGTH-1);
        printData();
        resetActiveIndices();
    }
    private void quickSortRecursion(int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int pivot = quickSortPartition(firstIndex,lastIndex);
            quickSortRecursion(firstIndex, pivot-1);
            quickSortRecursion(pivot+1, lastIndex);
        }
    }
    private int quickSortPartition(int firstIndex, int lastIndex) {
        Random rnd = new Random();
        int i = rnd.nextInt(firstIndex,lastIndex+1);
        swap(i,lastIndex);
        i = firstIndex;
        while (i < lastIndex && data[i] <= data[lastIndex]) {
            ++i;
        }
        if (i < lastIndex) {
            int j = i + 1;
                while (j < lastIndex) {
                    if (data[j] < data[lastIndex]) {
                        swap(i,j);
                        ++i;
                    }
                    ++j;
                }
            swap(i,lastIndex);
        }
        return i;
    }
    private void mergeSort() {
        shuffle();
        printData();
        int[] dataB = new int[Constants.DATA_LENGTH];
        for (int i = 0; i < Constants.DATA_LENGTH; ++i) {
            dataB[i] = data[i];
        }
        ms(dataB,data,0,data.length-1);
        printData();
        resetActiveIndices();
    }
    private void ms(int[] B, int[] A, int firstIndex, int lastIndex) {
        int length = lastIndex-firstIndex+1;
        if (length > 1) {
            int mid = (firstIndex+lastIndex)/2;
            ms(B,A,firstIndex,mid);
            ms(B,A,mid+1,lastIndex);
            merge(B,A,firstIndex,mid,lastIndex);
        }
    }
    private void merge(int[] B, int[] A, int firstIndex, int mid, int lastIndex) {
        for (int x = firstIndex; x <= lastIndex; x++) {
            B[x] = A[x];
        }
        int k = firstIndex;
        int i = firstIndex;
        int j = mid+ 1;
        while (i <= mid && j <= lastIndex) {
            if (B[i] <= B[j]) {
                A[k] = B[i];
                activeIndex1 = i;
                activeIndex2 = k;
                ++i;
                updateUI();
            }
            else {
                A[k] = B[j];
                ++j;
                activeIndex1 = k;
                activeIndex2 = j;
                updateUI();
            }
            ++k;
        }
        while (i <= mid) {
            A[k] = B[i];
            activeIndex1 = i;
            activeIndex2 = k;
            updateUI();
            k++;
            i++;
        }
    }
}

