package LAB14;

import java.util.Arrays;

public class Point implements Comparable<Point> {
    private int pointX;
    private int pointY;

    public Point(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    @Override
    public int compareTo(Point other) {
        if (this.pointX != other.pointX) {
            return Integer.compare(this.pointX, other.pointX);
        } else {
            return Integer.compare(this.pointY, other.pointY);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return this.pointX == other.pointX && this.pointY == other.pointY;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.pointX + ", " + this.pointY + ")";
    }
}


class testPoint {

    public static void main(String[] args) {
        Point[] points = new Point[5];
        for(int i = 0; i < 5; i++) {
            int randomX = (int) (Math.random()*(20-1) +1   );
            int randomy = (int) (Math.random()*(20-1) +1   );

            points[i]  = new Point(randomX, randomy);
            System.out.println(points[i].toString());
        }

        System.out.println("Sorted points");
        Arrays.sort(points);

        for (Point p : points) {
            System.out.println(p.toString());
        }
    }
}