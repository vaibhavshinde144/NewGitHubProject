package org.utils.qa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	public static Logger Logger = LogManager.getLogger(Log.class);
	
	public static void info(String message) {
		Logger.info(message);
	}
	
	public static void error(String message) {
		Logger.error(message);
	}
	
	public static void debug(String message) {
		Logger.debug(message);
	}

	public static void warn(String message) {
		Logger.warn(message);
	}
	
	public static void paymentFailure(String message) {
		System.out.println("Payment gateway is failing");
		Logger.error(message);
	}
}


