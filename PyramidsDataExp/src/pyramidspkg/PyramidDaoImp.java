package pyramidspkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidDaoImp implements PyramidDao
{
	private List<Pyramid> pyramids;
	private Map<String, Integer> sites_dict = new HashMap<>();
	
	public PyramidDaoImp()
	{
		pyramids = new ArrayList<Pyramid>();
	}
	//-------- read & create map
	@Override
	public List<Pyramid> readAllPyramidsfromCSV(String filepath) throws IOException
	{
 
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		//-- header
		br.readLine();
		
		String line = br.readLine();
		while(line!=null)
		{
			
			String columns[] = line.split(",");
			double height = (columns[7] == null || columns[7] == "") ? 0: Double.parseDouble(columns[7]);
			Pyramid temp = new Pyramid( columns[0], columns[2], columns[4], height);
			pyramids.add(temp);
			
			
			//---- create the (site | n_pyramids) hashmap
			String key = columns[4];
			if(sites_dict.containsKey(key))
			{
				sites_dict.put(key, sites_dict.get(key) + 1);
			}
			else
			{
				sites_dict.put(key,1);
			}
			
			line = br.readLine();
		}
		
		br.close();
		
		return pyramids;
	}
	
	//-------- sort by height 
	public List<Pyramid> sortPyramids_by_Height(boolean descending)
	{
		int s = (descending == true) ? -1 : 1; 
		
		pyramids.sort(new Comparator<Pyramid>()
		{
			public int compare(Pyramid a, Pyramid b)
		    {
		        return (int) (a.getHeight() - b.getHeight())*(s);
		    }
		});
		
		return pyramids;
	}
	
	public List<Pyramid> getPyramids()
	{
		return pyramids;
	}
	
	public HashMap<String, Integer> getSites_Dict()
	{
		return (HashMap<String, Integer>) sites_dict;
	}
 
	

}
