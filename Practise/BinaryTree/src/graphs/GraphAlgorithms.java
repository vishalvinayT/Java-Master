package graphs;

import Queue.QueueArr;

import java.util.HashMap;
import java.util.Map;

public class GraphAlgorithms {
    public void khanAlgo(int[][] inputGraph){
        //todo: calculate indegree of nodes of graph.
        // traverse through the indegrees of the graph and enqueue in the queue nodes with 0 indegree
        // while the queue is not empty explore the node and decrement 1 from the indegree for the visited nodes
        // if the indegree is 0 after decrementing then add to queue and repeat the process
        if(inputGraph!=null){
            // calculating the indegree of the nodes for the input graph
            int[] indegree= calculateIndegree(inputGraph);
            boolean[] visited= new boolean[inputGraph.length];
            QueueArr<Integer> sortQueue= new QueueArr<>(inputGraph.length);
            // first finding all the vertices with indegree 0
            for(int i=0; i<inputGraph.length;i++){
                if(indegree[i]==0){
                    sortQueue.enQueue(i);
                }
            }
            // traversing the graph for all the nodes with indegree 0
            while(!sortQueue.isEmpty()){
                int value=sortQueue.deQueue();
                System.out.println(value);
                visited[value]=true;
                for(int col=0; col<inputGraph.length;col++){
                    if(inputGraph[value][col]>0 && !visited[col]){
                        indegree[col]--;
                        if(indegree[col]==0){
                            sortQueue.enQueue(col);
                        }
                    }
                }
            }

            //evaluate(inputGraph,indegree,visited,0);
        }
    }
    private void evaluate(int[][] inputGraph, int[] indegree,boolean[] visited, int row){
        for(int col=0; col<inputGraph[0].length;col++){
            if(inputGraph[row][col]>0 && !visited[col]){
                indegree[col]--;
                if(indegree[col]==0){
                    visited[col]=true;
                    System.out.println(col);
                }
                evaluate(inputGraph,indegree,visited,col);

            }
        }
    }
    private int[] calculateIndegree(int[][] inputGraph) {
        int[] explored = new int[inputGraph.length];
        boolean[] visited = new boolean[inputGraph.length];
        for(int row=0;row<inputGraph.length;row++){
            visited[row] = true;
            for (int i = 0; i < inputGraph[0].length; i++) {
                if (inputGraph[row][i] > 0 && !visited[i]) {
                    explored[i]+=1;
                }
            }
        }
        return explored;
    }
    public Map<Integer,Integer> dijkstrasAlgo(int[][] inputCostGraph,int startNode){
        // used to the minimum cost spanning tree
        // todo: start with a node and explore the its neighbours and add the costs in the cost array
        //  compare the cost already exists in the array is grater than the new cost
        //  find the minimum cost in the array pop the cost and add it to the total cost and ignore the index of the minimum cost
        //  repeat the process until the bottom of the tree
        if(inputCostGraph!=null){
            Map<Integer, Integer> distanceMap= new HashMap<>();
            QueueArr<Integer> explored=new QueueArr<>(100);
            boolean[] removed=new boolean[inputCostGraph.length];
            int[] costArray=new int[inputCostGraph.length];
            for(int m=0;m<costArray.length;m++){
                costArray[m]=Integer.MAX_VALUE;
            }
            // entry node
            distanceMap.put(startNode,0);
            removed[startNode]=true;
            costArray[startNode]=0;
            explored.enQueue(startNode);
            while(!explored.isEmpty()){
                int minIndex=-1;
                int minValue=Integer.MAX_VALUE;
                int value= explored.deQueue();
                // putting the costs of every node in the costArray
                for(int i =0; i<inputCostGraph[0].length;i++){
                    if(inputCostGraph[value][i]>0 && inputCostGraph[value][i]<costArray[i]){
                        int compareValue=distanceMap.get(value)+inputCostGraph[value][i];
                        if(compareValue<costArray[i] && !removed[i]){
                            costArray[i]= compareValue;
                        }

                    }
                }
                // finding the minimum value in the costarray
                for(int j=0;j< removed.length;j++){
                    if(!removed[j] && costArray[j]<minValue){
                        minValue=costArray[j];
                        minIndex=j;
                    }
                }
                // putting the minimum cost value into the map
                if(minIndex!=-1){
                    distanceMap.put(minIndex,minValue);
                    removed[minIndex]=true;
                    explored.enQueue(minIndex);
                }
            }
            // evacuating the cost array
            for(int f=0; f< removed.length;f++){
                if(!removed[f]){
                    distanceMap.put(f,costArray[f]);
                }
            }
            return distanceMap;
        }
        return null;
    }



    // implementation of dijkstras alogorithm from online
    public int[] dijkrtrasOnline(int[][] inputGraph, int src){
        // not working needs fixing
        if(inputGraph!=null){
            int[] distances=new int[inputGraph.length];
            boolean[] settled = new boolean[inputGraph.length];
            QueueArr<Integer> prorityQueue= new QueueArr<>(100);
            settled[src]=true;
            for(int i=0;i< inputGraph.length;i++){
                if(i!=src){
                    distances[i]=Integer.MAX_VALUE;
                }
                prorityQueue.enQueue(i);
            }
            while(!prorityQueue.isEmpty()){
                int value= prorityQueue.deQueue();
                for(int e=0; e< inputGraph[0].length;e++){
                    int total=distances[value]+inputGraph[value][e];
                    if(total<distances[e] && total>0){
                        distances[e]=total;
                    }
                }

            }
            return distances;
        }
        return null;
    }

    public int primsAlgo(int[][] costMatrix, int src){
        if(costMatrix!=null){
            boolean[] explored= new boolean[costMatrix.length];
            Integer totalCost=0;
            explored[src]=true;
            return evaluate(costMatrix,src,explored,totalCost);

        }
        return -1;
    }

    private int evaluate(int[][] costMatrix, int index, boolean[] explored,Integer totalCost){
        int minIndex=-1;
        int minValue=Integer.MAX_VALUE;
        for(int i=0; i<costMatrix[0].length;i++){
            if(costMatrix[index][i]<minValue && costMatrix[index][i]>0&& !explored[i]){
                minValue=costMatrix[index][i];
                minIndex=i;
            }
        }
        if(minIndex!=-1){
            totalCost+=minValue;
            explored[index]=true;
            return evaluate(costMatrix,minIndex,explored,totalCost);
        }
        return totalCost;
    }


}
