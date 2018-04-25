package alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
	
	//this creates a log object to use in code below
	//initializes it with the name of the class, gotten by using Demo.class.getName() because cannot just pass the name in
	private static Logger log = LogManager.getLogger(Demo.class.getName());

	public static void main(String[] args) {

		log.debug("This is a debug message");
		log.info("This is an info message");
		log.error("This is a error message");
		log.fatal("This is a fatal message");
	}

}