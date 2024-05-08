package main;

import org.apache.logging.log4j.LogManager;

public class LoggerAdapter implements Logger{
    private org.apache.logging.log4j.Logger logger;

    public LoggerAdapter(org.apache.logging.log4j.Logger logger) {
        super();
        this.logger = logger;
    }

    public void log(LogLevel logLevel, String message) {
        switch (logLevel) {
            case ERROR:
                logger.error(message);
                break;
            case FATAL:
                logger.fatal(message);
                break;
            case INFO:
                logger.info(message);
                break;
            case TRACE:
                logger.trace(message);
                break;
            case WARNING:
                logger.warn(message);
                break;
            case DEBUG:
            default:
                logger.debug(message);
                break;
        }
    }
//
}
