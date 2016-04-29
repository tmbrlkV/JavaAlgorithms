package c.SimpleSorts;

public class SelectionSort {
    private Comparable[] array;
    public SelectionSort(final Comparable[] array) {
        this.array = array.clone();
    }
    public void sort() {
        for (int i = 0; i < array.length; ++i) {
            int min = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (isLess(array[j], array[min])) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    private void swap(final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public  void print() {
        for (Comparable i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
