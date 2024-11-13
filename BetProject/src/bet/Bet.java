package bet;

/**
 * Represents a generic betting option for a sports game, with specific odds, choices,
 * and a result that can be set once the game outcome is determined.
 * <p>
 * This abstract class serves as a base for different types of bets, such as {@link BasketballBet}
 * and {@link FootballBet}, each having distinct choices and outcome possibilities based on the
 * type of sport. It encapsulates common properties like the game description, odds, available choices,
 * and the final result.
 * </p>
 * <p>
 * The available choices are represented as characters:
 * <ul>
 *     <li>For football bets: '1' for a win by the home team, 'X' for a draw, and '2' for an away team win.</li>
 *     <li>For basketball bets: '1' for a win by the first team and '2' for a win by the second team.</li>
 * </ul>
 * </p>
 */
public abstract sealed class Bet permits BasketballBet, FootballBet {

    /**
     * A {@link String} describing the game matchup (e.g., "Team A vs Team B").
     */
    private final String game;

    /**
     * The decimal odds associated with this bet, used to calculate potential payouts.
     */
    private final double odds;

    /**
     * An array of characters representing the possible outcomes for the bet.
     * <p>
     * This array varies depending on the type of sport. For example:
     * <ul>
     *     <li>For football: '1', 'X', '2'.</li>
     *     <li>For basketball: '1', '2'.</li>
     * </ul>
     * </p>
     */
    private final char[] availableChoices;

    /**
     * The final result of the game associated with this bet.
     * <p>
     * Initially set to '-', indicating the result is not yet determined.
     * This value is updated using the {@link #setGameResult(char)} method once the game outcome is known.
     * </p>
     */
    private char gameResult;

    /**
     * Constructs a new {@code Bet} instance with the specified game details, odds, and available choices.
     *
     * @param game             A {@link String} describing the game matchup (e.g., "Team A vs Team B").
     * @param odds             The decimal odds for this bet.
     * @param availableChoices An array of characters representing the possible outcomes for the bet.
     */
    public Bet(String game, double odds, char[] availableChoices) {
        this.game = game;
        this.odds = odds;
        this.availableChoices = availableChoices;
        this.gameResult = '-';
    }

    /**
     * Retrieves the odds associated with this bet.
     *
     * @return The odds for this bet as a {@code double}.
     */
    public double getOdds() {
        return odds;
    }

    /**
     * Retrieves the final result of the game associated with this bet.
     *
     * @return The game result as a {@code char}; '-' if the result is not yet set.
     */
    public char getGameResult() {
        return gameResult;
    }

    /**
     * Sets the result of the game for this bet.
     * <p>
     * This should be one of the values in {@link #getAvailableChoices()}, representing the
     * outcome as per the betting choices defined for the specific sport type.
     * </p>
     *
     * @param gameResult A {@code char} representing the outcome of the game.
     */
    public void setGameResult(char gameResult) {
        this.gameResult = gameResult;
    }

    /**
     * Retrieves the available choices for this bet.
     *
     * @return An array of {@code char} values representing the possible outcomes for this bet.
     */
    public char[] getAvailableChoices() {
        return availableChoices;
    }

}
