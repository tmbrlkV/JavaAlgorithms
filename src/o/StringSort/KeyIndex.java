package o.StringSort;

public class KeyIndex {
    private final int R;
    private int[] count;

    public KeyIndex(int R) {
        this.R = R;
        count = new int[R + 1];
    }

    public void sort(int[] a) {
        int size = a.length;
        int[] aux = new int[size];

        for (int i = 0; i < size; ++i) {
            count[a[i] + 1]++;
        }

        for (int r = 0; r < R; ++r) {
            count[r + 1] += count[r];
        }

        for (int i = 0; i < size; ++i) {
            aux[count[a[i]]++] = a[i];
        }

        for (int i = 0; i < size; ++i) {
            a[i] = aux[i];
        }
    }
}
