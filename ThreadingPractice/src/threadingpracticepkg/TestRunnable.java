package threadingpracticepkg;

public class TestRunnable implements Runnable
{
	private String mName;
	public TestRunnable(String mName)
	{
		this.mName = mName;
	}
	@Override
	public void run()
	{
		for(int i =1;i < 101; i++)
		{
			System.out.println(i + " ,Obj. Name : " + mName);
			try
			{
				
				Thread.sleep((int)Math.random() * 1000);
			}
			catch  (InterruptedException | IllegalMonitorStateException  e)
			{
				e.printStackTrace();
			}
			
		}

	}

}
