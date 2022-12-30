public class ListNodeSwap {
    public ListNode swapPairs(ListNode head) {

        ListNode ptr= head;
        if(ptr==null){
            return null;
        }
        ListNode q= head.next;
        if(q==null){
            return head;
        }else{
            while(q!=null){

                try{
                    int temp= ptr.val;
                    ptr.val=q.val;
                    q.val=temp;
                    ptr=q.next;
                    q=ptr.next;
                }catch (NullPointerException e){
                    break;
                }
            }
        }
        return head;
    }

}
