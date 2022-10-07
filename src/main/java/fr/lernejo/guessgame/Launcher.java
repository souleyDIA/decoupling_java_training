package fr.lernejo.guessgame;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        Simulation simulation = new Simulation(player);
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(10);
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed(2);
    }
}

//mvn compile exec:java -Dexec.mainClass="com.github.lernejo.korekto.toolkit.launcher.GradingJobLauncher" -Dexec.args="-s=souleyDIA"