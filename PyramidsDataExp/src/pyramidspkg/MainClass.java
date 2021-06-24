package pyramidspkg;

import java.io.IOException;

public class MainClass
{
	public static void main(String[] args) 
	{
		String path = "pyramids.csv";

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				try
				{
				PyramidDao nPyramidsDao = new PyramidDaoImp(); //--- create an instance
				nPyramidsDao.readAllPyramidsfromCSV(path); 	//--- Read Data
				nPyramidsDao.sortPyramids_by_Height(true); //--- Sort by height(descending=true)
				
				System.out.println("________ Sorted Pyramids Data by Height ________");
				int i = 0;
				for(Pyramid pr:nPyramidsDao.getPyramids())
				{
					System.out.println("#"+(i++)+pr); 
				}
				
				System.out.println("________ Number of Pyramids in each Site ________");
				System.out.println(nPyramidsDao.getSites_Dict());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
			


 
	}
}
