import java.util.Scanner;

class HENumber{
    static long comb(long n , long r)
	{
		if( r== 0 || n == r)
			return 1;
		else
			return comb(n-1,r)+comb(n-1,r-1);
	}

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int zeros=0;
        long arr[]=new long[num];
        for(long i=0;i<num;i++){
            int number=sc.nextInt();
            arr[i]=number;
            if(number==0){
                zeros++;
            }
        }
       int k=sc.nextInt();
       long total=0;
       if(num==zeros){
        System.out.println(0);
        return;
       }

      for(long i=0;i<=num-k;i++){
        if(arr[i]==0){
            continue;
        }
       if(num-1-i>=k-1){
        long val=comb(num-1-i,k-1);
        total=(total+val)%720720;
       }
       else{
           break;
       }
       
      }
      System.out.prlongln(total);
    }
}