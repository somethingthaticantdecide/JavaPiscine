package edu.school21.printer.logic;

import java.awt.image.BufferedImage;

public class PrintJPG {
    private char _black;
    private char _white;
    private BufferedImage _image;

    public PrintJPG(char white, char black, BufferedImage image) {

        this._black = black;
        this._white = white;
        this._image = image;
    }

    public void Print() {

        for (int i = 0; i < _image.getHeight(); i++) {
            for (int j = 0; j < _image.getWidth(); j++)
				System.out.print(_image.getRGB(j, i) == -1 ? _white : _black);
            System.out.println();
        }
    }
}
