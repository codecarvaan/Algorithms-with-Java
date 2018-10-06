import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.LinkedHashSet;

class Problem{
    LinkedList<Integer> list = new LinkedList();
    boolean flagkey[]=new boolean[100002];
    int turn[]=new int[100002];
    int times=0;
    int SamKey=0;
    int LockKey=0;
    
    Problem(int SamKey,int LockKey){
        this.SamKey=SamKey;
        this.LockKey=LockKey;
        for(int i=0;i<turn.length;i++)
        {
            turn[i]=-1;
        }
    }

    public void addkey(int key){
            if(flagkey[key]!=true){
                list.add(key);
                flagkey[key]=true;
                turn[key]=0;
            }
            
        }
    
   public void print(){
       LinkedList<Integer> Q=new LinkedList();
       Q.add(SamKey);
       int count=0;
       while(!Q.isEmpty()){
           int key=Q.poll();
          
           if(flagkey[LockKey]==true)
           {
               break;
           }
           else{
               for(int i=0;i<list.size();i++)
               {   long n=1;
                   long v=(n*key*list.get(i))% 100000;
                   int val=(int)(v % 100000);
                  
                   if(flagkey[val]!=true)
                   {
                    flagkey[val]=true;
                    Q.add(val);
                    turn[val]=turn[key]+1;
                   }
                   if(flagkey[LockKey]==true){
                       break;
                   }
                   
               }
           }
           count++;
       }
       if(flagkey[LockKey]==true)
       {
        System.out.println(turn[LockKey]);
       }
       else{
        System.out.println(-1);
       }
       
   } 
}
class HEDhoom4{
    
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        int SamKey=sc.nextInt();
        int LockKey=sc.nextInt();
        int numKeys=sc.nextInt();
        Problem pr=new Problem(SamKey,LockKey);
       
        
        for(int i=0;i<numKeys;i++)
        {
             pr.addkey(sc.nextInt());
        }
        
        pr.print();

    }
}