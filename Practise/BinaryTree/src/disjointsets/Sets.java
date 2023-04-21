package disjointsets;

public class Sets {
    public static void main(String[] args){
        DisjointSet set= new DisjointSet();
        SetNode[] setArray= set.initSet(new int[9]);
        set.union(setArray,setArray[2],setArray[5]);
        set.union(setArray,setArray[3],setArray[4]);
        set.union(setArray,setArray[3],setArray[1]);
        set.union(setArray,setArray[2],setArray[3]);

    }
}
