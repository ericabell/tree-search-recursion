import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private String name;
    private List<FamilyTree> children;
    private int numDescendants;

    public FamilyTree (String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public void addChild (FamilyTree child) {
        children.add(child);
    }

    public List<FamilyTree> getChildren () {
        return children;
    }

    //Returns true if the tree has a person with "name" anywhere
    public boolean contains (String name) {
        if( name.equals(this.name) ) {
            return true;
        } else {
            for(FamilyTree c: this.getChildren() ) {
                if( name.equals(c.name) ){
                    return true;
                } else {
                    if (c.contains(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public int getNumChildren () {
        return children.size();
    }

    //Returns the number of descendants of this
    public int getNumDescendants () {
        System.out.println("Beginning call to getNumDescendants: " + numDescendants);
        if(this.children.size() != this.numDescendants) {
            for (FamilyTree child : this.children) {
                System.out.println("Child detected " + child.getName());
                numDescendants++;
                System.out.println("uptick in for loop:" + numDescendants);

                numDescendants += child.getNumDescendants();
            }
            return numDescendants;
        }
        return numDescendants;
    }

    //Returns the number of descendants (including grandchildren, great grandchildren, etc)
    //Of name. If name is NOT in the tree, return -1
    public int getNumDescendantsOf (String name) {
        //This is an extra

        return 0;
    }

    public String getName() {
        return name;
    }
}
