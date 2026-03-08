package view;

import javax.swing.*;
import java.awt.*;

public class AlgorithmButton extends JButton {
    public AlgorithmButton(String name) {
        super(name);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(41, 128, 185));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
    }
}
