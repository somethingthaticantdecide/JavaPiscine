import java.util.Scanner;

class Program {

    static int digits_summ(int number){
        int res = 0;

        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        return (res);
    }

    static boolean is_prime(int number){
        boolean prime = true;
        int steps = 2;

        while (number >= (steps * steps) && (number % steps) != 0) {
            steps++;
        }
        if (number % steps == 0)
            prime = false;
        return (prime);
    }

    public static void main(String[] args) {
        int count = 0;
        int number = 0;

        Scanner sc = new Scanner(System.in);

        while (number != 42) {
            number = sc.nextInt();

            if (is_prime(digits_summ(number)))
                count++;
        }
        sc.close();
        System.out.print("Count of coffee-request – ");
        System.out.println(count);
    }
}
