import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
class Graph{
    LinkedList<Integer> list[];
    int vertices;
    Graph(int nodes)
    {
        vertices=nodes+1;
        list=new LinkedList[vertices];
        for(int i=1;i<vertices;i++)
        {
            list[i]=new LinkedList();
        }
    }
   public void  add(int node1,int node2 )
   {
       list[node1].add(node2);
       list[node2].add(node1);
   }
   public void sort(){
    for(int i=1;i<vertices;i++)
    {
        Collections.sort(list[i]);
    }
   }
   public void print(int from,int to,int TimeR,int CTime){
    sort(); 
    LinkedList<Integer> Q=new LinkedList();
    LinkedList<Integer> R=new LinkedList();
    int parent[]=new int[vertices]; 
    boolean visited[]=new boolean[vertices];

    Q.add(from);
    visited[from]=true;
    parent[from]=from;
    boolean flag=true;
    while(Q.size()!=0 && flag==true)
    {
        int vert=Q.poll();

        
        int i=0;
        while(i<list[vert].size())
        {
            int ele=list[vert].get(i);
            if(!visited[ele])
            {
            
            Q.add(ele);

            visited[ele]=true;
            parent[ele]=vert;
                if(ele==to)
                {
                    flag=false;
                    break;
                }
            }
            i++;
        }    
    }
  
  
   
    Stack<Integer> p = new Stack<Integer>();
    p.push(to);
    int cur = to;
    while(cur!=from){
        cur= parent[cur];
        p.push(cur);
    }
    System.out.println(p.size());
    while(!p.empty()){
        System.out.print(p.pop()+" ");
    }

   
   } 
}
class HETheFlightPlan{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int N,M,T,C;
        N=sc.nextInt();
        M=sc.nextInt();
        T=sc.nextInt();
        C=sc.nextInt();
        Graph graph=new Graph(N);
        for(int i=0;i<M;i++)
        {
         int node1=sc.nextInt();
         int node2=sc.nextInt();
         graph.add(node1, node2);   
        }
        int X,Y;
        X=sc.nextInt();
        Y=sc.nextInt();

        graph.print(X, Y, T, C);

    }

}