import java.util.Optional;

public class Main {

    // These examples are for compilation purpose
    public static void main(String[] args) {

        // ** Intersection **
        Rectangle rec1 = new Rectangle(2, 5, 4, 3);
        Rectangle rec2 = new Rectangle(3, 4, 4, 5);
        System.out.println(rec1);
        System.out.println(rec2);

        Optional<Rectangle> iRec = rec1.intersection(rec2);
        if (iRec.isPresent()) {
            System.out.println("Intersection result: " + iRec.get() + "\n");
        } else {
            System.out.println("Intersection result: empty\n");
        }

        // ** Containment **
        Rectangle rec3 = new Rectangle(2, 3, 5, 6);
        Rectangle rec4 = new Rectangle(2, 3, 3, 2);
        System.out.println(rec3);
        System.out.println(rec4);

        boolean isContained = rec3.contains(rec4);
        System.out.println("Containment result: " + isContained + "\n");

        // ** Adjacency **
        Rectangle rec5 = new Rectangle(1, 2, 4, 4);
        Rectangle rec6 = new Rectangle(5, 4, 3, 4);
        System.out.println(rec5);
        System.out.println(rec6);

        boolean isAdjacent = rec5.adjacent(rec6);
        System.out.println("Adjacency result: " + isAdjacent);
    }

}
