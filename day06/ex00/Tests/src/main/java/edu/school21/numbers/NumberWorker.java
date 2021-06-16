package edu.school21.numbers;

public class NumberWorker
{
    public boolean isPrime(int number) {
        int steps = 2;
        if (number < 2) {
            throw new IllegalNumberException();
        }
        if (number < 4) {
            return true;
        }
        while (number >= (steps * steps) && (number % steps) != 0) {
            steps++;
        }
        return number % steps != 0;
    }

    public int digitsSum(int number) {

        int res = 0;

        if (number < 0) {
            number *= -1;
        }
        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        return (res);
    }
}
