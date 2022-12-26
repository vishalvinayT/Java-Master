

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
            ListNode<T> added=new ListNode(value);
            added.previous=copy;
            copy.next=added;
        }
    }


    public void insertBegining(T value){
        ListNode<T> copy=head;
        ListNode<T> ptr=copy.next;
        ListNode<T> data=new ListNode<>(value);
        copy.next=data;
        data.previous=copy;
        data.next=ptr;
        ptr.previous=data;
    }

    public void insertBetween(int index,T value){
        ListNode<T> copy=head;
        ListNode<T> data=new ListNode<>(value);
        int i=0;
        while(i<=index-1){
            copy=copy.next;
            i++;
        }
        ListNode<T> ptr=copy.next;
        copy.next=data;
        data.previous=copy;
        data.next=ptr;
        ptr.previous=data;

    }

    public void insertAfterNode(ListNode<T> node, T value){
        ListNode<T> copy=head;
        ListNode<T> data=new ListNode<>(value);
        while(copy.next!=null && !copy.equals(node)){
            copy=copy.next;
        }
        if(copy.equals(node)){
            ListNode<T> ptr=copy.next;
            copy.next=data;
            data.previous=copy;
            data.next=ptr;
            ptr.previous=data;
        }

    }

    public void traverseList(MyList list){
        ListNode copy=list.head.next;
        int index=0;
        while(copy!=null){
            System.out.println("index: "+ index +" value: "+ copy.value);
            copy=copy.next;
            index++;
        }
    }


}
