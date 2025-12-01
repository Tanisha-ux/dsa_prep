import java.util.*;

public class JobSequencing{

    static class Job{
        int idx;
        int deadline;
        int profit;

        public Job(int i,int d,int p){
            this.idx=i;
            this.deadline=d;
            this.profit=p;
            
        }
    }

        public static void JobSeq(int jobInfo[][]){
            ArrayList<Job> ans=new ArrayList<>();

            for(int i=0;i<jobInfo.length;i++){
                ans.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));
            }

            Collections.sort(ans,(obj1,obj2)->obj2.profit-obj1.profit);
            int time=0;
            ArrayList<Integer> seq=new ArrayList<>();
            for(int i=0;i<ans.size();i++){
                Job curr=ans.get(i);
                if(curr.deadline>time){
                    seq.add(curr.idx);
                    time++;
                }
            }

            System.out.println(seq.size());
            for(int i=0;i<seq.size();i++){
                System.out.print(seq.get(i)+" ");
            }
            
        }
    
    public static void main(String args[]){
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        
        JobSeq(jobInfo);
    }
}