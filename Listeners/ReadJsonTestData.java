package Listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.jayway.jsonpath.JsonPath;

public class ReadJsonTestData {
	
	private static List<File> files = new ArrayList<File>();

	public synchronized static JSONObject getTestData(String idName,String env) {
		JSONObject obj = null;
		String filePath = System.getProperty("user.dir") + "/src/test/resources" + File.separator + "TestData";
		System.out.println("filePath is "+filePath);
		String parentName = "TenderWizard";
		try {
			String resWithEnv = "$.." + parentName + "." + env + "[?(@.ID =~ /.*" + idName + "/i)]";
			obj = getJSONObject(filePath, resWithEnv);
			System.out.println("obj is "+obj);
			if (obj == null) {
				String resWithoutEnv = "$.." + parentName + "..[?(@.ID =~ /.*" + idName + "/i)]";
				obj = getJSONObject(filePath, resWithoutEnv);
			}
		} catch (NullPointerException nullExc) {
			Assert.fail("Input does not match with json file. 'ParentName " + parentName + ", ENV " + env + ", ID "
					+ idName + "'" + nullExc.getMessage());
		} catch (Exception e) {
			if (obj == null) {
				String resWithoutEnv = "$.." + parentName + "[?(@.ID =~ /.*" + idName + "/i)]";
				obj = getJSONObject(filePath, resWithoutEnv);
			}
		}
		return obj;
	}
	
	public static JSONObject getJSONObject(String filePath, String res) {
		
		List<File> list = getAllFiles(filePath);
		JSONObject obj = null;
		try {
			for(File jsonFile : list) {
				if(jsonFile.isFile() && jsonFile.getName().contains(".json")) {
					Object jsonObject = JsonPath.read(jsonFile, res);
					//System.out.println("jsonObject is "+ jsonObject);
					JSONArray jsonArray = new JSONArray(jsonObject.toString());
					//System.out.println("jsonArray is "+ jsonArray);
					if(jsonArray.length()!=0) {
						obj = (JSONObject) jsonArray.get(0);
						break;
					}
				}
			}
			return obj;
		} catch (Exception e) {
			
		}
		return obj;		
	}

	private static List<File> getAllFiles(String directoryName) {
		System.out.println("directoryName is "+ directoryName);
		File directory = new File(directoryName);
		File[] farray = directory.listFiles();
		for(File file : farray) {
			if(file.isFile()) {
				files.add(file);
			} else if (file.isDirectory()) {
			getAllFiles(file.getAbsolutePath());
			}
		}
		return files;
	}

}
