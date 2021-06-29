package countriesdata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Country  
{

	private String countryCode;
	private String countryName;
	private String continent;
	private double surfaceArea;
	private long population;
	private double gnp;
	private int capital;
	
	public Country(String streamData)
	{
		
		Stream<String> stream = Arrays.stream(streamData.split( "," )) ;
		List<String> stream_strings = stream.collect(Collectors.toList());
		
		this.countryCode = stream_strings.get(0).trim();
		this.countryName =stream_strings.get(1).trim();
		this.continent = stream_strings.get(2).trim();
		this.population = Integer.parseInt(stream_strings.get(3));
		this.surfaceArea = Double.parseDouble(stream_strings.get(4));
		this.gnp = Double.parseDouble(stream_strings.get(5));
		this.capital = Integer.parseInt(stream_strings.get(6));
	}
	public Country(String countryCode, String countryName, String continent, double surfaceArea, int population,
			double gnp, int capital)
	{
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.population = population;
		this.gnp = gnp;
		this.capital = capital;
	}

	public String getCountryCode()
	{
		return countryCode;
	}
	public String getCountryName()
	{
		return countryName;
	}
	public String getContinent()
	{
		return continent;
	}
	public double getSurfaceArea()
	{
		return surfaceArea;
	}
	public long getPopulation()
	{
		return population;
	}
	public double getGnp()
	{
		return gnp;
	}
	public int getCapital()
	{
		return capital;
	}
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	public void setContinent(String continent)
	{
		this.continent = continent;
	}
	public void setSurfaceArea(double surfaceArea)
	{
		this.surfaceArea = surfaceArea;
	}
	public void setPopulation(int population)
	{
		this.population = population;
	}
	public void setGnp(double gnp)
	{
		this.gnp = gnp;
	}
	public void setCapital(int capital)
	{
		this.capital = capital;
	}
	public String toString()
	{
		return "-	Country : " + countryName + "	,Capital: " + capital 
				+ "	,Code : " + countryCode;
	}
	
}
