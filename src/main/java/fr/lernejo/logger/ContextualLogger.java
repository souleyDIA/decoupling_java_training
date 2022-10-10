package fr.lernejo.logger;


public class ContextualLogger implements Logger {

    private final Logger logger;
    private final String className;

    public ContextualLogger(String className, Logger logger) {
        this.logger = logger;
        this.className = className;
    }

    @Override
    public void log(String message) {
        logger.log("[" + java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "] [" + className + "] " + message);
    }

}
