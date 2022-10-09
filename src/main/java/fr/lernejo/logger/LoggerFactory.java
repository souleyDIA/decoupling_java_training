package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String className, String path){
        Predicate<String> filter = s -> !s.contains("Simulation");
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger(path);
        Logger compositeLogger = new CompositeLogger(consoleLogger, fileLogger);
        FilteredLogger filteredLogger = new FilteredLogger(compositeLogger, filter);  
        return new ContextualLogger(filteredLogger, className);
    }
}
