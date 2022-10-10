package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer  implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private long min = 0;
    private long max = 100;
    private long guess = 50;

    @Override
    public long askNextGuess() {
        logger.log("Guessing " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            min = guess;
            guess = (max + min) / 2;
        } else {
            max = guess;
            guess = (max + min) / 2;
        }
    }
}
