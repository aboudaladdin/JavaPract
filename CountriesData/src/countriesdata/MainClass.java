package countriesdata;

import java.io.IOException;
 

public class MainClass
{	
 
	public static void main(String[] args) throws IOException
	{
		var countriesPath = System.getProperty("user.dir") + "/Countries.csv";
		var citiesPath = System.getProperty("user.dir") + "/cities.csv";
		
		WorldCountriesDao worldDao = new WorldCountriesDaoImp();
		worldDao.readAllCountries_cities_csv(countriesPath, citiesPath);
 
		System.out.println();
		System.out.println("________ Cities Sorted by Population ________");
		worldDao.getSortedCities_by_CCode().forEach((K,V)->
		{
			System.out.println(K);
			V.forEach(CC -> System.out.println("---"+ CC.getName() + "---" + CC.getPopulation()));
			System.out.println("_________________________________________");
		});
		
		System.out.println();
		System.out.println("________ Highest City Population Per Country ________");
		worldDao.getHighestPopulationCityforeachCountry().forEach(C-> {
			System.out.println(C.getCityCode());
			System.out.println("---"+ C.getName() + "---" + C.getPopulation());
			System.out.println("_________________________________________");
		});
		
		System.out.println();
		System.out.println("________ Average Population of the World ________");
		System.out.println(worldDao.getAvgCountriesPopulation());
		
		System.out.println(); 
		System.out.println("________ Maximum Population in the World ________");
		Country c = worldDao.getMaxCountryPopulation_andName();
		System.out.println("Country Name : " + c.getCountryName() + " ,	Population :  " + c.getPopulation());
		
		System.out.println();
		System.out.println("________ Highest Population Capital ________");
		System.out.println(worldDao.getHighestPopulationCapital());
		System.out.println("_________________________________________");

	}

}
