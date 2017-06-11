import java.util.List;
import java.util.ArrayList;
public class Process
{
	public static List<Process>processes=new ArrayList<Process>();
	private int arrivalTime;
	private int burstTime;
	private String name;
	private int runTime=0;
	public Process(int arrival,int burst,String name)
	{
		this.arrivalTime=arrival;
		this.burstTime=burst;
		this.name=name;
		processes.add(this);
	}
	public int getArrival()
	{
		return arrivalTime;
	}
	public int getBurst()
	{
		return burstTime;
	}
	public String getName()
	{
		return name;
	}
	public int getRuntime()
	{
		return runTime;
	}
	public boolean unitRun()
	{
		runTime++;
		if(runTime==burstTime)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

