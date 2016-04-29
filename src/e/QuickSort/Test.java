package e.QuickSort;

import java.util.Random;

public class Test {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; ++i) {
            a[i] = random.nextInt(a.length);
        }
        QuickSort qs = new QuickSort(a);
        qs.print();
        qs.sort();
        qs.print();
    }
}
