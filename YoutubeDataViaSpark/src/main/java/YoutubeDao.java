import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
 
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class YoutubeDao 
{
	static SparkConf conf;
	static JavaSparkContext sparkContext;
	static JavaRDD<String> videos;
    private static final String COMMA_DELIMITER = ",";

	public static void Initialize(String filepath)
	{
		conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
		sparkContext = new JavaSparkContext (conf);
		videos = sparkContext.textFile(filepath);
	}
	
	public static List<Map.Entry<String,Long>> getYoutubeTrendingTitles(int minimum_title_length) throws IOException
	{
		JavaRDD<String> Title_cells = videos
				.map (s ->  extractTitle(s))
				.filter (StringUtils::isNotBlank);
		
		JavaRDD<String> words = Title_cells
				.flatMap (s ->  Arrays.asList (s
				.toLowerCase ()
				.trim ()
				.replaceAll ("\\p{Punct}", "")
				.split (" ")).iterator());
		
		JavaRDD<String> filtered_words = words.filter(s -> s.length() >= minimum_title_length);
		//COUNTING
		Map<String, Long> wordCounts = filtered_words.countByValue ();
		List<Map.Entry<String,Long>> sortedWords = wordCounts.entrySet().stream ()
		.sorted(Map.Entry.comparingByValue()).collect (Collectors.toList ());
		
		return sortedWords;		
	}
	public static List<Map.Entry<String,Long>> getYoutubeTrendingTags(int minimum_tag_length) throws IOException
	{
		JavaRDD<String> tag_cells = videos
				.map (s ->  extractTag(s))
				.filter (StringUtils::isNotBlank);
		
		JavaRDD<String> tags = tag_cells.flatMap (s ->  Arrays.asList (s
				.toLowerCase ()
				.trim ()
				.split ("\\|")).iterator ());
		
		JavaRDD<String> filtered_tags = tags.filter(s -> s.length() >= minimum_tag_length);
		//COUNTING
		Map<String, Long> tagCounts = filtered_tags.countByValue ();
		List<Map.Entry<String,Long>> sortedTags = tagCounts.entrySet ().stream ()
		.sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
		
		return sortedTags;		
	}
    private static String extractTitle(String videoLine) 
    {
        try 
        {
            return videoLine.split(COMMA_DELIMITER)[2];
        } 
        catch (ArrayIndexOutOfBoundsException e) 
        {
            return "";
        }
    }
	private static String extractTag(String videoLine) 
	{
		try 
	 	{
            return videoLine.split(COMMA_DELIMITER)[6];
        } 
	 	catch (ArrayIndexOutOfBoundsException e) 
		{
            return "";
        }
	}
 
}
