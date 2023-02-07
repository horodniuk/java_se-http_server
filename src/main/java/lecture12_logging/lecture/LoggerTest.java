package lecture12_logging.lecture;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        LOGGER.error("TEST_STRff");
        LOGGER.info("TEST_STR");
        LOGGER.debug("TEST_STR");
    }
}
