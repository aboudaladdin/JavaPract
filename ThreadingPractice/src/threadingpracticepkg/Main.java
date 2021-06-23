package threadingpracticepkg;



public class Main
{
	public static void main(String[] args)
	{
		 TestRunnable myRunObject = new TestRunnable("Runnable1");
		 TestThread myThreadObj = new TestThread("Thread1");
		 Thread th1 = new Thread(myRunObject);
		 th1.start();
		 myThreadObj.start();
		 new Thread(new TestRunnable("On_the_Fly")).start();

	}
	
	
	 
	
//	class A
//	{
//		protected A()
//		{
//			System.out.println("A constructor");
//		}
//		
//	}
//	public class Beta extends A
//	{
//		public Beta()
//		{
//			System.out.println("Beta constructor");
//		}
//	}
}
