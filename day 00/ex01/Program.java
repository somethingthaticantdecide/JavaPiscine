import java.util.Scanner;

class Program {

    public static void main(String[] args) {
        boolean prime = true;
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number < 2) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        int steps = 2;

        while (number >= (steps * steps) && (number % steps) != 0) {
            steps++;
        }
        if (number % steps == 0)
            prime = false;
        System.out.print(prime);
        System.out.print(' ');
        System.out.println(steps - 1);
    }
}
