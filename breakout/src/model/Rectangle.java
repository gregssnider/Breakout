package model;

/**
 * Base class for all rectangular shapes (paddle, brick, ball, ...)
 */
class Rectangle {
    public int x;         // X coordinate of upper left corner.
    public int y;         // Y coordinate of upper left corner.
    public int width;     // Width of rectangle.
    public int height;    // Height of rectangle.

    /**
     * Create a rectangle.
     *
     * @param x X coordinate of upper left corner.
     * @param y Y coordinate of upper left corner.
     * @param width Width.
     * @param height Height.
     */
    Rectangle(int x, int y, int width, int height) {
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
    boolean contains(int pointX, int pointY) {
        return pointX >= x && pointX < x + width &&
                pointY >= y && pointY < y + height;
    }

    /**
     * Check if this rectangle intersects another.
     *
     * @param other The other rectangle.
     * @return true if 'this' and 'other' interset.
     */
    boolean intersects(Rectangle other) {
        // Check four corners of 'other'. If any contained in 'this', return true.
        // Swap roles of this and other and recheck.
        if (contains(other.x, other.y))
            return true;
        if (contains(other.x + other.width - 1, other.y))
            return true;
        if (contains(other.x, other.y + other.height - 1))
            return true;
        if (contains(other.x + other.width - 1, other.y + other.height - 1))
            return true;

        if (other.contains(x, y))
            return true;
        if (other.contains(x + width - 1, y))
            return true;
        if (other.contains(x, y + height - 1))
            return true;
        if (other.contains(x + width - 1, y + height - 1))
            return true;

        return false;
    }

    void print(String prefix) {
        System.out.println(prefix + "  " + x + ".." + (x + width) + "   " + y + ".." + (y + height));
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

    static void check(boolean expression) {
        if (!expression) {
            throw new RuntimeException("Test failed.");
        }
    }
}
