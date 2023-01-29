public class Point {
    private int x;
    private int y;
    private float minimumDistance;

    public Point getClosestPoint() {
        return closestPoint;
    }

    public void setClosestPoint(Point closestPoint) {
        this.closestPoint = closestPoint;
    }

    private Point closestPoint;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(float minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

