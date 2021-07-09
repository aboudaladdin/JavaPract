import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

public class MainClass
{

	public static void main(String[] args) throws IOException
	{
        YoutubeDao.Initialize("src/main/resources/USvideos.csv");
        
        //-- to exclude (and , or , are , the ... and all common used words..
        //-- we can set the  minimum  word length to get more meaningful results.
        List<Entry<String,Long>> sortedTags = YoutubeDao.getYoutubeTrendingTags(4); 
        List<Entry<String,Long>> sortedWords = YoutubeDao.getYoutubeTrendingTitles(4); 
        
        System.out.println("________ Top 30 Video Title by Word Count ________");
        for(int i = sortedWords.size(); i > sortedWords.size()-30;i--)
        {
        	System.out.println ("#" + (sortedWords.size()-i+1) + " - " + sortedWords.get(i-1).getKey () + " : " + sortedWords.get(i-1).getValue ());
        }
 
		System.out.println("________ Top 30 Frequent Video Tags ________");
        for(int i = sortedTags.size(); i > sortedTags.size()-30;i--)
        {
        	System.out.println ("#" + (sortedTags.size()-i+1) + " - " + sortedTags.get(i-1).getKey () + " : " + sortedTags.get(i-1).getValue ());
        }
 

	}

}
