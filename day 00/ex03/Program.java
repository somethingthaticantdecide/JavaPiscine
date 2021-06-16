import java.util.Scanner;

public class Program {
    static int find_min(String numbers){
        int index = 0;
        int min = 9;

        while (index < 9) {
            int temp = numbers.charAt(index) - 48;
            if (temp < min)
                min = temp;
            index += 2;
        }
        return (min);
    }

    public static void main(String[] args) {

        int i = 1;
        int j = 0;
        long temp = 0;
        long offset = 1;
        int weaks_total = 1;
        String week_str = "";
        String numbers = "";
        long myArray = 0;

        Scanner sc = new Scanner(System.in);

        while (weaks_total <= 18) {
            week_str = sc.nextLine();
            if (week_str.equals("42"))
                break;
            if (!week_str.equals("Week " + weaks_total)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            numbers = sc.nextLine();
            if (numbers.equals("42"))
                break;
            myArray = myArray + find_min(numbers) * offset;
            offset = offset * 10;
            weaks_total++;
        }

        while (i < weaks_total) {
            j = 0;
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(' ');
            temp = myArray % 10;
            myArray = myArray / 10;
            while (j < temp) {
                System.out.print('=');
                j++;
            }
            System.out.println('>');
            i++;
        }
        sc.close();
    }
}
