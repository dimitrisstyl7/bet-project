package customer;

import bet.Bet;

/**
 * Represents a customer's individual bet, including the bet details, stake amount, choice, and potential payout.
 * <p>
 * Each {@code CustomerBet} instance encapsulates a specific {@link Bet}, the amount staked by the customer,
 * the customer's choice for the bet, and an adjustable payout amount.
 * </p>
 */
public final class CustomerBet {

    /**
     * The {@link Bet} object representing the details of the bet.
     */
    private final Bet bet;

    /**
     * The amount of money staked by the customer for this bet.
     */
    private final int stake;

    /**
     * The choice made by the customer for this bet.
     */
    private final char choice;

    /**
     * The payout amount for this bet, which is adjusted based on the outcome of the bet.
     */
    private double payout;

    /**
     * Constructs a new {@code CustomerBet} with specified details of the bet, stake, and choice.
     *
     * @param bet    The {@link Bet} object representing the details of the bet.
     * @param stake  The amount staked by the customer for this bet.
     * @param choice The choice made by the customer for this bet (represented as a character).
     */
    public CustomerBet(Bet bet, int stake, char choice) {
        this.bet = bet;
        this.stake = stake;
        this.choice = choice;
        payout = 0.0;
    }

    /**
     * Retrieves the bet details associated with this customer bet.
     *
     * @return The {@link Bet} object representing the details of the bet.
     */
    public Bet getBet() {
        return bet;
    }

    /**
     * Returns the amount of money staked on this bet.
     *
     * @return The amount of the stake placed by the customer.
     */
    public int getStake() {
        return stake;
    }

    /**
     * Returns the choice made by the customer for this bet.
     *
     * @return The customer's choice as a character.
     */
    public char getChoice() {
        return choice;
    }

    /**
     * Sets the payout amount for this bet based on its outcome.
     *
     * @param payout The calculated payout amount for this bet.
     */
    public void setPayout(double payout) {
        this.payout = payout;
    }

}
