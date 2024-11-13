package bet;

/**
 * Represents a football betting option with specific odds and three possible outcomes.
 * <p>
 * This class extends {@link Bet} to model bets specific to football games, where the
 * betting choices include:
 * <ul>
 *     <li>'1' - a win for the home team</li>
 *     <li>'X' - a draw between the two teams</li>
 *     <li>'2' - a win for the away team</li>
 * </ul>
 * </p>
 */
public final class FootballBet extends Bet {

    /**
     * Constructs a new {@code FootballBet} instance with the specified game details and odds.
     * <p>
     * The betting choices for a football game are predefined as '1', 'X', and '2', representing
     * the possible outcomes of a home win, draw, or away win, respectively.
     * </p>
     *
     * @param game A {@link String} describing the football game matchup (e.g., "Manchester United vs Liverpool").
     * @param odds The decimal odds associated with this betting option.
     */
    public FootballBet(String game, double odds) {
        super(game, odds, new char[]{'1', 'X', '2'});
    }

}
