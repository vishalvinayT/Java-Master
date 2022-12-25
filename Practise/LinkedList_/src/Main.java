public class Main {
    public static void main(String[] args) {
        MyList<Integer> list=new MyList<Integer>();
        list.add(10);
        list.add(20);
        list.add(70);
        list.add(80);
        list.add(90);

        list.traverseList(list);
    }
}