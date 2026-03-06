package view;

import model.Constants;
import model.Sorter;

import javax.swing.*;
import java.awt.*;

public class DiagramPanel extends JPanel {
    private Sorter sorter;

    public DiagramPanel() {
        this.setPreferredSize(new Dimension(Constants.DIAGRAMPANEL_WIDTH,Constants.DIAGRAMPANEL_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // improved rendering performance
        this.setFocusable(true); // will receive key input

        sorter = new Sorter();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        renderDiagram(g2);
    }

    private void renderDiagram(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        int [] data = sorter.getData();
        int x = Constants.STARTER_POS_X;
        int y = Constants.STARTER_POS_Y;
        for (int i = 0; i < Constants.DATA_LENGTH; ++i) {
            for (int j = 0; j < data[i]; ++j) {
                g2.fillRect(x,y,Constants.BLOCK_WIDTH,Constants.BLOCK_HEIGHT);
                y -= Constants.BLOCK_HEIGHT;
            }
            x += Constants.BLOCK_WIDTH;
            y = Constants.STARTER_POS_Y;
        }

    }
}
