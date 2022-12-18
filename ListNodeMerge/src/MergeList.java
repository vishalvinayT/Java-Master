public class MergeList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalList=new ListNode(0);
        ListNode dummyList=finalList;
        if(list1==null && list2==null){
            return null;
        }
        else{
            if(list1==null && list2!=null){
                return list2;
            }
            else if(list1!=null && list2==null){
                return list1;
            }

            else{
                while(list2!=null){
                    addValue(list1,list2.val);
                    list2=list2.next;

                }
                return list1;
            }

        }

    }

    public void addValue(ListNode list, int value){
        if(list==null){
            return;
        }
        ListNode dummy=list;
        boolean added=false;

        while(dummy!=null) {
            if(dummy.next==null && !added){
                if(value>dummy.val){
                    dummy.next=new ListNode(value);
                    break;
                }
            }
            if (value < dummy.val) {
                int a = dummy.val;
                ListNode newList = new ListNode(a, dummy.next);
                dummy.val = value;
                dummy.next = newList;
                added=true;
                break;
            }
            dummy=dummy.next;
        }
    }
}
