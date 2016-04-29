package f.PriorityQueues;

import java.util.Random;

public class Test {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; ++i) {
            a[i] = random.nextInt(a.length);
        }
        HeapSort hs = new HeapSort(a);
        hs.print();
        hs.sort();
        hs.print();
    }
}
