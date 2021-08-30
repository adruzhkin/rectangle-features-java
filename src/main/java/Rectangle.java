import java.util.Objects;
import java.util.Optional;

/**
 * A {@code Rectangle} identifies an area as a coordinate
 * point {@code (x,y)} for upper-left corner with
 * {@code (width,height)} dimensions.
 * <p>
 * The constructor to create {@code Rectangle} object
 * does not prevent setting {@code (width,height)} with
 * negative values. However, {@code Rectangle} object with
 * negative {@code (width,height)} does not pass the check
 * to calculate {@code Rectangle} features such as {@link #intersection(Rectangle)},
 * {@link #contains(Rectangle)}, and {@link #adjacent(Rectangle)}.
 * <p>
 * A {@code Rectangle} saves its coordinates and dimensions as
 * integer properties. There is no check if these properties overflow
 * integers MAX or MIN values.
 */
public class Rectangle {

    /**
     * Upper-left corner coordinates as {@code (x1,y1)} properties
     * and {@code (width,height)} dimensions.
     */
    private final int x1;
    private final int y1;
    private final int width;
    private final int height;

    /**
     * Additional {@code (x2,y2)} points to be used
     * internally in {@code Rectangle} methods calculations.
     */
    private final int x2;
    private final int y2;

    /**
     * Constructs a new {@code Rectangle} with upper-left corner identified
     * as {@code (x,y)} coordinates with {@code (width,height)} dimensions.
     * It also assigns additional {@code (x2,y2)} points to be used
     * internally in {@code Rectangle} methods calculations.
     * @param     x is X coordinate
     * @param     y is Y coordinate
     * @param     width is width of this {@code Rectangle}
     * @param     height is height of this {@code Rectangle}
     */
    public Rectangle(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.width = width;
        this.height = height;

        this.x2 = x + width;
        this.y2 = y + height;
    }

    /**
     * Checks if this {@code Rectangle} has an intersection
     * with other {@code Rectangle} and produces a result
     * {@code Rectangle} identifying the points of intersection.
     * @param    other passed {@code Rectangle}.
     * @return   {@code Optional<Rectangle>} if this {@code Rectangle}
     *            has an intersection with other {@code Rectangle};
     *            {@code empty} otherwise.
     */
    public Optional<Rectangle> intersection(Rectangle other) {
        if (hasNegativeDimensions() || other.hasNegativeDimensions()) return Optional.empty();
        if (!hasIntersectionWith(other)) return Optional.empty();

        int nx1 = Math.max(x1, other.x1);
        int ny1 = Math.max(y1, other.y1);
        int nx2 = Math.min(x2, other.x2);
        int ny2 = Math.min(y2, other.y2);

        int nw = nx2 - nx1;
        int nh = ny2 - ny1;

        return Optional.of(new Rectangle(nx1, ny1, nw, nh));
    }

    /**
     * Checks if this {@code Rectangle} contains other {@code Rectangle}.
     * @param    other passed {@code Rectangle}.
     * @return   {@code true} if other {@code Rectangle} is contained
     *           by this {@code Rectangle}; {@code false} otherwise.
     */
    public boolean contains(Rectangle other) {
        if (hasNegativeDimensions() || other.hasNegativeDimensions()) return false;

        if (other.x1 < x1 || other.y1 < y1) return false;
        if (other.x2 > x2 || other.y2 > y2) return false;

        return true;
    }

    /**
     * Checks if other {@code Rectangle} is adjacent to this {@code Rectangle}.
     * Adjacency is defined as other {@code Rectangle} has at least one point
     * next to any side of this {@code Rectangle}.
     * @param    other passed {@code Rectangle}.
     * @return   {@code true} if other {@code Rectangle} is adjacent
     *           to this {@code Rectangle}; {@code false} otherwise.
     */
    public boolean adjacent(Rectangle other) {
        if (hasNegativeDimensions() || other.hasNegativeDimensions()) return false;
        if (hasIntersectionWith(other)) return false;

        Rectangle grown = new Rectangle(other.x1 - 1, other.y1 - 1, other.width + 2, other.height + 2);
        return hasIntersectionWith(grown);
    }

    /**
     * Checks if this {@code Rectangle} has any of its dimensions
     * less or equal to zero.
     * @return   {@code true} if this {@code Rectangle} {@code width}
     *            or {@code height} is less or equal to zero;
     *            {@code false} otherwise.
     */
    private boolean hasNegativeDimensions() {
        return width <= 0 || height <= 0;
    }

    /**
     * Checks if this {@code Rectangle} has an intersection
     * with other {@code Rectangle}. This method is called
     * inside public methods after {@link #hasNegativeDimensions()}
     * check.
     * @param    other passed {@code Rectangle}.
     * @return   {@code true} if this {@code Rectangle} has an intersection
     *            with other {@code Rectangle}; {@code false} otherwise.
     */
    private boolean hasIntersectionWith(Rectangle other) {
        return other.x2 > x1 &&
               other.y2 > y1 &&
               x2 > other.x1 &&
               y2 > other.y1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return x1 == rectangle.x1 && y1 == rectangle.y1 && width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, width, height);
    }

    @Override
    public String toString() {
        return "Rectangle: [" +
                "x=" + x1 +
                ", y=" + y1 +
                ", width=" + width +
                ", height=" + height +
                "]";
    }
}
