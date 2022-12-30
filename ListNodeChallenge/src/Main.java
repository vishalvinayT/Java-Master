public class Main {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        ListNode second= new ListNode(2);
        head.next=second;
        ListNode third= new ListNode(3);
        second.next=third;
        ListNode fouth= new ListNode(4);
        third.next=fouth;
        ListNode fifth= new ListNode(5);
        fouth.next=fifth;

        ListNodeSwap swap=new ListNodeSwap();
        ListNode solVal= swap.swapPairs(head);


//        Solution solution= new Solution();
//        ListNode sol=solution.removeNthFromEnd(head,1);


    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start= new ListNode(0);
        start.next=head;
        head=start;
        ListNode ptr= head;
        ListNode q=head.next;

        if(ptr==null || q==null){
            return null;
        }
        while(q!=null){
            ListNode copy=ptr;
            for(int i=1; i<=n;i++){
                copy=copy.next;
            }
            if(copy.next==null){
                ptr.next=q.next;
                break;
            }
            ptr=ptr.next;
            q=q.next;
        }
        return head.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }