exam com.exam.logger;

import org.apache.log4j.Logger;

public class CustomLogger {
	static Logger customLog = Logger.getLogger(CustomLogger.class);
	
	private CustomLogger(){
		
	}
	
	public static void debug(Object str){
		customLog.debug(str);
	}
	
	public static void info(Object str){
		customLog.info(str);
	}
	
	public static void error(Object str){
		customLog.error(str);
	}
	
	public static void fatal(Object str){
		customLog.fatal(str);
	}
}