package d.MergeSort;

import c.SimpleSorts.InsertionSort;

public class MergeSort {
    public static final int CUTOFF = 7;
    private Comparable[] array;
    private Comparable[] temp;

    public MergeSort(Comparable[] array) {
        this.array = array.clone();
        temp = new Comparable[array.length];
    }


    public void sortClassic() {
        ///without temp or without copying
        sorting(0, array.length - 1);
    }

    public void sortBottomUp() {
        int length = array.length;
        for (int size = 1; size < length; size *= 2) {
            for (int low = 0; low < length - size; low += size * 2) {
                int min = Math.min(low + size * 2 - 1, length - 1);
                merge(low, low + size - 1, min);
            }
        }
    }

    private void sorting(final int low, final int high) {
        if (high <= low + CUTOFF - 1) {
            InsertionSort insertionSort = new InsertionSort(array);
            insertionSort.sort();
            return;
        }
        int mid = low + (high - low) / 2;
        sorting(low, mid);
        sorting(mid + 1, high);
        if (!isLess(array[mid + 1], array[mid])) {
            return;
        }
        merge(low, mid, high);

    }

    private void merge(final int low, final int mid, final int high) {
        copyTempArray(low, high);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; ++k) {
            if (i > mid) {
                array[k] = temp[j++];
            } else if (j > high) {
                array[k] = temp[i++];
            } else if (isLess(temp[j], temp[i])) {
                array[k] = temp[j++];
            } else {
                array[k] = temp[i++];
            }
        }
    }

    private void copyTempArray(int low, int high) {
        for (int k = low; k <= high; ++k) {
            temp[k] = array[k];
        }
    }

    private boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void print() {
        for (Comparable i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
