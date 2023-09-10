import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountrySimilarityFinder {
    private List<Country> countries;

    public CountrySimilarityFinder(List<Country> countries) {
        this.countries = countries;
    }

    public String findMostSimilarCountry(String inputCountry) {
        Country input = null;
        for (Country country : countries) {
            if (country.getName().equalsIgnoreCase(inputCountry)) {
                input = country;
                break;
            }
        }

        if (input == null) {
            return "Country not found in the dataset.";
        }

        Country mostSimilar = null;
        double highestSimilarity = 0.0;

        for (Country country : countries) {
            if (country != input) {
                double similarity = input.calculateSimilarity(country);
                if (similarity > highestSimilarity) {
                    highestSimilarity = similarity;
                    mostSimilar = country;
                }
            }
        }

        if (mostSimilar == null) {
            return "No similar country found.";
        }

        return mostSimilar.getName();
    }

    public static void main(String[] args) {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Israel", "Asia", "Middle Eastern", "Developed", "Medium", "Light"));
        countryList.add(new Country("USA", "North America", "Western", "Developed", "Tall", "Various"));
        countryList.add(new Country("India", "Asia", "South Asian", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Germany", "Europe", "Western", "Developed", "Tall", "Light"));
        countryList.add(new Country("Australia", "Oceania", "Western", "Developed", "Tall", "Light"));
        countryList.add(new Country("China", "Asia", "East Asian", "Developing", "Medium", "Light"));
        countryList.add(new Country("South Africa", "Africa", "Southern African", "Developing", "Medium", "Various"));
        countryList.add(new Country("Mexico", "North America", "Latin", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Brazil", "South America", "Latin", "Developing", "Tall", "Various"));
        countryList.add(new Country("Japan", "Asia", "East Asian", "Developed", "Short", "Light"));
        countryList.add(new Country("Russia", "Europe", "Eastern European", "Developed", "Tall", "Light"));
        countryList.add(new Country("Canada", "North America", "Western", "Developed", "Tall", "Various"));
        countryList.add(new Country("Italy", "Europe", "Southern European", "Developed", "Medium", "Light"));
        countryList.add(new Country("Spain", "Europe", "Southern European", "Developed", "Medium", "Light"));
        countryList.add(new Country("Sweden", "Europe", "Northern European", "Developed", "Tall", "Light"));
        countryList.add(new Country("Norway", "Europe", "Northern European", "Developed", "Tall", "Light"));
        countryList.add(new Country("Argentina", "South America", "Latin", "Developing", "Tall", "Light"));
        countryList.add(new Country("Egypt", "Africa", "North African", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Nigeria", "Africa", "Western African", "Developing", "Tall", "Dark"));
        countryList.add(new Country("New Zealand", "Oceania", "Western", "Developed", "Medium", "Various"));
        countryList.add(new Country("Greece", "Europe", "Southern European", "Developed", "Medium", "Light"));
        countryList.add(new Country("Switzerland", "Europe", "Western European", "Developed", "Medium", "Light"));
        countryList.add(new Country("Ireland", "Europe", "Western European", "Developed", "Medium", "Light"));
        countryList.add(new Country("Finland", "Europe", "Northern European", "Developed", "Tall", "Light"));
        countryList.add(new Country("Turkey", "Europe/Asia", "Middle Eastern", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Saudi Arabia", "Asia", "Middle Eastern", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Cuba", "North America", "Latin", "Developing", "Medium", "Various"));
        countryList.add(new Country("Vietnam", "Asia", "Southeast Asian", "Developing", "Short", "Light"));
        countryList.add(new Country("Colombia", "South America", "Latin", "Developing", "Medium", "Various"));
        countryList.add(new Country("Venezuela", "South America", "Latin", "Developing", "Medium", "Various"));
        countryList.add(new Country("Peru", "South America", "Latin", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Ukraine", "Europe", "Eastern European", "Developing", "Medium", "Light"));
        countryList.add(new Country("Chile", "South America", "Latin", "Developed", "Medium", "Light"));
        countryList.add(new Country("Ethiopia", "Africa", "Eastern African", "Developing", "Tall", "Dark"));
        countryList.add(new Country("Kenya", "Africa", "Eastern African", "Developing", "Tall", "Dark"));
        countryList.add(new Country("Pakistan", "Asia", "South Asian", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Korea, South", "Asia", "East Asian", "Developed", "Medium", "Light"));
        countryList.add(new Country("Korea, North", "Asia", "East Asian", "Developing", "Medium", "Light"));
        countryList.add(new Country("Indonesia", "Asia", "Southeast Asian", "Developing", "Medium", "Brown"));
        countryList.add(new Country("Thailand", "Asia", "Southeast Asian", "Developing", "Medium", "Brown"));


        CountrySimilarityFinder finder = new CountrySimilarityFinder(countryList);

        Scanner scanner = new Scanner(System.in);

        while (true) {  // Infinite loop to keep asking the user for countries
            System.out.print("Enter the name of the country you want to find a similar country for: ");
            String countryName = scanner.nextLine();

            String mostSimilarCountry = finder.findMostSimilarCountry(countryName);  // This line is adjusted.

            if (!mostSimilarCountry.equals("Country not found in the dataset.") && !mostSimilarCountry.equals("No similar country found.")) {
                System.out.println("The most similar country to " + countryName + " is " + mostSimilarCountry);
            } else {
                System.out.println(mostSimilarCountry);
            }

            System.out.print("Would you like to try another country? (y/n): ");
            String anotherTry = scanner.nextLine();

            if (!anotherTry.equalsIgnoreCase("y")) {
                break;  // Exit the loop if the user doesn't want to continue
            }
        }
    }
}
