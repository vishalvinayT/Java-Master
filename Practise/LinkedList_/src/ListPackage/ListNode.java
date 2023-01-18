package ListPackage;

public class ListNode<T> {
    public ListNode<T> previous;
    public T value;

    public ListNode<T> next;
    public ListNode(){
    }
    public ListNode(T value){
        this.value=value;
    }


    public void setValue(T value){
        this.value=value;
    }

}
