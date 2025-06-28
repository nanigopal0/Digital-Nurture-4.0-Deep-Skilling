import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        logger.error("Error message");
        logger.warn("Warning message");
        logger.info("Info message");
        logger.debug("Debug message");
    }
}
