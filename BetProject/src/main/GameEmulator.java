package main;

import bet.Bet;

import java.util.List;
import java.util.Random;

/**
 * Singleton class for emulating game results by randomly selecting outcomes for a list of bets.
 * <p>
 * The {@code main.GameEmulator} provides a single instance, {@link #INSTANCE}, which can be used
 * to generate random game results for each {@link Bet} in a given list of bets.
 * </p>
 * <p>
 * This class is particularly useful for simulating or testing betting outcomes.
 * </p>
 */
public enum GameEmulator {

    /**
     * The singleton instance of the {@code main.GameEmulator}.
     */
    INSTANCE;

    /**
     * A {@link Random} instance used to generate random numbers for selecting random game results.
     * <p>
     * This field is used to randomly pick the game outcome from the available choices for each bet.
     * It is a crucial part of simulating the unpredictability of game results when testing or
     * emulating betting outcomes.
     * </p>
     */
    final Random random = new Random();

    /**
     * Generates random results for the given list of bets and sets the result on each bet.
     * <p>
     * This method iterates through each bet in the provided list and randomly selects a result from
     * the available choices for that particular bet. The chosen result is then set on the corresponding
     * bet using the {@link Bet#setGameResult(char)} method.
     * </p>
     *
     * @param bets A list of {@link Bet} objects, where each bet has a set of possible results.
     *             This method will assign a random result to each bet in the list.
     */
    public void generateRandomGameResults(List<Bet> bets) {
        bets.forEach(bet -> {
            char[] availableChoices = bet.getAvailableChoices();
            char result = availableChoices[random.nextInt(availableChoices.length)];
            bet.setGameResult(result);
        });
    }

}
