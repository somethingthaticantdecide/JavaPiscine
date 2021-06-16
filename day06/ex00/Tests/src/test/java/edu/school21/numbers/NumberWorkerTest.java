package edu.school21.numbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {
    NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97})
    public void isPrimeForPrimes (int arg) { assertTrue(numberWorker.isPrime(arg)); }

    @ParameterizedTest
    @ValueSource(ints = {100, 222, 9, 12, 33})
    public void isPrimeForNotPrimes (int arg) { assertFalse(numberWorker.isPrime(arg)); }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 1})
    public void isPrimeForIncorrectNumbers (int arg) { Assertions.assertThrows(IllegalNumberException.class, () -> { numberWorker.isPrime(arg); }); }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void isDigitsSumCorrect(int arg, int result) {
        Assertions.assertEquals(numberWorker.digitsSum(arg), result);
    }
}
