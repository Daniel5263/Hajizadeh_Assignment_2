public class KSortedTester {
    private double averageTime;
    Sorters.SortingAlgorithm sa;

    public KSortedTester(Sorters.SortingAlgorithm sa) {
        this.sa = sa;
    }

    public void test(int iterations, int size, int[] k_sorted_array) {
        double totalTime = 0;

        for (int i = 0; i < iterations; i ++) {
            long startTime = System.nanoTime();

            sa.sorty(k_sorted_array);

            long endTime = System.nanoTime();

            totalTime += (endTime - startTime) / 1e6;
        }

        averageTime = totalTime / iterations;

        System.out.printf("Sorted %d elements in %.5f ms\n", size, averageTime);
    }

    public double getAverageTime() {
        return averageTime;
    }
}