import java.util.*;

public class Chocola {

    public static int chocola(Integer hor[],Integer ver[]){
        Arrays.sort(hor,Collections.reverseOrder());
        Arrays.sort(ver,Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;
        while(h<hor.length && v<ver.length){
            if(hor[h]>=ver[v]){
                cost+=(hor[h]*vp);
                hp++;
                h++;
            }
            else{
                cost+=(ver[v]*hp);
                vp++;
                v++;
            }
        }

        while(h<hor.length){
            cost+=(hor[h]*vp);
            hp++;
            h++;
        }
        while(v<ver.length){
            cost+=(ver[v]*hp);
            vp++;
            v++;
        }
        return cost;
    }
    public static void main(String args[]){
        Integer hor[]={2,1,4};
        Integer ver[]={4,1};
        System.out.println(Chocola.chocola(hor,ver));
    }
}
