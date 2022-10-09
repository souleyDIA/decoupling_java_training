package fr.lernejo.logger;


public class ContextualLogger implements Logger {

    private final FilteredLogger filteredLogger;
    private final String className;

    public ContextualLogger(FilteredLogger filteredLogger, String className) {
        this.filteredLogger = filteredLogger;
        this.className = className;
    }

    @Override
    public void log(String message) {
        filteredLogger.log("[" + java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "] [" + className + "] " + message);
    }

}
