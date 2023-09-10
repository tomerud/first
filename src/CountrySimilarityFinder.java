import java.util.ArrayList;
import java.util.List;

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
        countryList.add(new Country("Israel", 20770, 9177020, "Hebrew", "Israeli New Shekel",
                0.387, "Parliamentary democracy", "UTC+2", "Judaism", "Mediterranean", 33));
        // Add more countries with their attributes

        CountrySimilarityFinder finder = new CountrySimilarityFinder(countryList);

        String userInput = "Israel";
        String mostSimilarCountry = finder.findMostSimilarCountry(userInput);

        System.out.println("The most similar country to " + userInput + " is " + mostSimilarCountry);
    }
}
