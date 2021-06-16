package edu.school21.printer.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import edu.school21.printer.logic.PrintJPG;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
		String[] split1;
		String[] split2;
        if (args.length != 3) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
		split1 = args[0].split("=");
        if (!split1[0].equals("--white") || !split1[1].matches("\\S") || split1.length != 2) {
            throw new IllegalArgumentException("--white=char_to_white --black=char_to_black image_path");
        }
        split2 = args[1].split("=");
        if (!split2[0].equals("--black") || !split2[1].matches("\\S") || split2.length != 2) {
            throw new IllegalArgumentException("--white=char_to_white --black=char_to_black image_path");
        }
        File file = new File(args[2]);
        BufferedImage image = ImageIO.read(file);
        PrintJPG converter = new PrintJPG(split1[1].charAt(0), split2[1].charAt(0), image);
        converter.Print();
    }
}
