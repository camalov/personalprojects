package com.gui.elements;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class FontChanger implements FontManager {

    @Override
    public void setJLabelFont(String fontURL, JLabel jLabel, Float transform) {
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontURL)).deriveFont(transform);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontURL)));
            jLabel.setFont(font);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(FontChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
