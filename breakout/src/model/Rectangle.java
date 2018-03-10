package model;

/**
 * Base class for all rectangular shapes (paddle, brick, ball, ...)
 */
public class Rectangle {
    private int x;         // X coordinate of upper left corner.
    private int y;         // Y coordinate of upper left corner.
    private int width;     // Width of rectangle.
    private int height;    // Height of rectangle.

    /**
     * Create a rectangle.
     *
     * @param x X coordinate of upper left corner.
     * @param y Y coordinate of upper left corner.
     * @param width Width.
     * @param height Height.
     */
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Check if a point is contained in this rectangle.
     *
     * @param pointX X coordinate of point.
     * @param pointY Y coordinate of point.
     * @return True if point is in this rectangle.
     */
    public boolean contains(int pointX, int pointY) {
        return pointX >= x && pointX < x + width &&
                pointY >= y && pointY < y + height;
    }

    /**
     * Check if this rectangle intersects another.
     *
     * @param other The other rectangle.
     * @return true if 'this' and 'other' interset.
     */
    public boolean intersects(Rectangle other) {
        // Check four corners of 'other'. If any contained in 'this', return true.
        if (contains(other.x, other.y))
            return true;
        if (contains(other.x + other.width - 1, other.y))
            return true;
        if (contains(other.x, other.y + other.height - 1))
            return true;
        if (contains(other.x + other.width - 1, other.y + other.height - 1))
            return true;
        return false;
    }

    /** Get x coordinate of upper left corner. */
    public int getX() {
        return x;
    }

    /** Get y coordinate of upper left corner. */
    public int getY() {
        return y;
    }

    /** Set x coordinate of upper left corner. */
    public void setX(int x) {
        this.x = x;
    }

    /** Set y coordinate of upper left corner. */
    public void setY(int y) {
        this.y = y;
    }

    /** Get width of rectangle. */
    public int getWidth() {
        return width;
    }

    /** Get height of rectangle. */
    public int getHeight() {
        return height;
    }

    public void print() {
        System.out.println("  " + x + " " + y + " " + width + " " + height);
    }

    /** Test code for Rectangle class. */
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0, 0, 10, 10);
        Rectangle r2 = new Rectangle(5, 5, 10, 10);
        Rectangle r3 = new Rectangle(10, 10, 10, 10);
        check(r1.intersects(r2));
        check(r2.intersects(r1));
        check(!r1.intersects(r3));
        check(!r3.intersects(r1));
        check(r2.intersects(r3));
        check(r3.intersects(r2));
        System.out.println("Rectangle tests passed.");
    }

    public static void check(boolean expression) {
        if (!expression) {
            throw new RuntimeException("Test failed.");
        }
    }
}
