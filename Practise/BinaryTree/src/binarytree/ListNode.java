package binarytree;

import java.util.List;

public class ListNode {
    public ListNode left;
    public ListNode right;
    public Object value;

    public ListNode(Object value){
        this.value=value;
    }
    public ListNode(ListNode left, Object value, ListNode right){
        this.left=left;
        this.value=value;
        this.right=right;
    }

    public ListNode(ListNode left, Object value){
        this.left=left;
        this.value=value;
    }

    public ListNode(Object value, ListNode right){
        this.value=value;
        this.right=right;
    }


}
