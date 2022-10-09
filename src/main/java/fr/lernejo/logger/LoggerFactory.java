package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String className) {
        return new ContextualLogger(new ConsoleLogger(), className);
    }
}
