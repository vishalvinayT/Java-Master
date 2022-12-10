

public class myLinkedList implements myList {
    public ListItem root=null; // root is head
    public myLinkedList(ListItem item){
        this.root= item;
    }

    @Override
    public ListItem getRoot(){
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem){
        if(this.root==null){
            this.root=newItem;
            return true;
        }
        ListItem currentItem= this.root;
        while(currentItem!=null){
            int value= currentItem.compareTo(newItem);
            if(value<0){
                if(currentItem.next()!=null){
                    currentItem=currentItem.next();
                }
                else{
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }
            else if(value>0){
                if(currentItem.previous()!=null){
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                }
                else{
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root=newItem;
                    return true;
                }
            }
            else{
                System.out.println("They are Equal");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item){
        if(item!=null){
            System.out.println("deleting item");
        }
        ListItem currentItem=this.root;
        while(currentItem!=null){
            int value=currentItem.compareTo(item);
            if(value==0){
                if(currentItem==this.root){
                    this.root=currentItem.next();
                }
                else{
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next()!=null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if (value<0){
                currentItem=currentItem.next();
            }
            else{
                System.out.println("item not found");
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem item){
        if(item==null){
            System.out.println("The list is empty");
        }
        else{
            while(item!=null){
                System.out.println(item.getValue());
                item=item.next();
            }
        }
    }
}
