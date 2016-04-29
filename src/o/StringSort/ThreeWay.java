package o.StringSort;

public class ThreeWay {
    private String[] a;

    public ThreeWay(String[] a) {
        this.a = a.clone();
    }

    public void sort() {
        sort(0, a.length - 1, 0);
    }

    private void sort(int low, int high, int d) {
        if (high <= low) {
            return;
        }
        int less = low;
        int great = high;
        int v = charAt(a[low], d);
        int i = low + 1;

        while (i <= great) {
            int temp = charAt(a[i], d);
            if (temp < v) {
                swap(less++, i++);
            } else if (temp > v) {
                swap(i, great--);
            } else {
                i++;
            }
        }

        sort(low, less - 1, d);
        if (v >= 0) {
            sort(less, great, d + 1);
        }
        sort(great + 1, high, d);
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
