package main;

import bet.Bet;
import customer.Customer;
import util.DummyData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entry point for simulating a betting organization, generating random game results,
 * and calculating and displaying customer betting results.
 * <p>
 * The {@code main.BetMain} class orchestrates the betting simulation by creating dummy data
 * for bets and customers, assigning random results to each bet, calculating gains for
 * each customer based on their betting outcomes, and displaying the results in the console.
 * </p>
 */
public class BetMain {

    /**
     * Main method that drives the betting simulation process.
     * <p>
     * This method initializes the betting organization, generates dummy data for both bets and customers,
     * assigns random game results to each bet, calculates each customer’s gains based on their bet outcomes,
     * and finally displays and saves the results.
     * </p>
     * <p>
     * Steps:
     * <ul>
     *     <li>Creates a list of bets and shuffles them for randomness.</li>
     *     <li>Generates and adds dummy customers and assigns random bets to them.</li>
     *     <li>Generates random game results using the {@link GameEmulator} singleton instance.</li>
     *     <li>Calculates and updates gains for each customer based on their bet outcomes.</li>
     *     <li>Displays the results and saves them to a file using the {@link BetOrganization} singleton instance.</li>
     * </ul>
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        final BetOrganization betOrganization = BetOrganization.INSTANCE;
        final GameEmulator gameEmulator = GameEmulator.INSTANCE;

        // Create a list to hold all dummy bets data (both football and basketball)
        final List<Bet> bets = new ArrayList<>();

        // Add football bets to the list
        bets.addAll(DummyData.generateDummyFootballBets());

        // Add basketball bets to the list
        bets.addAll(DummyData.generateDummyBasketballBets());

        // Shuffle bets list
        Collections.shuffle(bets);

        // Add generated bets to betOrganization
        bets.forEach(betOrganization::addBet);

        // Create a list of dummy customers (BASIC, GOLD, PLATINUM)
        List<Customer> customers = DummyData.generateDummyCustomers();

        // Populate random customers with dummy bets
        DummyData.populateCustomersWithRandomBets(customers, bets);

        // Add generated bets and customers to betOrganization
        customers.forEach(betOrganization::addCustomer);

        // Generate random game results
        gameEmulator.generateRandomGameResults(bets);

        // Calculate gains per customer
        betOrganization.calculateGainsPerCustomer();

        // Show customers results
        betOrganization.showCustomersResults();
    }

}