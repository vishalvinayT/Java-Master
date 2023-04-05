package avltree;


import binarytree.ListNode;
import binarytree.Main;

public class AVLTree {

    private int getHeight(ListNode node){
        if(node!=null){
            return calculateHeight(node);
        }
        return 0; 
    }

    private int calculateHeight(ListNode node){
        int left=1;
        int right=1;
        ListNode leftNode=node;
        ListNode rightNode=node;
        if(leftNode.left!=null){
            leftNode=leftNode.left;
            left++;
        }
        if(rightNode.right!=null){
            rightNode=rightNode.right;
            right++;
        }
        while(leftNode.left!=null || leftNode.right!=null){
            if(leftNode.left!=null){
                leftNode=leftNode.left;
                left++;
            }
            if(leftNode.right!=null){
                leftNode=leftNode.right;
                left++;
            }

        }
        while(rightNode.left!=null || rightNode.right!=null){
            if(rightNode.left!=null){
                rightNode=rightNode.left;
                right++;
            }
            if(rightNode.right!=null){
                rightNode=rightNode.right;
                right++;
            }
        }
        return Math.max(left,right);
    }


    private int balanceFactor(ListNode node){
        int leftHeight= node.left!=null? getHeight(node.left):0;
        int rightHeight= node.right!=null? getHeight(node.right):0;
        return rightHeight-leftHeight;
    }

    private ListNode rightRotate(ListNode imbalancedNode){
        ListNode left=imbalancedNode.left;
        ListNode floatingNode=left.right;
        left.right=imbalancedNode;
        imbalancedNode.left=floatingNode;
        return left;
    }

    private ListNode leftRotate(ListNode imbalancedNode){
        ListNode right=imbalancedNode.right;
        ListNode floatingNode=right.left;
        right.left=imbalancedNode;
        imbalancedNode.right=floatingNode;
        return right;
    }

    public ListNode insert(ListNode head, int value){
        ListNode copy=head;
        if(copy==null){
            return new ListNode(value);
        }
        if(value<(int)copy.value){
            copy.left=insert(copy.left, value);
        }
        else if(value>(int) copy.value){
            copy.right=insert(copy.right,value);
        }
        int bf=balanceFactor(copy);
        // if bf is < -1 then left is grater
        // if bf is > 1 then right is grater
        if(bf<-1  && value<(int) copy.left.value){
            return rightRotate(copy);

        }
        if(bf>1 && value>(int) copy.right.value){
            return leftRotate(copy);
        }
        if(bf<-1 && value>(int) copy.left.value){
            copy.left=leftRotate(copy.left);
            return rightRotate(copy);
        }
        if(bf>1 && value<(int) copy.right.value){
            copy.right=rightRotate(copy.right);
            return leftRotate(copy);
        }
        return head;

    }

}
