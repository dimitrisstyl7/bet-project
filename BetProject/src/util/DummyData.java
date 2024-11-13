package util;

import bet.BasketballBet;
import bet.Bet;
import bet.FootballBet;
import customer.Customer;
import customer.CustomerBet;
import customer.GoldCustomer;
import customer.PlatinumCustomer;

import java.util.List;
import java.util.Random;

/**
 * A utility class for generating dummy data to simulate betting scenarios,
 * including predefined football and basketball bets and customer data.
 * <p>
 * This class provides methods to create lists of dummy bets and customers, as well as
 * to randomly populate customers with bets. The generated data can be used for testing
 * or simulating a betting application.
 * </p>
 */
public final class DummyData {

    /**
     * A {@link Random} instance used to generate random numbers for various purposes, such as
     * selecting random customers, bets, stakes, and choices.
     * <p>
     * This field is used throughout the class to simulate random betting scenarios, ensuring
     * variability in generated data for each run of the program.
     * </p>
     */
    private static final Random random = new Random();

    /**
     * Generates a list of dummy football bets with game details and associated odds.
     * <p>
     * This method creates a predefined list of football bets, where each bet contains
     * the names of the teams playing and the associated odds. These dummy data are used
     * for simulating betting data.
     * </p>
     *
     * @return A list of {@link FootballBet} objects, each representing a football game and its odds.
     */
    public static List<FootballBet> generateDummyFootballBets() {
        return List.of(
                new FootballBet("Manchester United vs Newcastle United", 1.9),
                new FootballBet("Real Madrid vs Sevilla", 1.6),
                new FootballBet("Bayern Munich vs Borussia Dortmund", 1.8),
                new FootballBet("Juventus vs Napoli", 2.4),
                new FootballBet("Paris Saint-Germain vs Lyon", 1.7),
                new FootballBet("Chelsea vs Arsenal", 2.1),
                new FootballBet("Liverpool vs Manchester City", 2.3),
                new FootballBet("Atletico Madrid vs Valencia", 1.9),
                new FootballBet("AC Milan vs Inter Milan", 2.0),
                new FootballBet("Ajax vs Feyenoord", 2.2),
                new FootballBet("Sporting CP vs Benfica", 2.3),
                new FootballBet("Porto vs Braga", 1.8),
                new FootballBet("Tottenham vs Aston Villa", 2.4),
                new FootballBet("Barcelona vs Real Betis", 1.5),
                new FootballBet("Celtic vs Rangers", 2.0),
                new FootballBet("Leipzig vs Eintracht Frankfurt", 2.1)
        );
    }

    /**
     * Generates a list of dummy basketball bets with game details and associated odds.
     * <p>
     * This method creates a predefined list of basketball bets, where each bet contains
     * the names of the teams playing and the associated odds. These dummy data are used
     * for simulating betting data.
     * </p>
     *
     * @return A list of {@link BasketballBet} objects, each representing a basketball game and its odds.
     */
    public static List<BasketballBet> generateDummyBasketballBets() {
        return List.of(
                new BasketballBet("Los Angeles Lakers vs Golden State Warriors", 1.8),
                new BasketballBet("Brooklyn Nets vs Boston Celtics", 2.1),
                new BasketballBet("Miami Heat vs Milwaukee Bucks", 2.2),
                new BasketballBet("Chicago Bulls vs Philadelphia 76ers", 2.3),
                new BasketballBet("Phoenix Suns vs Dallas Mavericks", 1.9),
                new BasketballBet("Denver Nuggets vs New Orleans Pelicans", 1.7),
                new BasketballBet("Toronto Raptors vs Cleveland Cavaliers", 2.0),
                new BasketballBet("Indiana Pacers vs Detroit Pistons", 2.4),
                new BasketballBet("Washington Wizards vs Orlando Magic", 2.5),
                new BasketballBet("Memphis Grizzlies vs Sacramento Kings", 1.9),
                new BasketballBet("Atlanta Hawks vs Charlotte Hornets", 2.3),
                new BasketballBet("Minnesota Timberwolves vs Utah Jazz", 1.8),
                new BasketballBet("Oklahoma City Thunder vs Houston Rockets", 2.6),
                new BasketballBet("Los Angeles Clippers vs Portland Trail Blazers", 1.6),
                new BasketballBet("New York Knicks vs Sacramento Kings", 2.2),
                new BasketballBet("Dallas Mavericks vs Toronto Raptors", 1.9),
                new BasketballBet("Golden State Warriors vs Phoenix Suns", 1.7),
                new BasketballBet("Boston Celtics vs Chicago Bulls", 1.8),
                new BasketballBet("Miami Heat vs Brooklyn Nets", 2.1)
        );
    }

    /**
     * Generates a list of dummy customers with various customer types.
     * <p>
     * This method creates a predefined list of customers, including basic, gold, and platinum types.
     * Each customer has a name and is assigned a specific type, which determines attributes like
     * maximum betting limits.
     * These dummy data are used for simulating customer data in the betting application.
     * </p>
     *
     * @return A list of {@link Customer} objects, representing customers with varying types and associated properties.
     */
    public static List<Customer> generateDummyCustomers() {
        return List.of(
                new Customer("John Smith"),
                new Customer("Emily Johnson"),
                new Customer("Oliver Anderson"),
                new Customer("Ava Thompson"),
                new Customer("William King"),
                new GoldCustomer("Michael Brown"),
                new GoldCustomer("Jessica Davis"),
                new GoldCustomer("Liam Harris"),
                new GoldCustomer("Mia Clark"),
                new GoldCustomer("James Lopez"),
                new PlatinumCustomer("David Wilson"),
                new PlatinumCustomer("Sophia Martinez"),
                new PlatinumCustomer("Noah Lewis"),
                new PlatinumCustomer("Amelia Robinson"),
                new PlatinumCustomer("Benjamin Adams")
        );
    }

    /**
     * Populates random customers with random bets from the provided list of bets.
     * <p>
     * This method generates a random number of customer bets by associating selected
     * bets with randomly chosen customers. Each generated bet is assigned a random stake
     * within the customer's allowed maximum, and a random choice is selected from the
     * available choices corresponding to the bet type (football or basketball).
     * </p>
     * <p>
     * The generated bets are then added to the respective customer objects' list of bets,
     * allowing each customer to have a record of their placed bets.
     * </p>
     *
     * @param customers A list of {@link Customer} objects, representing the customers who may place bets.
     * @param bets      A list of {@link Bet} objects, representing available bets that customers can place.
     */
    public static void populateCustomersWithRandomBets(List<Customer> customers, List<Bet> bets) {
        final int randomNumberOfCustomers = random.nextInt(1, customers.size());

        random.ints(randomNumberOfCustomers, 0, customers.size())
                .forEach(customerIndex -> {
                    Customer customer = customers.get(customerIndex);
                    Bet bet = bets.get(random.nextInt(bets.size()));

                    int stake = random.nextInt(1, customer.getMaxStake());
                    char[] availableChoices = bet.getAvailableChoices();
                    char choice = availableChoices[random.nextInt(availableChoices.length)];

                    customer.increaseTotalSpent(stake);
                    customer.addCustomerBet(new CustomerBet(bet, stake, choice));
                });
    }

}
