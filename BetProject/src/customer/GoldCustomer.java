package customer;

/**
 * Represents a Gold-level customer, a specialized type of {@link Customer} with enhanced betting limits.
 * <p>
 * The {@code GoldCustomer} class is a final extension of the {@link Customer} class, and is constructed
 * with the {@link CustomerType#GOLD} type, which assigns it a higher betting limit as defined in {@link CustomerType}.
 * </p>
 */
public final class GoldCustomer extends Customer {

    /**
     * Constructs a new Gold-level customer with the specified full name.
     *
     * @param fullName The full name of the Gold customer.
     */
    public GoldCustomer(String fullName) {
        super(fullName, CustomerType.GOLD);
    }

}
