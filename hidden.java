import java.util.Scanner;

class HEhidden{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            long sum=0;
            int num=sc.nextInt();
            for(int i=0;i<num;i++){
                sum+=(long)sc.nextInt();
            }
            if(sum%num==0){
                System.out.println(sum/num);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}