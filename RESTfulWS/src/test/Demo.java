package test;

import org.apache.log4j.Logger;

public class Demo {

	
	 private static final Logger LOGGER = Logger.getLogger(Demo.class);
	    public static void main(String[] args) throws Exception {
	        for (int i = 0; i < 10; i++) {
	            LOGGER.error("Info log [" + i + "].");
	            Thread.sleep(500);
	        }
	    }
}
