package pyramidspkg;
 
import java.io.IOException;
import java.util.List;
import java.util.Map;
public interface PyramidDao
{
	public List<Pyramid> readAllPyramidsfromCSV(String filepath)throws IOException;
	public List<Pyramid> sortPyramids_by_Height(boolean descending);
	public List<Pyramid> getPyramids();
	public Map<String, Integer> getSites_Dict();
}
