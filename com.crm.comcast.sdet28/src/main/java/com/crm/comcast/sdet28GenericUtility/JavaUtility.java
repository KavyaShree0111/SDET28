package com.crm.comcast.sdet28GenericUtility;


import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Kavya
 *
 */

	public class JavaUtility {
		
		/**This method will return the random number
		 * 
		 * @return
		 */
		
		public int getRandomNumber() {
			Random ran=new Random();
	        int randomNumber=ran.nextInt(5000);
		    return randomNumber;
		    
		}
		
		/**
		 * This method will return the system date and time
		 * @return
		 */
			
		public String systemDateAndTime() {
			Date date = new Date();
			String dateAndTime=date.toString();
			return dateAndTime;
		}


}
