package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import edu.school21.printer.logic.PrintJPG;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    @Parameter(names={"--black"},
            required = true)
            public String black;
    @Parameter(names={"--white"},
            required = true)
            public String white;

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        Main printJPG = new Main();
        try {
            JCommander.newBuilder()
                    .addObject(printJPG)
                    .build()
                    .parse(args);
            printJPG.run();
        } catch (IllegalArgumentException e) {
            System.err.println("Can't open file!");
        }
    }

    public void run() throws IOException {
        File file = new File("it.bmp");
        BufferedImage image = ImageIO.read(file);
        PrintJPG printLogic = new PrintJPG(white, black, image);
        printLogic.Print();
    }

}
