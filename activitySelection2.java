import java.util.*;

public class activitySelection2 {
    public static void main(String args[]){
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        int activities[][]=new int[end.length][3];

        //sorting
        for(int i=0;i<end.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];

        }

        Arrays.sort(activities,Comparator.comparingInt(o->o[2]));

        int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];
        for(int i=0;i<end.length;i++){
            if(activities[i][1]>lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd=end[i];
            }
        }

        System.out.println(maxAct);
    }
}
