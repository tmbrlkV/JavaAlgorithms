package o.StringSort;

public class MSD {
    private String[] aux;
    private static final int R = 256;
    private String[] a;
    private static final int CUTTOFF = 2;

    public MSD(String[] a) {
        this.a = a.clone();
    }

    public void sort() {
        aux =  new String[a.length];
        sort(0, a.length - 1, 0);
    }

    private void sort(int low, int high, int d) {
        if (high <= low) {
            return;
        }
        int[] count = new int[R + 2];
        for (int i = low; i <= high; ++i) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; ++r) {
            count[r + 1] += count[r];
        }

        for (int i = low; i <= high; ++i) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = low; i <= high; ++i) {
            a[i] = aux[i - low];
        }

        for (int r = 0; r < R; ++r) {
            if (count[r] > CUTTOFF) {
                sort(low + count[r], low + count[r + 1] - 1, d + 1);
            } else {
                insertion(low + count[r], low + count[r + 1] - 1, d + 1);
            }
        }

    }

    private void insertion(int low, int high, int d) {
        for (int i = low; i <= high; ++i) {
            for (int j = i; j > low && isLess(j, j - 1, d); --j) {
                swap(j, j - 1);
            }
        }
    }

    private boolean isLess(int i, int j, int d) {
        return a[i].substring(d).compareTo(a[j].substring(d)) < 0;
    }

    private void swap(int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }
        else return -1;
    }
}
