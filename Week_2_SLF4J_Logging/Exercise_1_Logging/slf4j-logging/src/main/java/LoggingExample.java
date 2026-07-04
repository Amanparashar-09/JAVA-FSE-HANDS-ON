import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("Application started");
        logger.debug("Debug level message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        String user = "Aman";
        int userId = 101;
        logger.info("User {} with ID {} logged in", user, userId);

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Exception occurred: {}", e.getMessage(), e);
        }

        logger.info("Application finished");
    }
}
