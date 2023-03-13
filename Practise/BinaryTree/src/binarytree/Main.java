package binarytree;


public class Main {
    public static void main(String[] args) {
        ListNode head= new ListNode(2);
        head.left=new ListNode(new ListNode(1),11, new ListNode(12));
        head.right= new ListNode(4, new ListNode(3));
    }
}