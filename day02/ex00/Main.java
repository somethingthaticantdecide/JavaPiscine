import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args) throws IOException {
        StringBuilder       str_from_file;
        String              file_type;
        boolean             defined;
        FileOutputStream    result_filename = new FileOutputStream("result.txt");
        Scanner             input = new Scanner(System.in);
        String              filename = " ";

        Scanner line = new Scanner(new File("signatures.txt"));
        Map<String, String> signatures = new HashMap<>();
        while (line.hasNext()) {
            String tmp = line.next();
            signatures.put(line.nextLine(), tmp.substring(0, tmp.length() - 1));
        }

        while (!filename.equals("42"))
        {
            defined = false;
            filename = input.nextLine();
            if (filename.indexOf('.') == -1)
                continue;
            FileInputStream fin = new FileInputStream(filename);
            str_from_file = new StringBuilder(" ");
            for (int i = 0; i < 8; i++) {
                str_from_file.append(String.format("%02x", fin.read())).append(" ");
            }
            for (int i = 1 ; i < str_from_file.length() ; i += 3) {
                file_type = signatures.get(str_from_file.substring(0, str_from_file.length() - i));
                if (file_type != null) {
                    file_type = file_type.toUpperCase();
                    result_filename.write(file_type.getBytes(StandardCharsets.UTF_8));
                    result_filename.write('\n');
                    defined = true;
                }
            }
            if (defined)
                System.out.println("PROCESSED");
            else
                System.out.println("UNDEFiNED");
        }
    }
}
