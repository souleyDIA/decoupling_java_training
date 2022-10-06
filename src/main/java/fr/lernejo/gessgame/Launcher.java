package fr.lernejo.gessgame;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        Simulation simulation = new Simulation(player);
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(10);
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();
    }
}

