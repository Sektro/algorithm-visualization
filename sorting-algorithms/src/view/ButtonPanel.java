package view;

import model.Algorithms;
import model.Constants;
import model.Sorter;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private Sorter sorter;
    private AlgorithmButton bubbgleSortButton = new AlgorithmButton("Bubblesort");

    public ButtonPanel(Sorter sorter) {
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true); // improved rendering performance
        this.setFocusable(true); // will receive key input

        this.sorter = sorter;
        bubbgleSortButton.addActionListener(e -> {
            sorter.callAlgorithm(Algorithms.BUBBLE);
        });

        this.setLayout(new FlowLayout());
        this.add(bubbgleSortButton);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }

}
