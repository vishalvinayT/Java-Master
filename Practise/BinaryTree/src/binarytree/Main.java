package binarytree;


import javax.print.attribute.standard.SheetCollate;

public class Main {
    public static void main(String[] args) {
        ListNode head=new ListNode(6);
        BinaryTree tree= new BinaryTree();
        tree.addLeft(head,4 );
        tree.addRight(head,7);
        tree.addLeft(head.left,3);
        tree.addRight(head.left,5);

//        tree.preTraversal(head);
//        System.out.println();
//        tree.postTraversal(head);
//        System.out.println();
//        tree.inorderTraversal(head);
//        System.out.println();
//        System.out.println(tree.isBST(head));
        //System.out.println(tree.binarySearch(head,5));
        //System.out.println(tree.binarySearchIterative(head,7));
        //tree.binarySearchInsert(head,1);
        tree.inorderTraversal(tree.deleteNode(head,6));

    }
}