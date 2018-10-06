import java.util.Scanner;

class substring{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0)
        {
        String str=sc.next();
        String ans="No";
        for(int window=2;window<str.length();window++)
        {
            int i=0;
            if(ans.equals("yes")){break;}
            while(window+i<=str.length())
            {
               // System.out.println(str.subSequence(i,window+i)+" start "+i+" end "+window+i );
               String substring= str.subSequence(i,window+i).toString();
               int shouldbreak=0;
              
               int a=0;
               int e=0;
               int ii=0;
               int o=0;
               int u=0;

               for(int j=0;j<substring.length();j++){
                   switch(substring.charAt(j)){

                    case 'a':
                            a++;
                            break;
                    case 'e':
                            e++;
                            break;
                    case 'i':   ii++;
                                break;
                    case 'o': o++;
                                break;
                    case 'u': u++;
                                break;
                    default :shouldbreak=1; 

                   }
                   if(shouldbreak==1)
                   {
                       break;
                   }

                   }
                   if(a==substring.length()||e==substring.length()||ii==substring.length()||o==substring.length()||u==substring.length())
                   {
                       continue;
                   }
                   else{
                    ans="Yes";
                    break;
                   }
                   
               }
               
               
               
               
               i++;
            }
            System.out.println(ans);
        }    
    }
    }
