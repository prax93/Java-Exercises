package Primzahlen;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        IntPredicate isprime = arg -> {
            if (arg <= 1)
                return false;
            // Check from 2 to n-1
            for (int i = 2; i < arg; i++)
                if (arg % i == 0)
                    return false;
            return true;
        };

        // Bereich der Zahlen
        int rangeStart = 0;
        int rangeEnd = 100000;

        // Sequentieller Stream
        long startSequential = System.currentTimeMillis();
        List<Integer> primesSequential = IntStream.range(rangeStart, rangeEnd)
                .filter(isprime)
                .boxed()
                .toList();
        long endSequential = System.currentTimeMillis();
        System.out.println("Gefundene Primzahlen (sequentiell): " + primesSequential.size());
        System.out.println("Zeit für sequentiellen Stream: " + (endSequential - startSequential) + " ms");

        // Paralleler Stream
        long startParallel = System.currentTimeMillis();
        List<Integer> primesParallel = IntStream.range(rangeStart, rangeEnd)
                .parallel()
                .filter(isprime)
                .boxed()
                .toList();
        long endParallel = System.currentTimeMillis();
        System.out.println("Gefundene Primzahlen (parallel): " + primesParallel.size());
        System.out.println("Zeit für parallelen Stream: " + (endParallel - startParallel) + " ms");
    }
}