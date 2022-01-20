package com.crm.comcast.sdet28GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Kavya
 *
 */
public class FileUtility {
	
	/**This method is used to fetch the data from the property file
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String getPropertyFileData(String key) throws Throwable{
	FileInputStream file = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
	Properties property = new Properties();
	property.load(file);
	return property.getProperty(key);
	
}
}