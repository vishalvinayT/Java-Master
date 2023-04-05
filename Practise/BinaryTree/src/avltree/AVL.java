package avltree;

import binarytree.BinaryTree;
import binarytree.ListNode;

public class AVL {
    public static void main(String[] args){
        BinaryTree binaryTree= new BinaryTree();
        int[] arr= new int[]{4,23,12,34,123,255,19,14,145, 16,12871,8173,217,1723,12373,11,0,7127,191,131,7167,17};
        ListNode head= new ListNode(10);
        AVLTree tree= new AVLTree();
        for(int i:arr) {
            head=tree.insert(head,i);
        }

        binaryTree.inorderTraversal(head);


    }
}
