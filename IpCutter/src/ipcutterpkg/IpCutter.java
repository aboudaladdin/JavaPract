package ipcutterpkg;

public class IpCutter
{
	private String ip_txt;
	
	public IpCutter(String ip_txt)
	{
		this.ip_txt = ip_txt;
	}
	
	public String getIp_txt()
	{
		return ip_txt;
	}

	public void setIp_txt(String ip_txt)
	{
		this.ip_txt = ip_txt;
	}
	
	public Integer[] getIp_Parts()
	{
		String[] mySlist = getIp_txt().split("\\.");
		
		Integer[] ilist = new Integer[mySlist.length];
		for(int i = 0 ; i < mySlist.length ; i++)
		{
			ilist[i] = Integer.parseInt( mySlist[i]);
		}
		return  ilist ;
	}
	

	
}
