import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static void read_files(String filename_1, String filename_2, TreeSet<String> dict, Vector<String>  vector_a, Vector<String>  vector_b) throws IOException {
        String          tmp;
        BufferedReader  reader;
        FileInputStream file_1 = new FileInputStream(filename_1);
        FileInputStream file_2 = new FileInputStream(filename_2);

        reader = new BufferedReader(new InputStreamReader(file_1));
        while ((tmp = reader.readLine()) != null) {
            dict.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
            vector_a.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
        }
        reader = new BufferedReader(new InputStreamReader(file_2));
        while ((tmp = reader.readLine()) != null) {
            dict.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
            vector_b.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
        }

        FileOutputStream dictFile = new FileOutputStream("dictionary.txt");
        for (String tmp_2 : dict) {
            dictFile.write(tmp_2.getBytes());
            dictFile.write(' ');
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Input error!");
            System.exit(-1);
        }

        TreeSet<String> dict = new TreeSet<>();
        Vector<String>  vector_a = new Vector<>();
        Vector<String>  vector_b = new Vector<>();
        Vector<Integer> vector_a_count = new Vector<>();
        Vector<Integer> vector_b_count = new Vector<>();
        int             numerator_a_b = 0, vector_a_pow_count = 0, vector_b_pow_count = 0;
        int             count_a;
        int             count_b;

        read_files(args[0], args[1], dict, vector_a, vector_b);

        for (String value : dict) {
            count_a = (int)vector_a.stream().filter(str -> str.equals(value)).count();
            count_b = (int)vector_b.stream().filter(str -> str.equals(value)).count();
            vector_a_count.add(count_a);
            vector_b_count.add(count_b);
        }

        Iterator<Integer> ia = vector_a_count.iterator();
        Iterator<Integer> ib = vector_b_count.iterator();
        while (ia.hasNext() && ib.hasNext()) {
            numerator_a_b += ia.next() * ib.next();
        }

        for (Integer value : vector_a_count) vector_a_pow_count += Math.pow(value, 2);
        for (Integer integer : vector_b_count) vector_b_pow_count += Math.pow(integer, 2);
        double res = numerator_a_b / (Math.sqrt(vector_a_pow_count) * Math.sqrt(vector_b_pow_count));

        BigDecimal result = new BigDecimal(res);
        result = result.setScale(2, BigDecimal.ROUND_DOWN);
        System.out.printf("Similarity = %.2f\n", result);
    }
}
