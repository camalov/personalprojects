package com.gui.elements;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;

public class ImageParameters extends JPanel {

    String imgUrl;
    BufferedImage img;

    public ImageParameters(String imgUrl) {
        try {
            img = ImageIO.read(new FileImageInputStream(new File(imgUrl)));
        } catch (IOException ex) {
            System.out.println("Təsvir əlavə edilərkən xəta baş verdi. Fayl formatı və ölçülərin düzgünlüyünü yoxlayın.");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, img.getWidth() / img.getWidth() % 30, img.getWidth() / img.getWidth() % 40, this);
    }

    public Image resize(BufferedImage img, int width, int height) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        Image resizedImage = resized;
        return resizedImage;
    }

}