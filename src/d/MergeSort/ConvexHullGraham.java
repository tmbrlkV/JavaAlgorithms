package d.MergeSort;

import java.util.Arrays;
import java.util.Stack;

public class ConvexHullGraham {
    private Stack<Point> hull = new Stack<>();
    private Point[] points;
    private int size;

    public ConvexHullGraham(Point[] points) {
        size = init(points);
    }

    private int init(Point[] points) {
        int size = points.length;
        this.points = points.clone();
        Arrays.sort(points, 1, size, points[0].POLAR_ORDER);

        hull.push(points[0]);
        return size;
    }

    public void convex() {
        int firstPoint = getFirstPoint(points, size);
        if (firstPoint == size) {
            return;
        }

        int secondPoint = getSecondPoint(points, size, firstPoint);
        hull.push(points[secondPoint - 1]);

        scan(points, size, secondPoint);
    }
    private int getFirstPoint(Point[] points, int size) {
        int firstPoint;
        for (firstPoint = 1; firstPoint < size; ++firstPoint) {
            if (!points[0].equals(points[firstPoint])) {
                break;
            }
        }
        return firstPoint;
    }
    private int getSecondPoint(Point[] points, int size, int firstPoint) {
        int secondPoint;
        for (secondPoint = firstPoint + 1; secondPoint < size; ++secondPoint) {
            if (Point.turn(points[0], points[firstPoint], points[secondPoint]) != 0) {
                break;
            }
        }
        return secondPoint;
    }
    private void scan(Point[] points, int size, int secondPoint) {
        for (int i = secondPoint; i < size; i++) {
            Point top = hull.pop();

            while (!hull.empty() && Point.turn(hull.peek(), top, points[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }
    }

    public Iterable<Point> hull() {
        Stack<Point> s = new Stack<>();
        for (Point p : hull) {
            s.push(p);
        }
        return s;
    }
}
