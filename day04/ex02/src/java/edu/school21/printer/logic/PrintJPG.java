package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.awt.image.BufferedImage;

public class PrintJPG {
    private String _black;
    private String _white;
    private BufferedImage _image;

    public PrintJPG(String white, String black, BufferedImage image) {
        this._black = black;
        this._white = white;
        this._image = image;
    }

    public void Print() {

        for (int i = 0; i < _image.getHeight(); i++) {
            for (int j = 0; j < _image.getWidth(); j++)
            {
                ColoredPrinter cp = new ColoredPrinter();
                if (_image.getRGB(j, i) == -1)
                    cp.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(_white));
                else
                    cp.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(_black));
            }
            System.out.println();
        }
    }
}
