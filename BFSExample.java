import java.io.*;
import java.util.LinkedList;

class Graph{
    private int edges;
    private int vertices;
    private LinkedList<Integer> adjlist[];
    Graph(int vert){
        edges=0;
        vertices=vert;
        adjlist=new LinkedList[vert+1];
        for(int i=1;i<=this.vertices;i++){
            adjlist[i]=new LinkedList();
        }
    }
    public void add(int v1,int v2){
        adjlist[v1].add(v2);
        adjlist[v2].add(v1);
        edges++;
    }
    public void PrintBFS(int origin){
        boolean visited[]=new boolean[vertices+1];
        LinkedList<Integer> Q=new LinkedList();
        Q.add(origin);
        visited[origin]=true;
        while(Q.size()!=0){

            int vertice=Q.poll();
            System.out.print(vertice+" ");
           int i=0;
            while(i<adjlist[vertice].size())
            {
               int vert=adjlist[vertice].get(i);
              
               if(!visited[vert])
                {
                    Q.add(vert);
                    visited[vert]=true;
                }
               i++;
            }

        }
    }
     

}
class BFSExample{
    public static void main(String args[]){
        Graph graph=new Graph(6);
        graph.add(1,2);
        graph.add(1,3);
        graph.add(2,4);
        graph.add(2,5);
        graph.add(5,3);
        graph.add(4,5);
        graph.add(4,6);
        graph.add(5,6);
        graph.PrintBFS(2);
    }
}
