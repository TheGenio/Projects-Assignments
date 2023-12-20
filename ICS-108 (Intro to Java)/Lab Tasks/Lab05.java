public class Lab05 {
    public static void main(String[] args) {
        point p1 = new point();
        point p2 = new point(10, 30.5);
        System.out.println(p1.distance(p2));


    }}
class point {

        double x;
        double y;

        point() {
            x = 0;
            y = 0;
        }

        point(double xCord, double yCord) {
            x = xCord;
            y = yCord;
        }

        double distance(point p) {
            return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
        }


    }

