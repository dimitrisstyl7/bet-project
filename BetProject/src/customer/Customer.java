package customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer with betting capabilities, including a list of bets, total gains,
 * and spending information.
 * <p>
 * This class can be extended to support various customer tiers (e.g., Basic, Gold, Platinum),
 * each with a different betting limit defined by {@link CustomerType}.
 * </p>
 */
public sealed class Customer implements IGiveBetList permits GoldCustomer, PlatinumCustomer {

    /**
     * The full name of the customer.
     */
    private final String fullName;

    /**
     * The maximum stake the customer can place on any bet.
     * <p>
     * This field is determined by the customer's type (Basic, Gold, Platinum) and reflects the
     * maximum amount the customer is allowed to bet on any single bet.
     * </p>
     */
    private final int maxStake;

    /**
     * A list of {@link CustomerBet} objects placed by the customer.
     */
    private final List<CustomerBet> customerBets = new ArrayList<>();

    /**
     * The total amount of money the customer has gained from their successful bets.
     */
    private double totalGains = 0.0;

    /**
     * The total amount of money the customer has spent on placing bets.
     */
    private double totalSpent = 0.0;

    /**
     * Constructs a customer with a basic betting limit, corresponding to the {@link CustomerType#BASIC} type.
     *
     * @param fullName The full name of the customer.
     */
    public Customer(String fullName) {
        this.fullName = fullName;
        this.maxStake = CustomerType.BASIC.getMaxStake();
    }

    /**
     * Constructs a customer with a specified customer type that determines the betting limit.
     *
     * @param fullName     The full name of the customer.
     * @param customerType The type of customer (e.g., {@link CustomerType#GOLD}, {@link CustomerType#PLATINUM}),
     *                     which sets the maximum stake limit.
     */
    public Customer(String fullName, CustomerType customerType) {
        this.fullName = fullName;

        switch (customerType) {
            case CustomerType.GOLD -> this.maxStake = CustomerType.GOLD.getMaxStake();
            case CustomerType.PLATINUM -> this.maxStake = CustomerType.PLATINUM.getMaxStake();
            default -> this.maxStake = CustomerType.BASIC.getMaxStake();
        }
    }

    /**
     * Gets the maximum stake limit for the customer based on their {@link CustomerType}.
     *
     * @return The maximum stake amount allowed for this customer, as determined by their customer type.
     */
    public int getMaxStake() {
        return maxStake;
    }

    /**
     * Adds a new bet to the customer's list of bets.
     *
     * @param customerBet The {@link CustomerBet} object representing the bet to be added.
     */
    public void addCustomerBet(CustomerBet customerBet) {
        customerBets.add(customerBet);
    }

    /**
     * Increases the customer's total gains by a specified amount.
     *
     * @param gain The amount to add to the customer's total gains.
     */
    public void increaseTotalGains(double gain) {
        totalGains += gain;
    }

    /**
     * Increases the total amount the customer has spent on bets by a specified amount.
     *
     * @param spent The amount to add to the customer's total spent amount.
     */
    public void increaseTotalSpent(double spent) {
        totalSpent += spent;
    }

    /**
     * Retrieves the list of bets placed by this customer.
     *
     * @return A {@link List} of {@link CustomerBet} objects representing the bets placed by the customer.
     */
    @Override
    public List<CustomerBet> getCustomerBetList() {
        return customerBets;
    }

    /**
     * Returns a string representation of the customer, including their full name,
     * total amount spent, and total gains.
     *
     * @return A string summarizing the customer's information.
     */
    @Override
    public String toString() {
        return "Customer full name: " + fullName +
               ",\nCustomer total spent: " + totalSpent +
               ",\nCustomer total gains: " + totalGains;
    }

}
