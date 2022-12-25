
public class ListNode<T> {
    public ListNode<T> previous;
    public T value;

    public int index=-1;
    public ListNode<T> next;
    public ListNode(){
    }
    public ListNode(T value){
        this.value=value;
    }

    public ListNode(T value, int index){
        this.value=value;
        this.index=index;
    }

    public void setValue(T value){
        this.value=value;
    }


}
