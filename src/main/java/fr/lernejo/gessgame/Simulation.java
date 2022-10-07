package fr.lernejo.gessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;
    // timer for the game
    private long startTime;
    private long endTime;

    public Simulation(Player player) {
        this.player = player;
    }
    
    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }
    
    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("You guessed the number");
            return true;
        }
        player.respond(guess < numberToGuess);
        return false;
    }
    
    public void loopUntilPlayerSucceed( int maxIteration) {

        startTime = System.currentTimeMillis();
        while (!nextRound() && maxIteration > 0) {
            maxIteration--;
        }
        
        if (maxIteration == 0 ) {
            logger.log("You didn't find the number");
        }

        endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        long minutes = time / 60000;
        long seconds = (time % 60000) / 1000;
        long milliseconds = time % 1000;
        System.out.println("time = " + minutes + ":" + seconds + "." + milliseconds);
    }

  }