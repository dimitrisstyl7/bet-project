package main;

import bet.Bet;
import customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Singleton class representing the organization responsible for managing customer betting activities.
 * <p>
 * The {@code main.BetOrganization} maintains a list of customers and their respective bets, providing
 * functionalities to add customers, add bets, calculate gains based on bet outcomes, and display
 * and save betting results.
 * </p>
 * <p>
 * This class is particularly useful for managing betting operations and simulating betting results.
 * </p>
 */
public enum BetOrganization implements ICustomerBetService {

    /**
     * The singleton instance of the {@code main.BetOrganization}.
     */
    INSTANCE;

    /**
     * A list of {@link Customer} objects representing all customers in the organization.
     */
    private final List<Customer> customers = new ArrayList<>();

    /**
     * A list of {@link Bet} objects representing all bets placed within the organization.
     */
    private final List<Bet> bets = new ArrayList<>();

    /**
     * Adds a new customer to the organization.
     *
     * @param customer The {@link Customer} to be added.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Adds a new bet to the organization’s list of bets.
     *
     * @param bet The {@link Bet} object to be added.
     */
    public void addBet(Bet bet) {
        bets.add(bet);
    }

    /**
     * Calculates and updates the gains for each customer by evaluating the outcomes of their bets.
     * <p>
     * This method iterates through each customer and their bets, checking if the bet outcome matches
     * the customer’s choice. If it does, the method calculates a payout based on the bet stake and odds,
     * adds the payout to the customer's total gains, and updates the payout in the respective {@link customer.CustomerBet} object.
     * </p>
     */
    @Override
    public void calculateGainsPerCustomer() {
        customers.forEach(customer ->
                customer.getCustomerBetList().forEach(customerBet -> {
                    if (customerBet.getChoice() == customerBet.getBet().getGameResult()) {
                        double payout = customerBet.getStake() * customerBet.getBet().getOdds();
                        customerBet.setPayout(payout);
                        customer.increaseTotalGains(payout);
                    }
                })
        );
    }

    /**
     * Displays the results of each customer’s bets to the console and saves the results to a file.
     * <p>
     * This method generates a summary of each customer’s betting results, prints it to the console,
     * and then calls {@link ICustomerBetService#printCustomersResultsToTextFile(String)} to save
     * the results to a text file.
     * </p>
     */
    @Override
    public void showCustomersResults() {
        StringBuilder output = new StringBuilder();
        output.append("\n------------------ Results ------------------\n");
        IntStream.range(0, customers.size()).forEach(index -> {
            Customer customer = customers.get(index);
            output.append('\n')
                    .append(customer)
                    .append(index < customers.size() - 1 ? "\n\n##############################################\n" : '\n');
        });
        output.append("\n--------------- End of results ---------------");
        System.out.println(output); // print the results to console
        output.deleteCharAt(0); // remove the new line (\n) char at the beginning of the output variable
        printCustomersResultsToTextFile(output.toString()); // save results to a txt file
    }

}
