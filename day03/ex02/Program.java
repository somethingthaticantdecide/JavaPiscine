import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Program {

    public static int threadSum = 0;

    static class myThread extends Thread {
        int[] _numbers;
        int _start;
        int _end;
        int _array_numb;
        int _sum = 0;

        public myThread(int[] numbers, int start, int end, int array_numb) {
            this._numbers = numbers;
            this._start = start;
            this._end = end;
            this._array_numb = array_numb;
        }

        @Override
        public void run() {
            for (int i = _start; i <= _end; i++)
                _sum += _numbers[i];
            threadSum += _sum;
            System.out.println("Thread " + _array_numb + ": from " + _start + " to " + _end + " sum is " + _sum);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String[] split;
        int arraySize;
        int threadsCount;
        int arrayOffset = 0;
        int arrayCount = 1;
        int arrayStart = 0;
        int arrayEnd = 0;


        IntStream RandomArray = new Random().ints(0,100).limit(arraySize);
        int[] numbers =  RandomArray.toArray();
        System.out.println("Sum: " + Arrays.stream(numbers).sum());

        arrayOffset = arraySize / threadsCount;

        while (arrayStart < arraySize && arrayCount <= threadsCount)
        {
            if (arrayStart + arrayOffset >= arraySize)
                arrayEnd = arraySize - 1;
            else
                arrayEnd = arrayStart + arrayOffset ;
            myThread Thread = new myThread(numbers, arrayStart, arrayEnd, arrayCount);
            Thread.start();
            Thread.join();
            if (arrayStart + arrayOffset > arraySize)
                arrayStart = arrayEnd + 1;
            else
                arrayStart += arrayOffset + 1;
            arrayCount++;
        }
        System.out.println("Sum by threads: " + threadSum);
    }
}
