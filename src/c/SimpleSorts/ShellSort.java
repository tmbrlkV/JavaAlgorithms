package c.SimpleSorts;

public class ShellSort {
    private Comparable[] array;

    public ShellSort(final Comparable[] array) {
        this.array = array.clone();
    }

    public void sort() {
        int h = 1;
        while (h < array.length / 3) {
            h = getH(h);
        }
        while (h >= 1) {
            for (int i = h; i < array.length; ++i) {
                for (int j = i; j >= h && isLess(array[j], array[j - h]); j -= h) {
                    swap(j, j - h);
                }
            }
            h /= 3;
        }
    }

    private int getH(int h) {
        return 3 * h + 1;
    }

    private void swap(final int h, final int j) {
        Comparable temp = array[h];
        array[h] = array[j];
        array[j] = temp;
    }

    private boolean isLess(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }

    public  void print() {
        for (Comparable i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
