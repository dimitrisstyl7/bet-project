package customer;

/**
 * Represents a Platinum-level customer, a specialized type of {@link Customer} with the highest betting limits.
 * <p>
 * The {@code PlatinumCustomer} class is a final extension of the {@link Customer} class, and is constructed
 * with the {@link CustomerType#PLATINUM} type, which assigns it the highest betting limit as defined in {@link CustomerType}.
 * </p>
 */
public final class PlatinumCustomer extends Customer {

    /**
     * Constructs a new Platinum-level customer with the specified full name.
     *
     * @param fullName The full name of the Platinum customer.
     */
    public PlatinumCustomer(String fullName) {
        super(fullName, CustomerType.PLATINUM);
    }

}
