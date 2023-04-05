package avltree;

import binarytree.ListNode;

public class AVL {
    public static void main(String[] args){
        int[] arr= new int[]{4,23,12,34,123,255};
        ListNode head= new ListNode(10);
        AVLTree tree= new AVLTree();
        for(int i:arr) {
            tree.insert(head,i);
        }

    }
}
