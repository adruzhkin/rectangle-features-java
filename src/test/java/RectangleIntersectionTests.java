import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@DisplayName("Rectangle Intersection Tests")
public class RectangleIntersectionTests {

    private static Rectangle tRec;

    @BeforeAll
    public static void create_This_Rectangle() {
        tRec = new Rectangle(5, 5, 4, 3);
    }

    @DisplayName("Intersection on Right half")
    @Test
    public void intersection_Right_Half_True() {
        Rectangle rec = new Rectangle(7, 4, 4, 5);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(7, 5, 2, 3);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection on Left half")
    @Test
    public void intersection_Left_Half_True() {
        Rectangle rec = new Rectangle(3, 4, 4, 5);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(5, 5, 2, 3);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection on Top half")
    @Test
    public void intersection_Top_Half_True() {
        Rectangle rec = new Rectangle(4, 3, 6, 4);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(5, 5, 4, 2);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection on Bottom half")
    @Test
    public void intersection_Bottom_Half_True() {
        Rectangle rec = new Rectangle(4, 6, 6, 4);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(5, 6, 4, 2);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection on Top-Right corner")
    @Test
    public void intersection_Top_Right_Corner_True() {
        Rectangle rec = new Rectangle(7, 3, 3, 4);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(7, 5, 2, 2);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection on Bottom-Right corner")
    @Test
    public void intersection_Bottom_Right_Corner_True() {
        Rectangle rec = new Rectangle(7, 6, 3, 4);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(7, 6, 2, 2);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection on Bottom-Left corner")
    @Test
    public void intersection_Bottom_Left_Corner_True() {
        Rectangle rec = new Rectangle(4, 6, 3, 4);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(5, 6, 2, 2);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection on Top-Left corner")
    @Test
    public void intersection_Top_Left_Corner_True() {
        Rectangle rec = new Rectangle(4, 3, 3, 4);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = new Rectangle(5, 5, 2, 2);
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection Full")
    @Test
    public void intersection_Full_True() {
        Rectangle rec = new Rectangle(4, 4, 6, 5);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = tRec;
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("Intersection Full Reversed")
    @Test
    public void intersection_Full_Reversed_True() {
        Rectangle rec = new Rectangle(4, 4, 6, 5);

        Optional<Rectangle> res = rec.intersection(tRec);
        Assertions.assertTrue(res.isPresent());

        Rectangle exp = tRec;
        Assertions.assertEquals(res.get(), exp);
    }

    @DisplayName("No Intersection")
    @Test
    public void intersection_False() {
        Rectangle rec = new Rectangle(1, 3, 4, 3);

        Optional<Rectangle> res = tRec.intersection(rec);
        Assertions.assertFalse(res.isPresent());
    }

}
