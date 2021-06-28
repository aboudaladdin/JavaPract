package countriesdata;
 
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface WorldCountriesDao
{
	public void readAllCountries_cities_csv(String filepath_Country,String filepath_City)throws IOException;
	
	public List<Country> getAllCountries();
	public List<City> getAllCities();
	
	public Map<String, List<City>> getCities_by_CCode();
	public Map<String, List<City>> getSortedCities_by_CCode();
 
	public double getAvgCountriesPopulation();
	public Country getMaxCountryPopulation_andName();
	public List<City> getHighestPopulationCityforeachCountry();
	public City getHighestPopulationCapital();
	
}
