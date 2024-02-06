import java.util.Random;

public class kSorting {
    public static void generateKSorted(int[] my_array) {
        Random rand = new Random();

        for (int i = 0; i < my_array.length; i++) {
            int min = Math.max(0, i - 10);
            int max = Math.max(min, Math.min(99, i + 10));
            my_array[i] = rand.nextInt(max - min + 1) + min;
        }

        ShellSort shellSort = new ShellSort();
        shellSort.sorty(my_array);
    }
}