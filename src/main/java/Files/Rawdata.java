package Files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Rawdata
{
	public static XmlPath rawDataXML(Response res)
	{
		String r =res.asString();
		XmlPath x = new XmlPath(r);
		return x;
		
	}
	
	
	public static JsonPath rawDatajson(Response res)
	{
		String r =res.asString();
		JsonPath x = new JsonPath(r);
		return x;
		
	}

}
