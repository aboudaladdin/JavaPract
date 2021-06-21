package ipcutterpkg;

public class Main
{
	
	public static void main(String[] args)
	{
		 
		// TODO Auto-generated method stub
		IpCutter myCutter = new IpCutter("192.168.1.5");
		for(int ss : myCutter.getIp_Parts())
		{
			System.out.println(ss);
		}
	}
	
	
}
