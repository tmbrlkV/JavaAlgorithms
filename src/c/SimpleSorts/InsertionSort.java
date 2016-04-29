package c.SimpleSorts;

public class InsertionSort {
    private Comparable[] array;

    public InsertionSort(Comparable[] array) {
        this.array = array;
    }

    public void sort() {
        for (int i = 0; i < array.length; ++i) {
            for (int j = i; j > 0 && isLess(array[j], array[j - 1]); --j) {
                swap(j, j - 1);
            }
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
