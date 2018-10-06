import java.util.*;
class Operations{
    int numarr[];
    int size;
    HashMap<Long, Integer> visitor = new HashMap<>(); 
    int sortedArray[];
    long Sortedlong;
    
    Operations(int size){
        this.size=size;
        numarr=new int[size]; 
       sortedArray=new int[size];
    }
    public void add(int index,int value){
        numarr[index]=value;
        sortedArray[index]=value;
    }
    public long getLong(int arr[]){
    
        Long num=(long)0;
       for(int i=0;i<arr.length;i++)
       {
        num=num*10+arr[i];
       }
       
        return num;
    }

    public  void getSorted(){
        Arrays.sort(sortedArray); 
        Arrays.sort(sortedArray); 
        Sortedlong=getLong(sortedArray);

    }
    public long reverse(int arr1[],int start,int end)
    {
     
      if(end==1){
        int temp= arr1[0];
        arr1[0]=arr1[1];
        arr1[1]=temp;
        return getLong(arr1);
      }
      int end1=end;
        for(int i=0;i<=(end+1)/2;i++)
        {
         
           int temp= arr1[i];
           arr1[i]=arr1[end];
           arr1[end]=temp;
           end--;
        }
        return getLong(arr1);
    }

    public int print(){
        getSorted();
        LinkedList<int[]> Q=new LinkedList();
        Long first=getLong(numarr);
        Q.add(numarr);
        
        while(!Q.isEmpty()){
           int arr[]=new int[size];
             arr=Arrays.copyOf(Q.poll(),size);
           long num=getLong(arr);
           if(!visitor.containsKey(num)){
                visitor.put(num, 0);
           }
           
           if(num==Sortedlong){
               return visitor.get(Sortedlong);
           }

           for(int i=1;i<size;i++)
           { int local[]=new int[size];
            local=Arrays.copyOf(arr,size);
            //System.out.println(getLong(arr)+"arr"+i+"visitor "+getLong(local));
              long newlongArray= reverse(local,0,i);
            //System.out.println(getLong(arr)+"arr"+i+"visitor "+getLong(local));
              System.out.println("visitor "+visitor.toString());
              if(!visitor.containsKey(newlongArray)){
                  visitor.put(newlongArray, visitor.get(num)+1);
                  Q.add(local);
                    if(newlongArray==Sortedlong){
                        return visitor.get(Sortedlong);
                    }
                }  
                local=null;
           }
         
           
        }
        return visitor.get(Sortedlong);
    }

}
class HEPermutation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        Operations ops=new Operations(size);
        for(int i=0;i<size;i++){
            int value=sc.nextInt();
            ops.add(i, value);
        }
       System.out.println(ops.print());
        
    }
}