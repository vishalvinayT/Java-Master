package disjointsets;


public class SetNode {
    public int value;
    public int rank=0;
    SetNode representative;

    public SetNode(int value){
        this.value=value;
    }
}
