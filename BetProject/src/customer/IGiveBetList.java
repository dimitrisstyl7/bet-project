package customer;

import java.util.List;

/**
 * Interface for classes that provide access to a list of customer bets.
 * <p>
 * Implementing classes should provide functionality for retrieving a list of
 * bets placed by a customer.
 * </p>
 */
public sealed interface IGiveBetList permits Customer {

    /**
     * Retrieves the list of bets associated with a customer.
     *
     * @return A {@link List} of {@link CustomerBet} objects representing the bets placed by the customer.
     */
    List<CustomerBet> getCustomerBetList();

}
