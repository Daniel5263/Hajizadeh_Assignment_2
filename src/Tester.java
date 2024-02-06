import java.util.Random;

public class Tester {
    private double averageTime;
    Sorters.SortingAlgorithm sa;

    public Tester(Sorters.SortingAlgorithm sa) {
        this.sa = sa;
    }

    public double singleTest(int size) {
        int[] a = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(100);
        }

        long startTime = System.nanoTime();

        sa.sorty(a);

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e6;
    }

    public void test(int iterations, int size) {
        double totalTime = 0;

        for (int i = 0; i < iterations; i ++) {
            totalTime += singleTest(size);
        }

        averageTime = totalTime / iterations;

        System.out.printf("Sorted %d elements in %.5f ms\n", size, averageTime);
    }

    public double getAverageTime() {
        return averageTime;
    }
}