package edu.school21.printer.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import edu.school21.printer.logic.*;

@Parameters(separators = "=")
public class Printer {
    @Parameter(names = {"--white"})
    String white;
    @Parameter(names = {"--black"})
    String black;

    public static void main(String[] Args) throws IOException {

        if (Args.length < 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        Printer printer = new Printer();

        try {
            JCommander.newBuilder()
                    .addObject(printer)
                    .build()
                    .parse(Args);
            printer.run();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid arguments");
        }
    }
    public void run() throws IOException {

        File file = new File(System.getProperty("user.dir") + "/target/resources/image.bmp");
        BufferedImage image = ImageIO.read(file);
        Converter converter = new Converter(white, black, image);
        converter.Print();
    }
}
