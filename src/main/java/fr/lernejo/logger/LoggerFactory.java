package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String className){
        Predicate<String> filter = s -> !s.contains("simulation");
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("src/test/java/ComputerPlayerLogTest.txt");
        Logger compositeLogger = new CompositeLogger(consoleLogger, fileLogger);
        Logger contextualLogger = new ContextualLogger(className, compositeLogger);
        return new FilteredLogger(contextualLogger, filter); 
    }
}

//mvn compile exec:java -Dexec.args="-s=souleyDIA" -Dgithub_token="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"