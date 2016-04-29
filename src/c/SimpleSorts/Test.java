package c.SimpleSorts;

import java.util.Random;

public class Test {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        for (int i = 0; i < a.length; ++i) {
            a[i] = random.nextInt(a.length);
        }
        SelectionSort is = new SelectionSort(a);
        is.print();
        is.sort();
        is.print();

        System.out.println();

        ShellSort ss =new ShellSort(a);
        ss.print();
        ss.sort();
        ss.print();

        System.out.println();

        Shuffle sh = new Shuffle(a);
        sh.print();
        sh.shuffle();
        sh.print();

        System.out.println();

        InsertionSort si = new InsertionSort(a);
        si.print();
        si.sort();
        si.print();
    }
}
