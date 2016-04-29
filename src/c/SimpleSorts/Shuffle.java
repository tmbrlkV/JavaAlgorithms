package c.SimpleSorts;

import java.util.Random;

public class Shuffle {
    private Comparable[] array;
    private static final  Random random = new Random();

    public Shuffle(final Comparable[] array) {
        this.array = array.clone();
    }

    public void shuffle() {
        for (int i = 0; i < array.length; ++i) {
            int r = random.nextInt(i + 1);
            swap(i, r);
        }
    }

    private void swap(final int i, final int r) {
        Comparable temp = array[i];
        array[i] = array[r];
        array[r] = temp;
    }

    public  void print() {
        for (Comparable i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
