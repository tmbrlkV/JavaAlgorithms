package e.QuickSort;

import c.SimpleSorts.InsertionSort;
import c.SimpleSorts.Shuffle;

public class QuickSort {
    public static final int CUTOFF = 10;
    private Comparable[] array;

    public QuickSort(Comparable[] array) {
        this.array = array.clone();
    }

    public void sort() {
        Shuffle shuffle = new Shuffle(array);
        shuffle.shuffle();
//        sort(0, array.length - 1);
        sortUpgrade(0, array.length - 1);
    }

    private void sort(final int low, final int high) {
        if (high <= low + CUTOFF - 1) {
            InsertionSort is = new InsertionSort(array);
            is.sort();
            return;
        }
//        int mid = low + (high - low) / 2;
//        int average = median(low, mid, high);
//        swap(low, average);
        int j = partition(low, high);
        sort(low, j - 1);
        sort(j + 1, high);
    }

    private void sortUpgrade(final int low, final int high) {
        if (high <= low + CUTOFF - 1) {
            InsertionSort is = new InsertionSort(array);
            is.sort();
            return;
        }

        int less = low;
        int great = high;
        Comparable current = array[low];
        int i = low;

        while (i <= great) {
            int compared = array[i].compareTo(current);
            if (compared < 0) {
                swap(less++, i++);
            } else if (compared > 0) {
                swap(i, great--);
            } else {
                i++;
            }
        }
        sort(low, less - 1);
        sort(great + 1, high);
    }

    public Comparable select(final int k) {
        Shuffle shuffle = new Shuffle(array);
        shuffle.shuffle();
        int low = 0;
        int high = array.length - 1;
        while (high > low) {
            int j = partition(low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j - 1;
            } else {
                return array[k];
            }
        }
        return array[k];
    }

    private int partition(final int low, final int high) {
        int i = low;
        int j = high + 1;

        while (true) {
            while (isLess(array[++i], array[low])) {
                if (i == high) {
                    break;
                }
            }

            while (isLess(array[low], array[--j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) break;
            swap(i, j);
        }
        swap(low, j);

        return j;
    }

    private void swap(final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isLess(final Comparable a, final  Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void print() {
        for (Comparable i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
