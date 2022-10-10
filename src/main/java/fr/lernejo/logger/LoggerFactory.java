package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String className){
        Predicate<String> filter = s -> !s.contains("simulation");
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("./ComputerPlayerLogTest.txt");
        Logger compositeLogger = new CompositeLogger(consoleLogger, fileLogger);
        Logger contextualLogger = new ContextualLogger(className, compositeLogger);
        return new FilteredLogger(contextualLogger, filter); 
    }
}
