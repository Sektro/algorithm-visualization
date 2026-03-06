package view;

import model.Constants;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public ButtonPanel() {
        this.setPreferredSize(new Dimension(Constants.DIAGRAMPANEL_WIDTH,Constants.DIAGRAMPANEL_HEIGHT));
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true); // improved rendering performance
        this.setFocusable(true); // will receive key input
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }

}
