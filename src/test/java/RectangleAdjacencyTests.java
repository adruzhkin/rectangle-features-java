import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Rectangle Adjacency Tests")
public class RectangleAdjacencyTests {

    private static Rectangle tRec;

    @BeforeAll
    public static void create_This_Rectangle() {
        tRec = new Rectangle(4, 5, 4, 4);
    }

    @DisplayName("Adjacent on Right side as Sub line")
    @Test
    public void adjacent_Right_Side_Sub_True() {
        Rectangle rec = new Rectangle(8, 6, 3, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Right side as Proper line")
    @Test
    public void adjacent_Right_Side_Proper_True() {
        Rectangle rec = new Rectangle(8, 5, 3, 4);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Right side as Partial line")
    @Test
    public void adjacent_Right_Side_Partial_True() {
        Rectangle rec = new Rectangle(8, 3, 3, 4);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Left side as Sub line")
    @Test
    public void adjacent_Left_Side_Sub_True() {
        Rectangle rec = new Rectangle(1, 6, 3, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Left side as Proper line")
    @Test
    public void adjacent_Left_Side_Proper_True() {
        Rectangle rec = new Rectangle(1, 5, 3, 4);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Left side as Partial line")
    @Test
    public void adjacent_Left_Side_Partial_True() {
        Rectangle rec = new Rectangle(1, 3, 3, 4);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Top side as Sub line")
    @Test
    public void adjacent_Top_Side_Sub_True() {
        Rectangle rec = new Rectangle(5, 3, 2, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Top side as Proper line")
    @Test
    public void adjacent_Top_Side_Proper_True() {
        Rectangle rec = new Rectangle(4, 3, 4, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Top side as Partial line")
    @Test
    public void adjacent_Top_Side_Partial_True() {
        Rectangle rec = new Rectangle(2, 3, 2, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Bottom side as Sub line")
    @Test
    public void adjacent_Bottom_Side_Sub_True() {
        Rectangle rec = new Rectangle(5, 9, 2, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Bottom side as Proper line")
    @Test
    public void adjacent_Bottom_Side_Proper_True() {
        Rectangle rec = new Rectangle(4, 9, 4, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Adjacent on Bottom side as Partial line")
    @Test
    public void adjacent_Bottom_Side_Partial_True() {
        Rectangle rec = new Rectangle(2, 9, 2, 2);
        Assertions.assertTrue(tRec.adjacent(rec));
    }

    @DisplayName("Not Adjacent")
    @Test
    public void adjacent_False() {
        Rectangle rec = new Rectangle(2, 10, 2, 2);
        Assertions.assertFalse(tRec.adjacent(rec));
    }

}
