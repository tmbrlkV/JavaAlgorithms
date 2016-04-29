package f.PriorityQueues;

public class HeapSort {
    private Comparable[] array;

    public HeapSort(Comparable[] array) {
        this.array = array.clone();
    }

    public void sort() {
        int size = array.length;
        for (int i = size / 2; i >= 0; i--) {
            sink(i, size - 1);
        }
        while (size > 1) {
            swap(0, size - 1);
            size--;
            sink(0, size - 1);
        }
    }
    private void sink(int k, final int size) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && isLess(array[j], array[j + 1])) {
                j++;
            }
            if (!isLess(array[k], array[j])) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
    private  boolean isLess(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    private void swap(final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void print() {
        for (Comparable i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
