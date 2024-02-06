import java.io.IOException;
import java.io.PrintWriter;

public class KSortedPerformance {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        Sorters.SortingAlgorithm[] algos = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort()
        };

        try {
            PrintWriter writer = new PrintWriter("k_sorted_performance_report.txt", "UTF-8");

            for (int i = 0; i < algos.length; i++) {
                Sorters.SortingAlgorithm sa = algos[i];

                writer.println("Sorting algorithm - " + sa.getClass().getSimpleName());

                KSortedTester tester = new KSortedTester(sa);

                for (int j = 0; j < sizes.length; j++) {
                    int size = sizes[j];
                    int[] my_array = new int[size];

                    kSorting.generateKSorted(my_array);

                    tester.test(20, size, my_array);

                    double averageTime = tester.getAverageTime();

                    writer.printf("Sorted %d elements in %.5f ms (avg)\n", size, averageTime);
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the .txt file.");
            e.printStackTrace();
        }
    }
}