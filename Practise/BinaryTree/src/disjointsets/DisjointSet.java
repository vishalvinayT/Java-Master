package disjointsets;


public class DisjointSet {

    public SetNode[] initSet(int[] initArray){
        if(initArray!=null){
            SetNode[] setNodes= new SetNode[initArray.length];
            for(int i=0;i<initArray.length;i++){
                setNodes[i]= new SetNode(i);
                setNodes[i].representative= new SetNode(i);
            }
            return  setNodes;
        }
        return null;
    }
    public void union(SetNode[] setArray, SetNode set1,SetNode set2){
        if(setArray!=null){
            SetNode set1rep=findRepresentative(set1);
            SetNode set2rep=findRepresentative(set2);
            if(set1rep.rank>=set2rep.rank){
                set2rep.representative=set1;
                set1rep.rank=set2rep.rank!=0?set1rep.rank+set2.rank:set1rep.rank+1;
            } else if (set2rep.rank>set1rep.rank) {
                set1rep.representative=set2;
                set2rep.rank=set1rep.rank!=0? set2rep.rank+set1rep.rank:set2rep.rank+1;
            }
        }
    }
    private SetNode findRepresentative(SetNode setNode){
        if(setNode.value==setNode.representative.value){
            return setNode;
        }
        return findRepresentative(setNode.representative);
    }
}
