package binarytree;

public class BinaryTree {
    private ListNode head=null;
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
            System.out.print(""+head.value);
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
}
