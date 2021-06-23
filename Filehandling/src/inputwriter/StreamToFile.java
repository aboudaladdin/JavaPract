package inputwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamToFile
{
	private String outputFilePath;
	
	public StreamToFile(String outputFilePath)
	{
		this.outputFilePath = outputFilePath;
	}
	
	public String getOutputFilePath()
	{
		return outputFilePath;
	}
	public void setOutputFilePath(String outputFilePath)
	{
		this.outputFilePath = outputFilePath;
	}

	public void StreamWFile(boolean append)
	{
		InputStreamReader sReader = new InputStreamReader(System.in);
		BufferedReader bfR = new BufferedReader(sReader);
		String line = "";
		
		try
		{
			FileWriter fWriter = new FileWriter(outputFilePath,append);
			BufferedWriter bfWrite = new BufferedWriter(fWriter);
			
			while(!line.equalsIgnoreCase("stop"))
			{
				System.out.println("Enter Data : ");
				line = bfR.readLine();
				System.out.println("Data : " + line);
				bfWrite.write(line);
				bfWrite.newLine();
			}
			
			bfR.close();
			bfWrite.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}	
