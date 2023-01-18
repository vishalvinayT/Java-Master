package ListPackage;


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
    public void deleteBegining(){
        ListNode<T> ptr=head.next;
        head.next=ptr.next;
        ptr.previous=head;
    }

    public void deleteBetween(int index){
        ListNode<T> p=head;
        ListNode<T> q=head.next;
        int i=0;
        while(i<index && q.next!=null){
            p=p.next;
            q=q.next;
            i++;
        }
        if(q.next==null && i==index){
            p.next=null;
        }
        else if(i==index){
            p.next=q.next;
            q.next.previous=p;
        }
        else{
            System.out.println("Item not found");
        }
    }

    public void deleteEnd(){
        ListNode<T> p=head;
        ListNode<T> q=head.next;
        int i=0;
        while(q.next!=null){
            p=p.next;
            q=q.next;
        }
        p.next=null;
    }

    public void deleteAtValue(T val){
        ListNode<T> p=head;
        ListNode<T> q=head.next;
        while(!q.value.equals(val) && q.next!=null){
            p=p.next;
            q=q.next;

        }
        if(q.value.equals(val) && q.next==null){
            p.next=null;
        }
        else if(q.value.equals(val)){
            p.next=q.next;
            q.next.next.previous=p;
        }
    }



    public void traverseList(){
        ListNode copy=head.next;
        int index=0;
        while(copy!=null){
            System.out.println("index: "+ index +" value: "+ copy.value);
            copy=copy.next;
            index++;
        }
    }


}
