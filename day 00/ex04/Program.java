import java.util.Scanner;

public class Program {

    static int MAX_LENGTH = 65535;

    public static void main(String[] args) {
        int i, j, chr, cnt, max;
        int[] str_to_chars = new int[MAX_LENGTH];
        int[] counts = new int[10];
        int[] chars = new int[10];
        int[] offsets = new int[10];

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        for (char c : str.toCharArray()) {
            str_to_chars[c]++;
        }

        for (j = 0; j < 10; j++) {
            cnt = 0;
            chr = 0;

            for (i = 0; i < MAX_LENGTH; i++) {
                if (str_to_chars[i] > cnt) {
                    cnt = str_to_chars[i];
                    chr = i;
                }
            }
            chars[j] = chr;
            counts[j] = cnt;
            str_to_chars[chr] = 0;
        }
        max = counts[0];
        for (i = 0; i < 10; i++) {
            offsets[i] = counts[i] * 10 / max;
        }

        if (counts[0] < 10)
            max = counts[0];
        else
            max = 10;
        if (counts[0] <= 0)
            return;
        for (i = max; i >= 0; i--) {
            for (j = 0; j < 10; j++) {
                if (counts[j] < 0)
                    continue;
                if (i > offsets[j])
                    System.out.print("   ");
                else if (i == offsets[j])
                    System.out.printf("%3d", counts[j]);
                else
                    System.out.print("  #");
            }
            System.out.println();
        }
        for (i = 0; i < 10; i++) {
            System.out.print("  " + (char) chars[i]);
        }
    }
}