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

        numDescendants = this.children.size();
        for (FamilyTree child : this.children) {
            System.out.println("Looking at child: " + child.getName());
            numDescendants += child.getNumDescendants();
        }

        System.out.println("numDescendants is: " + this.numDescendants);
        return numDescendants;
    }

    //Returns the number of descendants (including grandchildren, great grandchildren, etc)
    //Of name. If name is NOT in the tree, return -1
    public int getNumDescendantsOf (String name) {
        System.out.println("Starting search for: " + name);
        FamilyTree rootNode = this.getRootNodeByName(name);
        // if rootNode.name is an empty string, that means we didn't find it
        if( rootNode.getName().equals("") ) {
            return -1;
        }
        System.out.println("Found root node for search: " + rootNode.getName());
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
                    return c.getRootNodeByName(name);
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
