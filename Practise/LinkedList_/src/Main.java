public class Main {
    public static void main(String[] args) {
        MyList<Integer> list=new MyList<Integer>();
        list.add(10);
        list.add(20);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(123);
        list.add(34);
        list.add(55);

        list.traverseList();

        //list.insertBegining(1000);
        //list.insertBetween(2,2000);

        ListNode<Integer> sample=list.head.next.next.next;
        list.insertAfterNode(sample,3000);

        list.deleteBegining();
        list.traverseList();


        System.out.println();

        list.deleteBetween(7);
        list.deleteBetween(5);
        list.traverseList();

        System.out.println();

        list.deleteEnd();

        list.traverseList();

        System.out.println();
        list.deleteAtValue(3000);
        list.deleteAtValue(90);
        list.deleteAtValue(20000);
        list.traverseList();
    }
}