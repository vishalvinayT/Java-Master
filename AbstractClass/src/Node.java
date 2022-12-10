
public class Node extends ListItem{
    public Node(Object value){
        super(value);
    }
    @Override
    public ListItem next(){
        return this.right;
    }

    @Override
    public ListItem previous(){
        return this.left;
    }

    @Override
    public ListItem setPrevious(ListItem item){
        this.left=item;
        return this.left;
    }
    @Override
    public ListItem setNext(ListItem item){
        this.right=item;
        return this.right;
    }

    @Override
    public int compareTo(ListItem item){
        if(item!=null){
            return ((String) super.getValue()).compareTo(((String) item.getValue()));
        }
        else{
            return -1;
        }
    }
}
