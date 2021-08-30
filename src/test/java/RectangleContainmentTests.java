import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Rectangle Containment Tests")
public class RectangleContainmentTests {

    private static Rectangle tRec;

    @BeforeAll
    public static void create_This_Rectangle() {
        tRec = new Rectangle(4, 4, 5, 5);
    }

    @DisplayName("Containment with shared border")
    @Test
    public void contains_With_Shared_Border_True() {
        Rectangle rec = new Rectangle(4, 4, 3, 3);
        Assertions.assertTrue(tRec.contains(rec));
    }

    @DisplayName("Containment without shared border")
    @Test
    public void contains_Without_Shared_Border_True() {
        Rectangle rec = new Rectangle(5, 5, 3, 3);
        Assertions.assertTrue(tRec.contains(rec));
    }

    @DisplayName("No Containment when intersects")
    @Test
    public void contains_When_Intersects_False() {
        Rectangle rec = new Rectangle(7, 5, 3, 3);
        Assertions.assertFalse(tRec.contains(rec));
    }

    @DisplayName("No Containment when overflows")
    @Test
    public void contains_When_Overflows_False() {
        Rectangle rec = new Rectangle(3, 3, 7, 7);
        Assertions.assertFalse(tRec.contains(rec));
    }

    @DisplayName("No Containment")
    @Test
    public void contains_False() {
        Rectangle rec = new Rectangle(0, 5, 3, 3);
        Assertions.assertFalse(tRec.contains(rec));
    }

}
