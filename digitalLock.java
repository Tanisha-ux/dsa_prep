import java.util.Scanner;

public class digitalLock{
    private static long evenDecode(long num){
        long sum=0;
        String s=Long.toString(num);
        for(int i=0;i<s.length();i++){
            if((i+1)%2==0){
                sum+=s.charAt(i)-'0';
            }
        }
        return sum;
    }

    private static long oddDecode(long num){
        long sum=0;
        String s=Long.toString(num);
        for(int i=0;i<s.length();i++){
            if((i+1)%2!=0){
                sum+=s.charAt(i)-'0';
            }
        }
        return sum;
    }


    public static long isArmStrong(long num){
        int sum=0;
        long temp=num;
        String s=Long.toString(num);
        int n=s.length();
        
        for(int i=0;i<s.length();i++){
            long digit=temp%10;
            sum+=Math.pow(digit,n);
            temp/=10;
        }

        if(sum==num){
            return evenDecode(num);
        }
        else{
            return oddDecode(num);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // if (isArmStrong(n)) {
        //     System.out.println(evenDecode(n));
        // } else {
        //     System.out.println(oddDecode(n));
        // }
        System.out.println(isArmStrong(n));
    }
}