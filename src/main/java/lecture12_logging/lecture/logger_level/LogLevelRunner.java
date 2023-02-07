package lecture12_logging.lecture.logger_level;

import static lecture12_logging.lecture.logger_level.LogLevelTest.*;

public class LogLevelRunner {
    public static void main(String[] args) {
        try{
            int configParam = getConfigParam();
            LOGGER.info("Config param is {}", configParam);
        } catch(IllegalArgumentException e){
            LOGGER.error("Config param not found: " + e.getMessage());
        }
    }

    private static int getConfigParam() {
        Integer param = getConfigParamFromSystemEnvironment();
        if (param == null) {
            param = getConfigParamFromClasspathResource();
        }
        if(param != null){
            return param;
        }
        LOGGER.error("'config.param' is not avaialable");
        throw new IllegalStateException("'config.param' is not avaialable");
    }


}


