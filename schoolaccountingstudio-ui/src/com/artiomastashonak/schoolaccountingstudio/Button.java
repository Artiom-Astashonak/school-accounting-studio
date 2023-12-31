package com.artiomastashonak.schoolaccountingstudio;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class Button extends JButton {

    public Button(String text, Font font, Color backogrundColor, Color textColor) {
        setText(text);
        setBackground(backogrundColor);
        setForeground(textColor);
        setFont(font);
        setFocusable(false);

        setOpaque(true);
    }

    public Button(ImageIcon icon, Color backgroundColor) {
        setIcon(icon);
        setBackground(backgroundColor);
        setFocusable(false);
        setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

        setOpaque(true);
    }

    public Button(ImageIcon icon, String text, Font font, Color backgroundColor, Color textColor) {
        setIcon(icon);
        setText(text);
        setBackground(backgroundColor);
        setForeground(textColor);
        setFont(font);
        setFocusable(false);
        setMinimumSize(new Dimension(icon.getIconWidth() + text.length(), icon.getIconHeight()));

        setOpaque(true);
    }

}