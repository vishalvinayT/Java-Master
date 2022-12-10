

public abstract class ListItem {
    // For this challenge, create an abstract class to define items that can be stored in a list.
    // The class should contain 2 references to items which will represent the next and previous
    // items (in the case of a linked list).
    // I.e., if you call your abstract class ListItem, then it would have 2 member variables of
    // type ListItem that will hold references to the next/right and previous/left ListItems.
    //
    // The abstract class will also need to hold a value - try to be as flexible as possible
    // when defining the type of this value.
    //
    // The class will also need methods to move to the next item and back to the previous item,
    // and methods to set the next and previous items.
    public ListItem left=null;
    public ListItem right=null;
    public Object value;

    public ListItem(Object value){
        this.value=value;
    }
    public abstract ListItem next();
    public abstract ListItem previous();
    public abstract ListItem setPrevious(ListItem item);

    public abstract ListItem setNext(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue(){
        return this.value;
    }
    public void setValue(Object value){
        this.value=value;
    }
}
