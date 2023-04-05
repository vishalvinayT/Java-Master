package binarytree;

public class BinaryTree {
    private static ListNode previous=null;

    public void addLeft(ListNode head,Object value){
        head.left=new ListNode(value);
    }

    public void addRight(ListNode head,Object value){
        head.right= new ListNode(value);
    }

    public void preTraversal(ListNode head){
        if(head!=null){
            System.out.print(""+head.value);
            preTraversal(head.left);
            preTraversal(head.right);
        }
    }
    public void postTraversal(ListNode head){
        if(head!=null){
            postTraversal(head.left);
            postTraversal(head.right);
            System.out.print(""+head.value);
        }
    }
    public void inorderTraversal(ListNode head){
        if(head!=null){
            inorderTraversal(head.left);
            System.out.printf("%4d",head.value);
            inorderTraversal(head.right);
        }
    }

    public boolean isBST(ListNode head){
        if(head!=null){
            if(!isBST(head.left)){
                return false;
            }
            if(previous!=null && (int) head.value<=(int)previous.value){
                return  false;
            }
            previous=head;
            return isBST(head.right);
        }
        return true;
    }
    public boolean binarySearch(ListNode head,Object value){
        ListNode copy=head;
        if(copy!=null){
            if((int)value<(int)copy.value){
                copy=copy.left;
                binarySearch(copy,value);
            }
            if((int) value > (int) copy.value ){
                copy=copy.right;
                binarySearch(copy,value);
            }
            if((int) value == (int)copy.value){
                return true;
            }
        }
        return false;
    }

    public boolean binarySearchIterative(ListNode head, Object value){
        ListNode copy= head;
        while(copy!=null){
            if((int) copy.value==(int) value){
                return true;
            }
            else if((int)copy.value>(int)value){
                copy=copy.left;
            }
            else copy=copy.right;
        }
        return false;
    }
    public void binarySearchInsert(ListNode head, Object value){
        ListNode copy= head;
        ListNode prev=null;
        while(copy!=null){
            prev=copy;
            if((int) copy.value==(int)value){
                return;
            }
            else if((int) value<(int) copy.value){
                copy=copy.left;
            }
            else{
                copy=copy.right;
            }
        }
        if((int) value<(int) prev.value){
            prev.left=new ListNode(value);

        }else{
            prev.right=new ListNode(value);
        }
    }


    public ListNode deleteNode(ListNode head, Object value){
        ListNode copy=head;
        if(copy==null){
            return null;
        }
        if(copy.left==null && copy.right==null){
            return null;

        }
        if((int) value<(int) copy.value){
            copy.left=deleteNode(copy.left,value);
        }
        else if((int) value>(int) copy.value){
            copy.right=deleteNode(copy.right,value);
        }
        else{
            ListNode predecessor=predecessor(head);
            copy.value=predecessor.value;
            copy.left=deleteNode(copy.left,predecessor.value);
        }
        return copy;
    }

    private ListNode predecessor(ListNode root){
        if(root!=null){
            ListNode copy=root.left;
            while(copy.right!=null){
                copy=copy.right;
            }
            return copy;
        }
        return null;
    }
}
