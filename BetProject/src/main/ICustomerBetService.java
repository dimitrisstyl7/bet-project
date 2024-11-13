package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Interface for customer betting services, defining methods for calculating gains and presenting
 * results, as well as a default method for saving results to a text file.
 */
public sealed interface ICustomerBetService permits BetOrganization {

    /**
     * Calculates and updates the gains for each customer based on their bets and the actual
     * game outcomes. Each customer’s total gains are updated if they win their bets.
     */
    void calculateGainsPerCustomer();

    /**
     * Displays the betting results of each customer to the console and saves these results
     * to a text file for record-keeping.
     */
    void showCustomersResults();

    /**
     * Saves the provided betting results to a default text file named "bet-results.txt".
     * <p>
     * This method writes the betting results to a text file, ensuring that all customer
     * results are persistently stored. In case of an error during the file-writing
     * process, an error message is displayed.
     * </p>
     *
     * @param output The string containing results data to be saved to the file.
     */
    default void printCustomersResultsToTextFile(String output) {
        try {
            String fileName = "bet-results.txt";
            Files.writeString(Path.of(fileName), output);
            System.out.printf("%n> Customers results saved to '%s'.%n", fileName);
        } catch (IOException e) {
            System.out.printf("Something went wrong while trying to save the customers results. Error: %s", e.getMessage());
        }
    }

}
