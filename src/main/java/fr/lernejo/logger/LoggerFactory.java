package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String className){
        Predicate<String> filter = s -> !s.contains("Player");
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("src/test/java/ComputerPlayerLogTest.txt");
        Logger compositeLogger = new CompositeLogger(consoleLogger, fileLogger);
        FilteredLogger filteredLogger = new FilteredLogger(compositeLogger, filter);  
        return new ContextualLogger(filteredLogger, className);
    }
}
