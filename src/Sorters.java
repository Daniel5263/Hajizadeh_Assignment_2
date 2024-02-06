import java.util.Random;

public class Sorters {
    public interface SortingAlgorithm {
        int[] sorty(int[] input);
    }
}

class BubbleSort implements Sorters.SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int[] a = input.clone();
        int tmp;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }
}

class InsertionSort implements Sorters.SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int[] a = input.clone();
        int tmp;

        for (int p = 1; p < a.length; ++p) {
            tmp = a[p];
            int j;
            for (j = p; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
        return a;
    }
}

class SelectionSort implements Sorters.SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int[] a = input.clone();
        int tmp;

        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }

        return a;
    }
}

class ShellSort implements Sorters.SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int[] a = input.clone();
        int tmp;

        for (int gap = a.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; ++i) {
                tmp = a[i];
                int j;
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
        return a;
    }
}

class QuickSort implements Sorters.SortingAlgorithm {
    private final Random rand = new Random();
    @Override
    public int[] sorty(int[] input) {
        int[] a = input.clone();

        quickSort(a, 0, a.length - 1);

        return a;
    }

    void quickSort(int[] a, int start, int end) {
        int tmp;

        if (start >= end) {
            return;
        }

        int random = start + rand.nextInt(end - start + 1);

        tmp = a[random];
        a[random] = a[end];
        a[end] = tmp;

        int pivot = a[end];
        int partIndex = start;

        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                tmp = a[i];
                a[i] = a[partIndex];
                a[partIndex] = tmp;
                partIndex++;
            }
        }
        tmp = a[end];
        a[end] = a[partIndex];
        a[partIndex] = tmp;

        quickSort(a, start, partIndex - 1);
        quickSort(a, partIndex + 1, end);
    }
}

class MergeSort implements Sorters.SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {
        int[] a = input.clone();

        sort(a, 0, a.length - 1);

        return a;
    }

    void sort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    void merge(int[] a, int start, int mid, int end) {
        int m1 = mid - start + 1;
        int m2 = end - mid;

        int[] left = new int[m1];
        int[] right = new int[m2];

        for (int i = 0; i < m1; i++) {
            left[i] = a[start + i];
        }
        for (int j = 0; j < m2; j++) {
            right[j] = a[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;

        while (i < m1 && j < m2) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < m1) {
            a[k] = left[i];
            i++;
            k++;
        }
        while (j < m2) {
            a[k] = right[j];
            j++;
            k++;
        }
    }
}