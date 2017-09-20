import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private String name;
    private List<FamilyTree> children;
    private int numDescendants = 0;

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
        System.out.println("Start getNumDescendants for: " + this.getName() );

        if(this.children.size() != this.numDescendants) {
            numDescendants = this.children.size();
            System.out.println("Children detected");
            for (FamilyTree child : this.children) {
                System.out.println("Looking at child: " + child.getName());
                numDescendants += child.getNumDescendants();
            }
        }
        System.out.println("numDescendants is: " + this.numDescendants);
        return numDescendants;
    }

    //Returns the number of descendants (including grandchildren, great grandchildren, etc)
    //Of name. If name is NOT in the tree, return -1
    public int getNumDescendantsOf (String name) {
        FamilyTree rootNode = this.getRootNodeByName(name);
        return rootNode.getNumDescendants();
    }

    public FamilyTree getRootNodeByName(String name) {
        if( name.equals(this.name) ) {
            return this;
        } else {
            for(FamilyTree c: this.getChildren() ) {
                if( name.equals(c.name) ){
                    return c;
                } else {
                    if (c.contains(name)) {
                        return c;
                    }
                }
            }
        }
        return new FamilyTree("");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", numDescendants=" + numDescendants +
                '}';
    }
}
