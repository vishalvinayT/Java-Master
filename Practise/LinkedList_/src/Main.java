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

        list.traverseList(list);

        //list.insertBegining(1000);
        //list.insertBetween(2,2000);

        ListNode<Integer> sample=list.head.next.next.next;
        list.insertAfterNode(sample,3000);

        list.traverseList(list);
    }
}