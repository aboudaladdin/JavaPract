package countriesdata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class City
{
	private int id;
	private String name;
	private int population;
	private String cityCode;
	

	public City(String streamData)
	{
		Stream<String> stream = Arrays.stream(streamData.split( "," )) ;
		List<String> stream_strings = stream.collect(Collectors.toList());
		
		this.id = Integer.parseInt(stream_strings.get(0));
		this.name =stream_strings.get(1).trim();
		this.population = Integer.parseInt(stream_strings.get(2));
		this.cityCode =  stream_strings.get(3).trim();
	}
	
	public City(int id, String name, int population, String cityCode)
	{
		this.id = id;
		this.name = name;
		this.population = population;
		this.cityCode = cityCode;
	}

	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int getPopulation()
	{
		return population;
	}
 
	public String getCityCode()
	{
		return cityCode;
	}

	public void setCityCode(String cityCode)
	{
		this.cityCode = cityCode;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPopulation(int population)
	{
		this.population = population;
	}
 
	
	public String toString()
	{
		return "City : " + name + "	,Population : " + population 
				+ "	,Code: " + cityCode ;
	}
}
