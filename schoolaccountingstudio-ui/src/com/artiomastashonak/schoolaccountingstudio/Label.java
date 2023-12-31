package com.artiomastashonak.schoolaccountingstudio;

import org.jetbrains.annotations.Nullable;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Label extends JLabel {

    public Label(String text, Font font, Color textColor, @Nullable Color backgroundColor) {
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(TOP);
        setForeground(textColor);
        setFont(font);
        setBackground(backgroundColor);
        setText(text);
    }

}