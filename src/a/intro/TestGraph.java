package a.intro;

import java.util.Random;

public class TestGraph {
    private static final Random random = new Random();
    public static final int COUNT = 10000;
    public static final int SIZE = 27;

    public static void main(String[] args) {
        int count = 0;
        int i;
        for (int j = 0; j < COUNT; ++j) {
            GraphBalance gp = new GraphBalance(SIZE);
            while (!gp.connected(0, SIZE - 1)) {
                i = random.nextInt(SIZE - 2) + 1;
                if (gp.open(i)) {
                    count++;
                }
            }
        }
        System.out.println((double) count / COUNT / (SIZE - 2));
    }
}