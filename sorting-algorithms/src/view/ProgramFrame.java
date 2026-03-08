package view;

import model.Constants;
import model.Sorter;

import javax.swing.*;
import java.awt.*;

public class ProgramFrame extends JFrame {
    private Sorter sorter;
    private DiagramPanel diagramPanel;
    private ButtonPanel buttonPanel;

    public ProgramFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setPreferredSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT));
        this.setTitle("Sorting Algorithms");

        diagramPanel = new DiagramPanel(sorter);
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.add(diagramPanel);
        buttonPanel = new ButtonPanel(sorter);

        this.getContentPane().add(BorderLayout.NORTH, wrapperPanel);
        this.getContentPane().add(BorderLayout.CENTER, buttonPanel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
