package fr.lernejo.guessgame;
import java.security.SecureRandom;


public class Launcher {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("To play with a human player, enter -interactive");
            System.out.println("To play with a computer player, enter -auto and a number");
        } 
        
        else if (args[0].equals("-interactive")) {
            Player player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            int randomNumber = random.nextInt(10);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } 
        
        else if (args[0].equals("-auto") && args.length == 2) {
            Player player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            int randomNumber = Integer.parseInt(args[1]);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(1000);
        } 
        
        else {
            System.out.println("Please enter a parameter");
            System.out.println("To play with a human player, enter -interactive");
            System.out.println("To play with a computer player, enter -auto and a number");
        }
    }     
}

//mvn compile exec:java -Dexec.mainClass="com.github.lernejo.korekto.toolkit.launcher.GradingJobLauncher" -Dexec.args="-s=souleyDIA"