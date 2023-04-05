package graphs;


import Queue.QueueArr;

public class Graphs {
    public static void main(String[] args){
        int[][] adjacentMatrix= new int[][]{{0,1,1,1,0,0,0},{1,0,1,0,0,0,0},{1,1,0,1,1,0,0},{1,0,1,0,1,0,0},{0,0,1,1,0,1,1},{0,0,0,0,1,0,0},{0,0,0,0,1,0,0}};
        bfs(adjacentMatrix);
        dfs(adjacentMatrix,0);
    }
    private static void bfs(int[][] adjacentMatrix){
        if(adjacentMatrix!=null){
            QueueArr<Integer> explored= new QueueArr(adjacentMatrix.length);
            boolean[] visited = new boolean[adjacentMatrix.length];
            explored.enQueue(0);
            while(!explored.isEmpty()){
                int value=explored.deQueue();
                for(int i=0;i<adjacentMatrix[0].length; i++){
                    if(adjacentMatrix[value][i]>0 && !visited[i]){
                        visited[i]=true;
                        explored.enQueue(i);
                        System.out.printf("%4d",i);
                    }
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] adjacentMatrix, int startIndex){
        if(adjacentMatrix!=null){
            boolean[] v= new boolean[adjacentMatrix.length];
            dfsUtil(0,v,adjacentMatrix);
        }
    }

    private static void dfsUtil(int value, boolean[] visited, int[][] adjecentMatrix){
        System.out.printf("%4d",value);
        visited[value]=true;
        for(int i=0; i<adjecentMatrix[0].length;i++){
            if(adjecentMatrix[value][i]>0 && !visited[i]){

                dfsUtil(i,visited,adjecentMatrix);
            }
        }
    }
}
