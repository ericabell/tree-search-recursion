import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Main {
    static FamilyTree charlie = new FamilyTree("Charlie McCall");
    static FamilyTree brenda = new FamilyTree("Brenda Sasser");
    static FamilyTree pops = new FamilyTree("Grampa McCall");
    static FamilyTree casey = new FamilyTree("Casey McCall");

    public static void main(String[] args) {
        buildTree();

        testContains();
        testGetNumDescendants();
        testGetNumDescendantsOf();

        System.out.println("All tests passed!");
    }

    public static void testContains() {
        assertTrue(pops.contains("Charlie McCall"));
        assertTrue(pops.contains("Ben Sasser"));
        assertFalse(pops.contains("McCall"));
        assertFalse(pops.contains("Lando Calrissian"));
    }

    public static void testGetNumDescendants () {
        assertEquals(6, pops.getNumDescendants());
        System.out.println("****");
        assertEquals(2, casey.getNumDescendants());
        System.out.println("****");
        assertEquals(0, charlie.getNumDescendants());
        System.out.println("****");

    }

    public static void testGetNumDescendantsOf () {
        assertEquals(6, pops.getNumDescendantsOf("Grampa McCall"));
        System.out.println("****");
        assertEquals(2, pops.getNumDescendantsOf("Casey McCall"));
        System.out.println("****");
        assertEquals(0, pops.getNumDescendantsOf("Charlie McCall"));
        System.out.println("****");
        assertEquals(-1, pops.getNumDescendantsOf("Lando Calrissian"));
        System.out.println("****");


        charlie.addChild(new FamilyTree("Jonas McCall"));

        assertEquals(7, pops.getNumDescendantsOf("Grampa McCall"));
        assertEquals(3, pops.getNumDescendantsOf("Casey McCall"));
        assertEquals(1, pops.getNumDescendantsOf("Charlie McCall"));
    }

    public static void buildTree () {
        brenda.addChild(new FamilyTree("Sally Sasser"));
        brenda.addChild(new FamilyTree("Ben Sasser"));


        casey.addChild(charlie);
        casey.addChild(new FamilyTree("Dan McCall"));

        pops.addChild(casey);
        pops.addChild(brenda);
    }

}
