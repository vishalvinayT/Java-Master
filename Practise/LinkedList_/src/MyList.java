

public class MyList<T> {

    public ListNode<T> head=new ListNode<T>();

    public MyList(){
        head.previous=null;
    }


    public void add(T value){
        if(head==null){
            head.setValue(value);
        }
        else{
              ListNode<T> copy=head;
            while(copy.next!=null){
                copy=copy.next;
            }
            ListNode<T> added=new ListNode(value,copy.index+1);
            added.previous=copy;
            copy.next=added;
        }
    }


    public void traverseList(MyList list){
        ListNode copy=list.head.next;
        while(copy!=null){
            System.out.println("index: "+ copy.index+" value: "+ copy.value);
            copy=copy.next;
        }
    }


}
