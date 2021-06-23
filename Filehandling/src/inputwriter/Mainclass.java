package inputwriter;

public class Mainclass
{
	public static void main(String[] args)
	{
		StreamToFile streamFileWriter = new StreamToFile("D:\\data.txt");
		streamFileWriter.StreamWFile(true);
	}
}
