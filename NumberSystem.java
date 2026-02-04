import java.util.*;

public class NumberSystem{

    public static ArrayList<Integer> binary(int n){
        ArrayList<Integer>ans=new ArrayList<>();
        if(n==0){
            ans.add(0);
            return ans;
        }
        while(n>0){
            
            int remainder=n%2;
            ans.add(remainder);
            n=n/2;
        }
        Collections.reverse(ans);
        return ans;
    }

    public static ArrayList<Integer> octal(int n){
        ArrayList<Integer>ans=new ArrayList<>();
        if(n==0){
            ans.add(0);
            return ans;
        }
        while(n>0){
            
            int remainder=n%8;
            ans.add(remainder);
            n=n/8;
        }
        Collections.reverse(ans);
        return ans;
    }

    public static StringBuilder hexadecimal(int n){
        StringBuilder ans=new StringBuilder();
        HashMap<Integer,Character>map=new HashMap<>();
                map.put(10,'A');
                map.put(11,'B');
                map.put(12,'C');
                map.put(13,'D');
                map.put(14,'E');
                map.put(15,'F');
        if(n==0){
            ans.append(0);
            return ans;
        }
        while(n>0){
            
            int remainder=n%16;
            if(remainder>=10){
                Character rem2=map.getOrDefault(remainder,'0');
                ans.append(rem2);


            }
            else{
                ans.append(remainder);
            }
            n=n/16;
        }

        
        ans.reverse();
        return ans;
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        int x,n;

        while(true){
            System.out.println("Enter a number:");
            n=sc.nextInt();
            System.out.println("Enter your choice:");
            System.out.println("1.Binary");
            System.out.println("2.Octal");
            System.out.println("3.Hexadecimal");
            x=sc.nextInt();
            switch(x){
                case 1:
                    System.out.println(binary(n));
                    break;
                
                case 2:
                    System.out.println(octal(n));
                    break;

                case 3:
                    System.out.println(hexadecimal(n));
                    break;

            }
  
        }
        


    }
}
