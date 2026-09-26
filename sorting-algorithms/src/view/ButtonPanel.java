package view;

import model.Algorithms;
import model.Sorter;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private final Sorter sorter;
    private AlgorithmButton bubbleSortButton = new AlgorithmButton("Bubble Sort");
    private AlgorithmButton improvedBubbleSortButton = new AlgorithmButton("Improved Bubble Sort");
    private AlgorithmButton insertionSortButton = new AlgorithmButton("Insertion Sort");
    private AlgorithmButton maxSortButton = new AlgorithmButton("Max Sort");
    private AlgorithmButton quickSortButton = new AlgorithmButton("Quick Sort");
    private AlgorithmButton mergeSortButton = new AlgorithmButton("Merge Sort");

    public ButtonPanel(Sorter sorter) {
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true); // improved rendering performance
        this.setFocusable(true); // will receive key input

        this.sorter = sorter;
        bubbleSortButton.addActionListener(e -> {
            sorter.callAlgorithm(Algorithms.BUBBLE);
        });
        improvedBubbleSortButton.addActionListener(e -> {
            sorter.callAlgorithm(Algorithms.IMPROVED_BUBBLE);
        });
        insertionSortButton.addActionListener(e -> {
            sorter.callAlgorithm(Algorithms.INSERTION);
        });
        maxSortButton.addActionListener(e -> {
            sorter.callAlgorithm(Algorithms.MAX);
        });
        quickSortButton.addActionListener(e -> {
            sorter.callAlgorithm(Algorithms.QUICK);
        });
        mergeSortButton.addActionListener(e -> {
            sorter.callAlgorithm(Algorithms.MERGE);
        });

        this.setLayout(new FlowLayout());
        this.add(bubbleSortButton);
        this.add(improvedBubbleSortButton);
        this.add(insertionSortButton);
        this.add(maxSortButton);
        this.add(quickSortButton);
        this.add(mergeSortButton);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
    }

}
