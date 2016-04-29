package d.MergeSort;

import java.util.Comparator;

public class Point {
    private final double x;
    private final double y;
    public final Comparator<Point> POLAR_ORDER = new PolarOrder();

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private class PolarOrder implements Comparator<Point> {
        public int compare(Point first, Point second) {
            double dyFirst = first.y - y;
            double dySecond = second.y - y;
            double dxFirst = first.x - x;
            double dxSecond = second.x - x;

            if (dyFirst == 0 && dySecond == 0) {
                if (dxFirst >= 0 && dxSecond < 0) {
                    return -1;
                }
                else if (dxSecond >= 0 && dxFirst < 0) {
                    return +1;
                }
                else{
                    return 0;
                }
            } else if (dyFirst >= 0 && dySecond < 0) {
                return -1;
            } else if (dySecond >= 0 && dyFirst < 0) {
                return 1;
            }
            return -turn(Point.this, first, second);
        }
    }

    public static int turn(Point a, Point b, Point c) {
        double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area < 0) {
            return -1;
        } else if (area > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Point that = (Point) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public String toString() {
        return x + " " + y + " ";
    }
}
