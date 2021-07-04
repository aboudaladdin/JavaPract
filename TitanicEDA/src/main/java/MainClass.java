import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClass
{

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{
		
		List<TitanicPassenger> allPassengers = getPassengersFromJsonFile();
		allPassengers.forEach(k -> System.out.println(k));
		XVisuals.graphPassengerAges(allPassengers);
		XVisuals.graphPassengerClass(allPassengers);
		XVisuals.graphPassengersurvived(allPassengers);
		XVisuals.graphPassengersurvivedGender(allPassengers);
	}
	
	public static List<TitanicPassenger> getPassengersFromJsonFile() throws JsonParseException, JsonMappingException, IOException 
	{
		List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger> ();
		ObjectMapper objectMapper = new ObjectMapper() ;
		objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,  false);
		InputStream input = new FileInputStream ("titanic.json");
		allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>> () { });
	 
		return allPassengers;
	}
}
