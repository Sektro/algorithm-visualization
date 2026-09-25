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

        this.setLayout(new FlowLayout());
        this.add(bubbleSortButton);
        this.add(improvedBubbleSortButton);
        this.add(insertionSortButton);
        this.add(maxSortButton);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
    }

}
