package Files;

import io.restassured.specification.RequestSpecification;

public class Resources
{
	protected static String placeResourceDatajson()
	{
		
		String str ="maps/api/place/add/json";
		
		return str;
		
		
	}
	
	protected static String placeResourceDataxml()
	{
		
		String str ="maps/api/place/add/xml";
		
		return str;
		
		
	}

}
