package d.MergeSort;

import java.util.Random;

public class Test {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Integer[] a = new Integer[20];
        for (int i = 0; i < a.length; ++i) {
            a[i] = random.nextInt(a.length);
        }

        MergeSort ms = new MergeSort(a);
        ms.print();
        ms.sortClassic();
        ms.print();

        System.out.println();

        MergeSort mss = new MergeSort(a);
        mss.print();
        mss.sortBottomUp();
        mss.print();

        System.out.println();

        Point[] points = new Point[10];
        for (int i = 0; i < points.length; ++i) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            points[i] = new Point(x, y);

        }
        ConvexHullGraham chg = new ConvexHullGraham(points);
        chg.convex();
        for (Point point : chg.hull()) {
            System.out.print(point + " ");
        }
        System.out.println();
    }
}
