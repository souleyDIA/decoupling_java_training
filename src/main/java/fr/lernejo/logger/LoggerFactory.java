package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String className, String path) {
        return new ContextualLogger(new CompositeLogger(new FileLogger(path), new ConsoleLogger()), className);
    }

}
