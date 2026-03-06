package view;

import model.Constants;

import javax.swing.*;
import java.awt.*;

public class ProgramFrame extends JFrame {
    private DiagramPanel diagramPanel;
    private ButtonPanel buttonPanel;

    public ProgramFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT));
        this.setTitle("Sorting Algorithms");

        diagramPanel = new DiagramPanel();
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.add(diagramPanel);
        buttonPanel = new ButtonPanel();

        this.getContentPane().add(BorderLayout.NORTH, wrapperPanel);
        this.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
