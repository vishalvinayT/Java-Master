public class Main {
    public static void main(String[] args) {
        MergeList list=new MergeList();
        int[] arr1={-2,5};
        int[] arr2={-9,-6,-3,-1,1,6};
        ListNode list1=addValues(arr1);
        ListNode list2=addValues(arr2);
        ListNode res=list.mergeTwoLists(list1,list2);
        printList(res);
    }

    public static ListNode addValues(int[] array){
        ListNode finalList=new ListNode(0);
        ListNode dummy=finalList;
        for(int i=0;i<array.length; i++){
            dummy.next=new ListNode(array[i]);
            dummy=dummy.next;

        }
        return finalList.next;
    }

    public static void printList(ListNode list){
        while(list!=null){
            System.out.printf("%d ", list.val);
            list=list.next;
        }
    }
}