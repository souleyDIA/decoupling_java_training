package fr.lernejo.gessgame;

public interface Player {
    
    long askNextGuess();

    /**
     * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
     */
    void respond(boolean lowerOrGreater);
    
}
