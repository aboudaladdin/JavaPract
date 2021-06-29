package countriesdata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class WorldCountriesDaoImp implements WorldCountriesDao
{
	private List<Country> allCountries;
	private List<City> allCities;
	private Map<String,List<City>> cityCode_listCities;
	
	private boolean dataLoaded;
	private boolean citiesMapped;
	private boolean dataSorted;
	public WorldCountriesDaoImp()
	{
		allCountries = new ArrayList<Country>();
		allCities = new ArrayList<City>();
		cityCode_listCities = new HashMap<String, List<City>>();
		dataLoaded = false;
		dataSorted = false;
		citiesMapped = false;
	}
	
	//-----------------------------------
	//--------------- Map Cities by Country Code ( Code | Cities for code)	
	@Override
	public void readAllCountries_cities_csv(String filepath_Country, String filepath_City) throws IOException
	{
		allCountries = Files.lines(Paths.get(filepath_Country))
				.map(Country::new)
				.collect(Collectors.toList());
		
		allCities = Files.lines(Paths.get(filepath_City))
				.map(City::new)
				.collect(Collectors.toList());
		

		dataLoaded = true;
		getCities_by_CCode();
	}
	
	//-----------------------------------
	//--------------- Map Cities by Country Code ( Code | Cities for code)	
	@Override
	public Map<String, List<City>> getCities_by_CCode()
	{
		if(dataLoaded)
		{
			if(!citiesMapped)
			{
				//---- create the (CityCode | CitiesList) hashmap
				for(City c : allCities)
				{
					String key = c.getCityCode();
					if(cityCode_listCities.containsKey(key))
					{
						cityCode_listCities.get(key).add(c);
					}
					else
					{
						List<City> tmplst = new ArrayList<City>(); 
						tmplst.add(c);
						cityCode_listCities.put(key,tmplst);
					}
				}
				citiesMapped = true;
			}
			return cityCode_listCities;
		}
		return null;
	}
	
	//-----------------------------------
	//--------------- Get Sorted Cities by Country Code
	@Override
	public Map<String, List<City>> getSortedCities_by_CCode()
	{
		if(!citiesMapped)
		{
			getCities_by_CCode(); //--- Guarantee its built.
		}
		cityCode_listCities.forEach((K,V) -> 
		{
			V =  V.stream().sorted(Comparator.comparing(City::getPopulation).reversed()).collect(Collectors.toList());
			cityCode_listCities.replace(K, V);
		});
		
		dataSorted = true;
		return cityCode_listCities;
	}
	

	//-----------------------------------
	//--------------- Get Avg Population per country 
	@Override
	public double getAvgCountriesPopulation()
	{
		OptionalDouble avg = allCountries.stream()
				 		.mapToLong(Country::getPopulation).average() ;
		return avg.orElse(-1);
	}
	
	//-----------------------------------
	//--------------- Get Max Country Population - Name
	@Override
	public Country getMaxCountryPopulation_andName()
	{
		return allCountries.stream()
				.max(Comparator.comparingLong(Country::getPopulation))
				.orElseThrow(NoSuchElementException::new);
	}
	
	//-----------------------------------
	//--------------- Get Highest Population City in each country
	@Override
	public List<City> getHighestPopulationCityforeachCountry()
	{
		if(!dataSorted)
		{
			getSortedCities_by_CCode();
		}
		getSortedCities_by_CCode();
		List<City> highestCityinCountry = new ArrayList<City>();
		cityCode_listCities.forEach((K,V)->highestCityinCountry.add(V.get(0)));

		return highestCityinCountry;
	}
	
	//-----------------------------------
	//--------------- Get Highest Population Capital
	@Override
	public City getHighestPopulationCapital()
	{
		Optional<City>	mCity = allCities.stream().filter(city -> allCountries.stream()
					.map(Country::getCapital)
					.anyMatch(c_capital -> c_capital == city.getId() ))
					.max(Comparator.comparing(City::getPopulation));

		return mCity.orElseThrow(NoSuchElementException::new);
	}
	
	//-----------------------------------
	//--------------- Getters and Setters
	public List<Country> getAllCountries()
	{
		return allCountries;
	}
	public List<City> getAllCities()
	{
		return allCities;
	}
	public void setAllCountries(List<Country> allCountries)
	{
		this.allCountries = allCountries;
	}
	public void setAllCities(List<City> allCities)
	{
		this.allCities = allCities;
	}

 
}
