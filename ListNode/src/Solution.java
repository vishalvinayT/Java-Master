class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode finalList=new ListNode();
        ListNode cur=finalList;

        while(l1!=null || l2!=null || carry!=0){
            int val=0;
            if(l1!=null){
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            val+=carry;
            carry=val/10;
            val%=10;
            cur.next=new ListNode(val);
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        return finalList.next;
    }
}

