package Listeners;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JasonReader {
	
	
	
	public static ArrayList<String> jasonReader(String flow)
	{
		ArrayList<String> a1=new ArrayList<String>();
	try{
		JSONParser jsonParser=new 	JSONParser();
		FileReader reader=new FileReader(".\\Excel\\testdata.json");
	//	getJSONObject(".\\Excel\\testdata.json","juk");
		Object obj = jsonParser.parse(reader);
		JSONObject flowOBJ=(JSONObject)obj;
		Object obj1 = flowOBJ.get(flow);
		JSONObject tender=(JSONObject)obj1;
		tender.size();
a1.add( (String)tender.get("Username"));
		a1.add((String)tender.get("Password"));
		a1.add((String)tender.get("Flow"));
		a1.add( (String)tender.get("URLs"));
		a1.add( (String)tender.get("Centralised"));
		a1.add((String)tender.get("Template"));
		a1.add((String)tender.get("TechnoCommercialOpen"));
		a1.add((String)tender.get("CostOpen"));
		a1.add( (String)tender.get("altTechnoCommercialOpen"));
		a1.add( (String)tender.get("altCostOpen"));
		a1.add((String)tender.get("Vend1"));
		a1.add((String)tender.get("Vend2"));
		a1.add((String)tender.get("COT"));
		a1.add( (String)tender.get("Dept"));
		a1.add((String)tender.get("ZeroPayment"));
		a1.add((String)tender.get("Open"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Throwable ght = e.getCause();
			System.out.println(ght);
		}
	return a1;
	}
	
}
