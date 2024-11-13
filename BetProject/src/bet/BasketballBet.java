package bet;

/**
 * Represents a basketball betting option with specific odds and available choices.
 * <p>
 * This class is a specialized type of {@link Bet} for basketball games, where the
 * available betting choices are limited to two possible outcomes:
 * <ul>
 *     <li>'1' - indicating a win for the first team</li>
 *     <li>'2' - indicating a win for the second team</li>
 * </ul>
 * </p>
 */
public final class BasketballBet extends Bet {

    /**
     * Constructs a new {@code BasketballBet} instance with the specified game details and odds.
     * <p>
     * The betting choices for a basketball game are predefined as '1' and '2', representing
     * the two possible outcomes for the game.
     * </p>
     *
     * @param game A {@link String} describing the basketball game matchup (e.g., "Lakers vs Warriors").
     * @param odds The decimal odds associated with this betting option.
     */
    public BasketballBet(String game, double odds) {
        super(game, odds, new char[]{'1', '2'});
    }

}
