import java.util.ArrayList;
import java.util.List;

public class RoundRobin 
{
	
	private List<Process>Que=new ArrayList<Process>();
	private List<Process>inQue=new ArrayList<Process>();
        public  static List<String[]>record=new ArrayList<String[]>();
	private int time=0;
	private int timeSlot=0;
	private int timeQuantum;
	private int prid=0;
        private int count=0;
	
	public RoundRobin(int timeQuantum,List<Process>inQue)
	{
		this.timeQuantum=timeQuantum;
		this.inQue=inQue;
	}
        public void RunShedular() throws InterruptedException
        {
            while(true)
            {
                if(Que.isEmpty()&&inQue.size()==count)break;
                else if(inQue.size()!=count)
                {
                    for(final Process pr:inQue)
                    {
                        if(pr.getArrival()==time)
                        {
                            Que.add(pr);
                            count++;
                            System.out.println("time = "+time+" "+pr.getName()+" arrived");
                            String[]rec=new String[5];
                            rec[0]=time+"";  
                            rec[1]=pr.getName();
                            rec[2]="arrival";
                            rec[3]=pr.getRuntime()+"";
                            rec[4]=(pr.getBurst()-pr.getRuntime())+"";
                            record.add(rec);
			}
                    }
                }
                if(!Que.isEmpty())
                {
                    boolean end=Que.get(prid).unitRun();
                    System.out.println("time = "+(time+1)+" "+
                    Que.get(prid).getName()+" running for "+
                    Que.get(prid).getRuntime()+" remain "+
                    (Que.get(prid).getBurst()-Que.get(prid).getRuntime()));
                    String[]rec=new String[5];
                    rec[0]=(time+1)+"";  
                    rec[1]=Que.get(prid).getName();     
                    rec[2]="run";
                    rec[3]=Que.get(prid).getRuntime()+"";
                    rec[4]=(Que.get(prid).getBurst()-Que.get(prid).getRuntime())+"";
                    record.add(rec);
                    time++;
                    if(end)
                    {
                        System.out.println("time = "+(time)+" "+Que.get(prid).getName()+" finished");
                        String[]rec2=new String[5];
                        rec2[0]=time+"";  
                        rec2[1]=Que.get(prid).getName();
                        rec2[2]="finish";
                        rec2[3]=Que.get(prid).getRuntime()+"";
                        rec2[4]=(Que.get(prid).getBurst()-Que.get(prid).getRuntime())+"";
                        record.add(rec2);
                        Que.remove(prid);
                        timeSlot=0;
                    }        
                    else
                    {     
                        timeSlot++;
                        if(timeSlot==timeQuantum)
                        {
                            System.out.println("pass");
                            prid++;
                            timeSlot=0;
                        }
                    }
                    if(prid==Que.size())prid=0;
                }
                else if(Que.isEmpty() && inQue.size()!=count)time++;
            }
        }
}




