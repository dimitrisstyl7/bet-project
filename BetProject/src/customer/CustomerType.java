package customer;

/**
 * Enum representing the types of customers, primarily used to determine betting limits.
 * <p>
 * Each customer type specifies a different maximum stake limit, which is represented by
 * the {@code maxStake} field. The stake limit varies by customer type as follows:
 * </p>
 * <ul>
 *     <li>{@link #BASIC} - Standard customer with a basic betting limit of 100 units.</li>
 *     <li>{@link #GOLD} - Gold-level customer with a higher betting limit of 1,000 units.</li>
 *     <li>{@link #PLATINUM} - Platinum-level customer with the highest betting limit of 2,000 units.</li>
 * </ul>
 */
public enum CustomerType {

    /**
     * Standard customer with a basic betting limit of 100 units.
     */
    BASIC(100),

    /**
     * Gold-level customer with a higher betting limit of 1,000 units.
     */
    GOLD(1000),

    /**
     * Platinum-level customer with the highest betting limit of 2,000 units.
     */
    PLATINUM(2000);

    /**
     * The maximum stake limit for this customer type.
     * <p>
     * This field represents the maximum amount that a customer of a specific type
     * is allowed to stake on a bet. The limit varies depending on the customer type:
     * <ul>
     *     <li>{@link #BASIC} - 100 units</li>
     *     <li>{@link #GOLD} - 1,000 units</li>
     *     <li>{@link #PLATINUM} - 2,000 units</li>
     * </ul>
     * </p>
     */
    private final int maxStake;

    /**
     * Initializes a {@code CustomerType} with a specific maximum stake limit.
     *
     * @param maxStake The maximum stake limit associated with this customer type.
     */
    CustomerType(int maxStake) {
        this.maxStake = maxStake;
    }

    /**
     * Returns the maximum stake limit for this customer type.
     *
     * @return The maximum stake allowed for this type of customer.
     */
    public int getMaxStake() {
        return maxStake;
    }

}
