package main;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab6Application {

	public static void main(String[] args) {
		Logger logger = new LoggerAdapter(LogManager.getLogger());

		logger.log(LogLevel.INFO, "Logger started");

		int x = 10;
		logger.log(LogLevel.DEBUG, "Value of x is " + x);

		logger.log(LogLevel.FATAL, "Program shutting down");

		logger.log(LogLevel.ERROR, "Value of x is not " + (-x));

		logger.log(LogLevel.WARNING, "Careful, this method is deprecated...");
	}
}
